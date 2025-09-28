package br.com.fiap.hospital.agendamentos.utils;

import br.com.fiap.hospital.agendamentos.enumeration.Role;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.security.Principal;

public class SecurityUtils {

    private SecurityUtils() {
    }

    public static Boolean isPatient(Principal principal) {

        var jwt = (JwtAuthenticationToken) principal;

        return jwt.getAuthorities().stream().anyMatch(grantedAuthority ->
                grantedAuthority.getAuthority().contains(String.format("ROLE_%s", Role.PACIENTE.name())));
    }
}
