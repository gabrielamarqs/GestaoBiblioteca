package com.ifpr.biblioteca.bibliotecaproject.domain.entities;

import com.ifpr.biblioteca.bibliotecaproject.domain.enums.Admin;
import com.ifpr.biblioteca.bibliotecaproject.domain.enums.SituacaoUsuario;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "usuario_codigo")
    private Long codigoUsuario;
    @Column(name = "usuario_nome")
    private String nome;
    @Column(name = "usuario_sobrenome")
    private String sobrenome;
    @Column(name = "usuario_email", unique = true)
    private String email;
    @Column(name = "usuario_senha")
    private String senha;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "usuario_admin")
    private Admin admin;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "usuario_situacao")
    private SituacaoUsuario situacaoUsuario;

    public SituacaoUsuario getSituacaoUsuario() {
        return situacaoUsuario;
    }

    public void setSituacaoUsuario(SituacaoUsuario situacaoUsuario) {
        this.situacaoUsuario = situacaoUsuario;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @OneToMany(mappedBy = "usuario")
    private Set<Emprestimo> emprestimo;

    public Set<Emprestimo> getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Set<Emprestimo> emprestimo) {
        this.emprestimo = emprestimo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return Objects.equals(codigoUsuario, usuario.codigoUsuario);
    }

    @Override
    public int hashCode() {
        return codigoUsuario != null ? codigoUsuario.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigoUsuario=" + codigoUsuario +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", emprestimo=" + emprestimo +
                '}';
    }

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
