package br.com.fiap.hospital.agendamentos.controllers.rest;

import br.com.fiap.hospital.agendamentos.dtos.AppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.CreateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.dtos.UpdateAppointmentDTO;
import br.com.fiap.hospital.agendamentos.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
@AllArgsConstructor
public class AppointmentRestController {

    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentDTO create(@RequestBody CreateAppointmentDTO createAppointmentDTO) {
        return appointmentService.createAppointment(createAppointmentDTO);
    }

    @PutMapping
    public AppointmentDTO update(@RequestBody UpdateAppointmentDTO updateAppointmentDTO) {
        return appointmentService.updateAppointment(updateAppointmentDTO);
    }
}
