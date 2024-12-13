package br.ifpe.jaboatao.ts.servicos.builders;

import br.ifpe.jaboatao.ts.entidades.Usuario;

public class UsuarioBuilder {
    
    private Usuario usuario;
    private UsuarioBuilder() {}
    public static UsuarioBuilder umUsuario(){
        UsuarioBuilder builder = new UsuarioBuilder();
        builder.usuario = new Usuario("João");
        return builder;
    }

    public UsuarioBuilder comNome(String nome){
        usuario.setNome(nome);
        return this;
    }

    public Usuario agora(){
        return usuario;
    }
}
