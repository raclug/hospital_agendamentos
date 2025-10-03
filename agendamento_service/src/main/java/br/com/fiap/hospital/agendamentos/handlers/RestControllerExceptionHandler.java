package br.com.fiap.hospital.agendamentos.handlers;


import br.com.fiap.hospital.agendamentos.dtos.MensagemErroDTO;
import br.com.fiap.hospital.agendamentos.exceptions.AppointmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({AppointmentNotFoundException.class})
    public MensagemErroDTO handleNaoEncontradoException(RuntimeException ex) {
        return MensagemErroDTO.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .erros(List.of(ex.getMessage()))
                .build();
    }
}
