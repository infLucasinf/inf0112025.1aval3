package br.edu.ifba.avaliacaoIII.strategy;

import java.util.List;

import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.ResultadoApuracao;

public class Apurador {
    private final List<RegraApuracao> regras;

    public Apurador(List<RegraApuracao> regras) {
        this.regras = regras;
    }

    public ResultadoApuracao apurar(BoletimProva boletim) {
        ResultadoApuracao resultado = new ResultadoApuracao();
        regras.forEach(regra -> regra.aplicar(boletim, resultado));
        return resultado;
    }
}