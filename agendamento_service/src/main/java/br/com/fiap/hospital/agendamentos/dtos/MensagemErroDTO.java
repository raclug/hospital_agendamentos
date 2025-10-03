package br.com.fiap.hospital.agendamentos.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MensagemErroDTO {

    private Integer status;

    private List<String> erros;
}
