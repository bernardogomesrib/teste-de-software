package br.ifpe.jaboatao.ts.servicos.builders;

import br.ifpe.jaboatao.ts.entidades.Filme;

public class FilmeBuilder {
    private Filme filme;
    private FilmeBuilder() {}
    public static FilmeBuilder umFilme(){
        FilmeBuilder builder = new FilmeBuilder();
        builder.filme = new Filme("Filme 1", 0, 3.0);
        return builder;
    }
    public FilmeBuilder comTitulo(String titulo){
        //filme.setTitulo(titulo);
        this.filme = Filme.builder().titulo(titulo).estoque(this.filme.getEstoque()).valor(this.filme.getValor()).build();
        return this;
    }
    public FilmeBuilder comEstoque(Integer estoque){
        //filme.setEstoque(estoque);
        this.filme = Filme.builder().titulo(this.filme.getTitulo()).estoque(estoque).valor(this.filme.getValor()).build();
        return this;
    }
    public FilmeBuilder comValor(Double valor){
        ///filme.setValor(valor);
        this.filme = Filme.builder().titulo(this.filme.getTitulo()).estoque(this.filme.getEstoque()).valor(valor).build();
        return this;
    }
    public Filme agora(){
        return filme;
    }
}
