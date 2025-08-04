package br.edu.ifba.avaliacaoIII.strategy;

import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.ResultadoApuracao;

public interface RegraApuracao {
    void aplicar(BoletimProva boletim, ResultadoApuracao resultado);
}