package br.com.fiap.hospital.agendamentos.controllers;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.CreateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.SaveUserDTO;
import br.com.fiap.hospital.agendamentos.services.AppointmentService;
import br.com.fiap.hospital.agendamentos.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
@AllArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO create(@RequestBody CreateAppointmentDTO createAppointmentDTO) {
        return appointmentService.createAppointment(createAppointmentDTO);
    }
}
