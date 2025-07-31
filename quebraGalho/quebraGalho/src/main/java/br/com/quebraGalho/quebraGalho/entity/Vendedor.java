package br.com.quebraGalho.quebraGalho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vendedor extends Usuario{

    @ManyToMany
    @JoinTable(name = "profissao_vendedores",
        joinColumns = @JoinColumn(name = "vendedor_id"),
        inverseJoinColumns = @JoinColumn(name = "profissao_id")
    )
    private List<Profissao> profissoes;

    @OneToMany(mappedBy = "vendedor")
    private List<Avaliacao> avaliacoes;
}