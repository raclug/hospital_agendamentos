package br.com.fiap.hospital.agendamentos.services;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.CreateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.UpdateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.fiap.hospital.agendamentos.mappers.AppointmentDTOMapper.toDTO;
import static br.com.fiap.hospital.agendamentos.mappers.AppointmentDTOMapper.toNewEntity;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;


    public AppointmentDTO createAppointment(final CreateAppointmentDTO createAppointmentDTO) {

        var appointmentEntity = toNewEntity(createAppointmentDTO);

        appointmentEntity = appointmentRepository.save(appointmentEntity);

        return toDTO(appointmentEntity);
    }

    public AppointmentDTO updateAppointment(final UpdateAppointmentDTO updateAppointmentDTO) {

        var appointmentEntity = appointmentRepository.findById(updateAppointmentDTO.id())
                .orElseThrow(IllegalArgumentException::new);

        appointmentEntity.setAppointmentDate(updateAppointmentDTO.appointmentDate());
        appointmentEntity.setNotes(updateAppointmentDTO.notes());
        appointmentEntity.setStatus(updateAppointmentDTO.status());

        appointmentEntity = appointmentRepository.save(appointmentEntity);

        return toDTO(appointmentEntity);
    }
}
