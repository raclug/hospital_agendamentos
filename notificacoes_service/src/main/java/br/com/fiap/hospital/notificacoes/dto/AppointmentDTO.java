package br.com.fiap.hospital.notificacoes.dto;

import java.time.LocalDateTime;

public record AppointmentDTO(Long id,
                             Long patientId,
                             Long doctorId,
                             LocalDateTime appointmentDate,
                             String reason,
                             String notes,
                             String appointmentStatus,
                             String specialty,
                             String location) {
}
