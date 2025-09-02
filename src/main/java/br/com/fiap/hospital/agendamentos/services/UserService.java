package br.com.fiap.hospital.agendamentos.services;

import br.com.fiap.hospital.agendamentos.dtos.SaveUserDTO;
import br.com.fiap.hospital.agendamentos.entities.UserEntity;
import br.com.fiap.hospital.agendamentos.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void saveUser(final SaveUserDTO saveUserDTO) {
        var userEntity = UserEntity.builder()
                .username(saveUserDTO.username())
                .password(passwordEncoder.encode(saveUserDTO.password()))
                .roles(Set.of(saveUserDTO.role())).build();


        userRepository.save(userEntity);
    }
}
