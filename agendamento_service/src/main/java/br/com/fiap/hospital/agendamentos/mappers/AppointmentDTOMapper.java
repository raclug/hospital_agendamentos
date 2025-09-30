package br.com.fiap.hospital.agendamentos.mappers;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.CreateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.entities.AppointmentEntity;
import br.com.fiap.hospital.agendamentos.entities.UserEntity;
import br.com.fiap.hospital.agendamentos.enumeration.AppointmentStatus;

public class AppointmentDTOMapper {

    public static AppointmentDTO toDTO(final AppointmentEntity entity) {
        return new AppointmentDTO(
                entity.getId(),
                entity.getPatient().getId(),
                entity.getDoctor().getId(),
                entity.getAppointmentDate(),
                entity.getReason(),
                entity.getNotes(),
                entity.getStatus().name(),
                entity.getSpecialty(),
                entity.getLocation()
        );
    }

    public static AppointmentEntity toNewEntity(final CreateAppointmentDTO createAppointmentDTO) {
        var doctorEntity = UserEntity.builder().id(createAppointmentDTO.doctorId()).build();
        var patientEntity = UserEntity.builder().id(createAppointmentDTO.patientId()).build();

        return AppointmentEntity.builder()
                .doctor(doctorEntity)
                .patient(patientEntity)
                .appointmentDate(createAppointmentDTO.appointmentDate())
                .reason(createAppointmentDTO.reason())
                .status(AppointmentStatus.SCHEDULED)
                .specialty(createAppointmentDTO.specialty())
                .location(createAppointmentDTO.location())
                .build();
    }
}
