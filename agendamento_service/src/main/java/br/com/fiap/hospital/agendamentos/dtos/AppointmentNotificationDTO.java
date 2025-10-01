package br.com.fiap.hospital.agendamentos.dtos;

import java.time.LocalDateTime;

public record AppointmentNotificationDTO(String patientName,
                                         String doctorName,
                                         LocalDateTime appointmentDate,
                                         String specialty,
                                         String location) {
}
