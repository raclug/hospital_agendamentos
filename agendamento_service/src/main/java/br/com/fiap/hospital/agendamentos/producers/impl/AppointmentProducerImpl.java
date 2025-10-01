package br.com.fiap.hospital.agendamentos.producers.impl;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.AppointmentNotificationDTO;
import br.com.fiap.hospital.agendamentos.producers.AppointmentProducer;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentProducerImpl implements AppointmentProducer {

    private final KafkaTemplate<String, AppointmentNotificationDTO> kafkaTemplate;

    @Override
    public void sendAppointment(final AppointmentNotificationDTO dto) {
        kafkaTemplate.send("appointments_topic", dto);
    }
}
