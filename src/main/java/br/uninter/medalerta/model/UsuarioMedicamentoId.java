package br.uninter.medalerta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UsuarioMedicamentoId implements Serializable {

    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "idMedicamento")
    private Integer idMedicamento;
}