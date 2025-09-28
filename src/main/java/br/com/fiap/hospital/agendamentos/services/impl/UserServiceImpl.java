package br.com.fiap.hospital.agendamentos.services.impl;

import br.com.fiap.hospital.agendamentos.dtos.SaveUserDTO;
import br.com.fiap.hospital.agendamentos.entities.UserEntity;
import br.com.fiap.hospital.agendamentos.repositories.UserRepository;
import br.com.fiap.hospital.agendamentos.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(final SaveUserDTO saveUserDTO) {
        var userEntity = UserEntity.builder()
                .username(saveUserDTO.username())
                .password(passwordEncoder.encode(saveUserDTO.password()))
                .roles(Set.of(saveUserDTO.role())).build();


        userRepository.save(userEntity);
    }

    @Override
    public String getNameById(Long id) {
        return userRepository.findById(id)
                .map(UserEntity::getName)
                .orElse("Unknown User");
    }

    @Override
    public Long findIdByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserEntity::getId)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    @Override
    public UserDetails getUserDetails(final String username) {

        var userEntity = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado"));
        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRoles().stream().map(Enum::name).toArray(String[]::new))
                .build();
    }
}
