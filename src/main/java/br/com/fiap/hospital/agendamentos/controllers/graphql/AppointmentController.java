package br.com.fiap.hospital.agendamentos.controllers.graphql;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.mappers.AppointmentDTOMapper;
import br.com.fiap.hospital.agendamentos.repositories.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    @QueryMapping
    public List<AppointmentDTO> appointments() {
        var appointments = appointmentRepository.findAll();
        return appointments.stream().map(AppointmentDTOMapper::toDTO).toList();
    }
}
