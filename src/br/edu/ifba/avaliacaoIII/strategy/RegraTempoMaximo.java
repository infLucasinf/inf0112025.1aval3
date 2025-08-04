package br.edu.ifba.avaliacaoIII.strategy;

import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.ResultadoApuracao;

public class RegraTempoMaximo implements RegraApuracao {
    @Override
    public void aplicar(BoletimProva boletim, ResultadoApuracao resultado) {
        if (boletim.getTempoProva().compareTo(boletim.getTempoMaximoProva()) > 0) {
            resultado.setInvalido("Tempo máximo excedido");
        }
    }
}
