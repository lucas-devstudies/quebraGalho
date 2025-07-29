package br.com.quebraGalho.quebraGalho.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoCriacaoDTO {
    private int nota;
    private String titulo;
    private String descricao;
    private Long idVendedor;
}
