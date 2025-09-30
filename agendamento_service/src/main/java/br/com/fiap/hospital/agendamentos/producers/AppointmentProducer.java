package br.com.fiap.hospital.agendamentos.producers;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;


public interface AppointmentProducer {

    void sendAppointment(AppointmentDTO dto);
}
