package br.com.alura.owasp.dto;

import br.com.alura.owasp.model.Usuario;

public class UsuarioDTO {

    private String email;
    private String senha;
    private String nome;
    private String nomeImagem;

    public UsuarioDTO() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    /**
     * Converts the current UsuarioDTO object to a Usuario object.
     *
     * @return  a new Usuario object with the same email, senha, nome, and nomeImagem as the current UsuarioDTO object
     */
    public Usuario converterUsuario() {
        return new Usuario(email, senha, nome, nomeImagem);
    }
}
