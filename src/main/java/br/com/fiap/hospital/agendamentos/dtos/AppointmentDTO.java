package br.com.fiap.hospital.agendamentos.dtos;

import br.com.fiap.hospital.agendamentos.enumeration.AppointmentStatus;

import java.time.LocalDateTime;

public record AppointmentDTO(Long id,
                             Long patientId,
                             Long doctorId,
                             LocalDateTime appointmentDate,
                             String reason,
                             String notes,
                             AppointmentStatus appointmentStatus,
                             String specialty,
                             String location) {
}
