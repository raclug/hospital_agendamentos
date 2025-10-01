package br.com.fiap.hospital.notificacoes.services;

import br.com.fiap.hospital.notificacoes.dto.AppointmentNotificationDTO;

public interface NotificationService {

    void sendNotification(AppointmentNotificationDTO dto);
}
