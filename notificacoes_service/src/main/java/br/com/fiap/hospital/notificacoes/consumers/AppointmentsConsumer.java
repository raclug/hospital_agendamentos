package br.com.fiap.hospital.notificacoes.consumers;

import br.com.fiap.hospital.notificacoes.dto.AppointmentNotificationDTO;
import br.com.fiap.hospital.notificacoes.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AppointmentsConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "appointments_topic", groupId = "hospital-group")
    public void listen(final AppointmentNotificationDTO dto) {
        notificationService.sendNotification(dto);
    }
}
