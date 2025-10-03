package br.com.fiap.hospital.agendamentos.services.impl;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.AppointmentNotificationDTO;
import br.com.fiap.hospital.agendamentos.dtos.CreateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.UpdateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.entities.AppointmentEntity;
import br.com.fiap.hospital.agendamentos.exceptions.AppointmentNotFoundException;
import br.com.fiap.hospital.agendamentos.mappers.AppointmentDTOMapper;
import br.com.fiap.hospital.agendamentos.producers.AppointmentProducer;
import br.com.fiap.hospital.agendamentos.repositories.AppointmentRepository;
import br.com.fiap.hospital.agendamentos.services.AppointmentService;
import br.com.fiap.hospital.agendamentos.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static br.com.fiap.hospital.agendamentos.mappers.AppointmentDTOMapper.toDTO;
import static br.com.fiap.hospital.agendamentos.mappers.AppointmentDTOMapper.toNewEntity;
import static br.com.fiap.hospital.agendamentos.utils.SecurityUtils.isPatient;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final AppointmentProducer appointmentProducer;

    private final UserService userService;

    @Override
    public AppointmentDTO createAppointment(final CreateAppointmentDTO createAppointmentDTO) {

        var appointmentEntity = toNewEntity(createAppointmentDTO);

        appointmentEntity = appointmentRepository.save(appointmentEntity);

        sendAppointmentNotification(appointmentEntity);

        return toDTO(appointmentEntity);
    }

    @Override
    public AppointmentDTO updateAppointment(final UpdateAppointmentDTO updateAppointmentDTO, final Long appointmentId) {

        var appointmentEntity = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("Agendamento não encontrado"));

        appointmentEntity.setAppointmentDate(updateAppointmentDTO.appointmentDate());
        appointmentEntity.setNotes(updateAppointmentDTO.notes());
        appointmentEntity.setStatus(updateAppointmentDTO.status());

        appointmentEntity = appointmentRepository.save(appointmentEntity);

        sendAppointmentNotification(appointmentEntity);

        return toDTO(appointmentEntity);
    }

    @Override
    public List<AppointmentDTO> searchAppointments(final Long patientId,
                                                   final Boolean onlyFuture,
                                                   final Principal principal) {

        var patientIdFilter = patientId;

        if (isPatient(principal)) {
            var jwt = (JwtAuthenticationToken) principal;
            patientIdFilter = userService.findIdByUsername(jwt.getToken().getSubject());
        }

        var now = LocalDateTime.now();
        Stream<AppointmentEntity> appointments;

        if (patientIdFilter != null) {
            appointments = appointmentRepository.findByPatientId(patientIdFilter).stream();
        } else {
            appointments = appointmentRepository.findAll().stream();
        }

        if (Boolean.TRUE.equals(onlyFuture)) {
            appointments = appointments.filter(a -> a.getAppointmentDate().isAfter(now));
        }

        return appointments.map(AppointmentDTOMapper::toDTO).toList();
    }

    private void sendAppointmentNotification(AppointmentEntity appointmentEntity) {

        var appointmentDTO = new AppointmentNotificationDTO(
                userService.getNameById(appointmentEntity.getPatient().getId()),
                userService.getNameById(appointmentEntity.getDoctor().getId()),
                appointmentEntity.getAppointmentDate(),
                appointmentEntity.getSpecialty(),
                appointmentEntity.getLocation()
        );

        appointmentProducer.sendAppointment(appointmentDTO);
    }
}
