package br.com.fiap.hospital.agendamentos.services;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.CreateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.entities.AppointmentEntity;
import br.com.fiap.hospital.agendamentos.entities.UserEntity;
import br.com.fiap.hospital.agendamentos.enumeration.AppointmentStatus;
import br.com.fiap.hospital.agendamentos.repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final UserService userService;


    public AppointmentDTO createAppointment(final CreateAppointmentDTO createAppointmentDTO) {

        var doctorEntity = UserEntity.builder().id(createAppointmentDTO.doctorId()).build();
        var patientEntity = UserEntity.builder().id(createAppointmentDTO.patientId()).build();
        var appointmentEntity = appointmentRepository.save(
                AppointmentEntity.builder()
                        .appointmentDate(createAppointmentDTO.appointmentDate())
                        .reason(createAppointmentDTO.reason())
                        .location(createAppointmentDTO.location())
                        .specialty(createAppointmentDTO.specialty())
                        .doctor(doctorEntity)
                        .status(AppointmentStatus.SCHEDULED)
                        .patient(patientEntity)
                        .build()
        );

        appointmentEntity = appointmentRepository.save(appointmentEntity);

        return new AppointmentDTO(
                userService.getNameById(appointmentEntity.getPatient().getId()),
                userService.getNameById(appointmentEntity.getDoctor().getId()),
                appointmentEntity.getAppointmentDate(),
                appointmentEntity.getReason(),
                appointmentEntity.getNotes(),
                appointmentEntity.getStatus(),
                appointmentEntity.getSpecialty(),
                appointmentEntity.getLocation()
        );
    }
}
