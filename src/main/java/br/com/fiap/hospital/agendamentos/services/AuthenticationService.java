package br.com.fiap.hospital.agendamentos.services;

import br.com.fiap.hospital.agendamentos.dtos.AuthDTO;
import br.com.fiap.hospital.agendamentos.dtos.UserDTO;

import java.security.Principal;

public interface AuthenticationService {

    AuthDTO login(final UserDTO userDTO);
}
