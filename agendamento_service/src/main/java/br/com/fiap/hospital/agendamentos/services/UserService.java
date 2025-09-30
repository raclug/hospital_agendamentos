package br.com.fiap.hospital.agendamentos.services;

import br.com.fiap.hospital.agendamentos.dtos.SaveUserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    void saveUser(final SaveUserDTO saveUserDTO);

    String getNameById(Long id);

    Long findIdByUsername(String username);

    UserDetails getUserDetails(String username);
}
