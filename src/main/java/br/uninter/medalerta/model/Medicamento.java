package br.uninter.medalerta.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Medicamento")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "usuarioMedicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedicamento")
    private Integer idMedicamento;

    @Column(nullable = false, length = 100)
    private String nomeComercial;

    @Column(length = 100)
    private String nomeGenerico;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private QuantidadeTipo quantidade;

    @Column(length = 100)
    private String formaUso;

    @Column(length = 200)
    private String observacao;

    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<UsuarioMedicamento> usuarioMedicamentos = new ArrayList<>();
}