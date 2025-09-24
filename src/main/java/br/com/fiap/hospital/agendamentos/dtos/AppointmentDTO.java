package br.com.fiap.hospital.agendamentos.dtos;

import br.com.fiap.hospital.agendamentos.enumeration.AppointmentStatus;

import java.time.LocalDateTime;

public record AppointmentDTO(String patient,
                             String doctor,
                             LocalDateTime appointmentDate,
                             String reason,
                             String notes,
                             AppointmentStatus appointmentStatus,
                             String specialty,
                             String location) {
}
