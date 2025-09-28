package br.com.fiap.hospital.agendamentos.controllers.graphql;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class AppointmentHistoryController {

    private final AppointmentService appointmentService;

    @QueryMapping
    public List<AppointmentDTO> searchAppointments(
            @Argument final Long patientId,
            @Argument final Boolean onlyFuture,
            final Principal principal) {

        return appointmentService.searchAppointments(patientId, onlyFuture, principal);
    }
}
