package br.edu.ifba.avaliacaoIII.strategy;

import java.util.List;

import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.ResultadoApuracao;
import br.edu.ifba.avaliacaoIII.model.TempoPassagem;

public class RegraOrdemPrismas implements RegraApuracao {
    @Override
    public void aplicar(BoletimProva boletim, ResultadoApuracao resultado) {
        List<TempoPassagem> passagens = boletim.getPassagens();
        for (int i = 1; i < passagens.size(); i++) {
            if (passagens.get(i).getTempo().compareTo(passagens.get(i-1).getTempo()) <= 0) {
                resultado.setInvalido("Ordem de prismas incorreta");
                break;
            }
        }
    }
}