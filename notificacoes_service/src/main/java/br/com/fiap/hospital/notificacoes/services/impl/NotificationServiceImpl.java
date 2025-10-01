package br.com.fiap.hospital.notificacoes.services.impl;

import br.com.fiap.hospital.notificacoes.dto.AppointmentNotificationDTO;
import br.com.fiap.hospital.notificacoes.services.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {


    @Override
    public void sendNotification(AppointmentNotificationDTO dto) {
        log.info("**** Enviando notificação para o paciente ****");
        log.info("   Paciente: {}", dto.patientName());
        log.info("   Medico: {}", dto.doctorName());
        log.info("   Data da Consulta: {}", dto.appointmentDate());
        log.info("   Especialidade: {}", dto.specialty());
        log.info("   Local da Consulta: {}", dto.location());
    }
}
