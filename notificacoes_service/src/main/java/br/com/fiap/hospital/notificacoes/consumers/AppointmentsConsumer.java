package br.com.fiap.hospital.notificacoes.consumers;

import br.com.fiap.hospital.notificacoes.dto.AppointmentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppointmentsConsumer {

    @KafkaListener(topics = "appointments_topic", groupId = "hospital-group")
    public void listen(final AppointmentDTO appointment) {
        log.info("Mensagem recebida: {}", appointment.location());
    }
}
