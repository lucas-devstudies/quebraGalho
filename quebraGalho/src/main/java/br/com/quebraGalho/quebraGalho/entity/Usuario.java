package br.com.quebraGalho.quebraGalho.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Porque AUTO_INCREMENT no MySQL
    private Long id;

    private String cpf;
    private String nome;
    private String email;
    private String senha;
}
