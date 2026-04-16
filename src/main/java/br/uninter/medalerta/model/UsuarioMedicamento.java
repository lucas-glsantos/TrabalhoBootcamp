package br.uninter.medalerta.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "UsuarioMedicamento")
@Getter
@Setter
@NoArgsConstructor
public class UsuarioMedicamento {

    @EmbeddedId
    private UsuarioMedicamentoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMedicamento")
    @JoinColumn(name = "idMedicamento")
    private Medicamento medicamento;

    @Column(nullable = false)
    private LocalTime horarioUso;

    @Column(length = 50)
    private String frequenciaUso;

    @Column(nullable = false, length = 50)
    private String dosagem;

    @Column(nullable = false)
    private LocalDateTime dataHorarioAlerta;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusAlerta statusAlerta;

    private LocalDateTime dataHorarioConsumo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private ConfirmacaoConsumo confirmacaoConsumo;

    @Override
    public String toString() {
        return "UsuarioMedicamento{" +
                "idUsuario=" + (id != null ? id.getIdUsuario() : null) +
                ", idMedicamento=" + (id != null ? id.getIdMedicamento() : null) +
                ", usuario=" + (usuario != null ? usuario.getNome() : null) +
                ", medicamento=" + (medicamento != null ? medicamento.getNomeComercial() : null) +
                ", horarioUso=" + horarioUso +
                ", frequenciaUso='" + frequenciaUso + '\'' +
                ", dosagem='" + dosagem + '\'' +
                ", dataHorarioAlerta=" + dataHorarioAlerta +
                ", statusAlerta=" + statusAlerta +
                ", dataHorarioConsumo=" + dataHorarioConsumo +
                ", confirmacaoConsumo=" + confirmacaoConsumo +
                '}';
    }
}