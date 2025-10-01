package br.com.fiap.hospital.notificacoes.dto;

import java.time.LocalDateTime;

public record AppointmentNotificationDTO(String patientName,
                                         String doctorName,
                                         LocalDateTime appointmentDate,
                                         String specialty,
                                         String location) {
}
