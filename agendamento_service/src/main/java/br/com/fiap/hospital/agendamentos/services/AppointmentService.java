package br.com.fiap.hospital.agendamentos.services;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.CreateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.UpdateAppointmentDTO;

import java.security.Principal;
import java.util.List;

public interface AppointmentService {

    AppointmentDTO createAppointment(final CreateAppointmentDTO createAppointmentDTO);

    AppointmentDTO updateAppointment(final UpdateAppointmentDTO updateAppointmentDTO);

    List<AppointmentDTO> searchAppointments(Long patientId, Boolean onlyFuture, Principal principal);

    void sendAppointmentNotification(AppointmentDTO appointmentDTO);
}
