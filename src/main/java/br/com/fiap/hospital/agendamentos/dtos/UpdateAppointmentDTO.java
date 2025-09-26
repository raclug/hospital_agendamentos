package br.com.fiap.hospital.agendamentos.dtos;

import br.com.fiap.hospital.agendamentos.enumeration.AppointmentStatus;

import java.time.LocalDateTime;

public record UpdateAppointmentDTO(Long id,
                                   LocalDateTime appointmentDate,
                                   String notes,
                                   AppointmentStatus status) {
}
