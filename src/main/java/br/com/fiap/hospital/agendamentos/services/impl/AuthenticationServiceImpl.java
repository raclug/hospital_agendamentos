package br.com.fiap.hospital.agendamentos.services.impl;

import br.com.fiap.hospital.agendamentos.dtos.AuthDTO;
import br.com.fiap.hospital.agendamentos.dtos.UserDTO;
import br.com.fiap.hospital.agendamentos.enumeration.Role;
import br.com.fiap.hospital.agendamentos.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtEncoder jwtEncoder;

    @Override
    public AuthDTO login(final UserDTO userDTO) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.username(), userDTO.password())
        );

        var now = Instant.now();
        var authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());


        var accessToken = getAccessToken(userDTO.username(), now, authorities);

        return new AuthDTO(accessToken);
    }


    private String getAccessToken(String username, Instant now, List<String> authorities) {
        var claims = JwtClaimsSet.builder()
                .subject(username)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(60 * 30)) // 30 minutos
                .claim("authorities", authorities)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
