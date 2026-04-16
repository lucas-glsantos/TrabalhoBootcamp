package br.uninter.medalerta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity 
@Table(name = "Usuario") 
public class Usuario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "idUsuario") 
    private Integer idUsuario; 

    @NotBlank 
    @Size(max = 100)
    @Column(nullable = false, length = 100) 
    private String nome;

    @NotBlank 
    @Pattern(regexp = "\\d{10,11}")  
    @Column(nullable = false, length = 20) 
    private String telefone;

    @NotBlank  
    @Email  
    @Column(nullable = false, length = 100) 
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
    private List<UsuarioMedicamento> usuarioMedicamentos = new ArrayList<>();

    public Usuario() { 
    }

    public Integer getIdUsuario() { 
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) { 
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public Integer getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(Integer enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    public String getEnderecoCEP() {
        return enderecoCEP;
    }

    public void setEnderecoCEP(String enderecoCEP) {
        this.enderecoCEP = enderecoCEP;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    public List<UsuarioMedicamento> getUsuarioMedicamentos() {
        return usuarioMedicamentos;
    }

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

   @Override
public String toString() {
    return "Usuario{" +
            "idUsuario=" + idUsuario +
            ", nome='" + nome + '\'' +
            ", email='" + email + '\'' +
            '}';
}
}