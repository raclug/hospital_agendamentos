package br.com.fiap.hospital.agendamentos.dtos;

import java.time.LocalDateTime;

public record CreateAppointmentDTO(Long patientId,
                                   Long doctorId,
                                   LocalDateTime appointmentDate,
                                   String reason,
                                   String specialty,
                                   String location) {
}
