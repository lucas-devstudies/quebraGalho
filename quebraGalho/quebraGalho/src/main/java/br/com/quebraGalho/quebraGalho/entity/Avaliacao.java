package br.com.quebraGalho.quebraGalho.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nota;
    private String titulo;
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    //Referencia o que terá 1
    private Vendedor vendedor; //usar sempre esse nome de objeto no postaman

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Cliente cliente;
}