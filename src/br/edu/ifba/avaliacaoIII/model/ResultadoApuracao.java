package br.edu.ifba.avaliacaoIII.model;

import java.time.Duration;

public class ResultadoApuracao {
    private String motivoInvalidacao;
    private Duration tempoFinal = Duration.ZERO;    
    
    public String getMotivoInvalidacao() {
        return motivoInvalidacao;
    }

    public void setInvalido(String motivo) {
        this.motivoInvalidacao = motivo;
    }
    
    public Duration getTempoFinal() {
        return tempoFinal;
    }

    public void adicionarPenalidade(Duration penalidade) {
        tempoFinal = tempoFinal.plus(penalidade);
    }
}