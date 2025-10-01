package br.com.fiap.hospital.agendamentos.producers;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentNotificationDTO;


public interface AppointmentProducer {

    void sendAppointment(AppointmentNotificationDTO dto);
}
