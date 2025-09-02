package br.com.fiap.hospital.agendamentos.controllers;

import br.com.fiap.hospital.agendamentos.dtos.SaveUserDTO;
import br.com.fiap.hospital.agendamentos.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void save(@RequestBody SaveUserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    @GetMapping
    public String teste() {
        return "ok";
    }
}
