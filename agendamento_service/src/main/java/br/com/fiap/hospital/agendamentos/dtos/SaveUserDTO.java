package br.com.fiap.hospital.agendamentos.dtos;

import br.com.fiap.hospital.agendamentos.enumeration.Role;

public record SaveUserDTO(String username, String password, Role role) {
}
