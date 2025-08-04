package br.edu.ifba.avaliacaoIII.strategy;

import java.time.Duration;

import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.ResultadoApuracao;

public class RegraPenalidadeAtraso implements RegraApuracao {
    @Override
    public void aplicar(BoletimProva boletim, ResultadoApuracao resultado) {
        Duration atraso = boletim.getTempoAtraso();
        if (atraso.compareTo(Duration.ZERO) > 0) {
            resultado.adicionarPenalidade(atraso);
        }
    }
}