package br.uninter.medalerta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    @ToString.Include
    private Integer idUsuario;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    @ToString.Include
    private String nome;

    @NotBlank
    @Pattern(regexp = "\\d{10,11}")
    @Column(nullable = false, length = 20)
    private String telefone;

    @NotBlank
    @Email
    @Column(nullable = false, length = 100)
    @ToString.Include
    private String email;

    @Column(length = 100)
    private String enderecoRua;

    @Column
    private Integer enderecoNumero;

    @Column(length = 50)
    private String enderecoComplemento;

    @Column(length = 50)
    private String enderecoBairro;

    @Column(length = 10)
    private String enderecoCEP;

    @Column(length = 50)
    private String enderecoCidade;

    @Column(length = 2)
    private String enderecoEstado;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<UsuarioMedicamento> usuarioMedicamentos = new ArrayList<>();

    public void adicionarMedicamento(UsuarioMedicamento um) {
        if (um == null) return;

        if (!usuarioMedicamentos.contains(um)) {
            usuarioMedicamentos.add(um);
            um.setUsuario(this);
        }
    }

    public void removerMedicamento(UsuarioMedicamento um) {
        if (um == null) return;

        if (usuarioMedicamentos.remove(um)) {
            um.setUsuario(null);
        }
    }
}