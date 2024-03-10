package sptech.school.api_projeto_goway.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome é obrigatório")
    @Length(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Email é obrigatório")
    @NotBlank(message = "Email não pode ser vazio")
    private String email;

    @NotNull(message = "Senha é obrigatória")
    @Length(min = 6, max = 100, message = "Senha deve ter entre 6 e 100 caracteres")
    @NotBlank(message = "Senha não pode ser vazia")
    private String senha;

    @CPF(message = "CPF inválido")
    @Length(min = 11, max = 11, message = "CPF deve ter 11 caracteres")
    @NotBlank(message = "CPF não pode ser vazio")
    private String cpf;

    @NotNull(message = "Telefone é obrigatório")
    @Length(min = 10, max = 11, message = "Telefone deve ter 11 caracteres")
    @NotBlank(message = "Telefone não pode ser vazio")
    private String telefone;

    @NotNull(message = "Data de nascimento é obrigatória")
    private Date dataNascimento;

    @NotNull(message = "Sexo é obrigatório")
    @Length(min = 1, max = 1, message = "Sexo deve ter 1 caracter")
    private String sexo;

    @NotNull(message = "Endereço é obrigatório")

    private String endereco;

    @NotNull(message = "Cidade é obrigatória")
    private String cidade;

    @NotNull(message = "Estado é obrigatório")
    @Length(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
    private String estado;

    @NotNull(message = "CEP é obrigatório")
    @Length(min = 8, max = 8, message = "CEP deve ter 8 caracteres")
    private String cep;

    private boolean ativo;

    private Date dataCriacao;


    private Date dataAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
