package br.com.fiap.hospital.agendamentos.controllers;


import br.com.fiap.hospital.agendamentos.dtos.AuthDTO;
import br.com.fiap.hospital.agendamentos.dtos.UserDTO;
import br.com.fiap.hospital.agendamentos.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationService authenticateService;

    @PostMapping
    public AuthDTO login(@RequestBody UserDTO userDTO) {
        return authenticateService.login(userDTO);
    }
}
