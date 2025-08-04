package br.edu.ifba.avaliacaoIII.state;

import java.time.Duration;

import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.Prisma;

public class MomentoLargadaState implements ProvaState {
    private final BoletimProva boletim;

    public MomentoLargadaState(BoletimProva boletim) {
        this.boletim = boletim;
    }

    public void registrarAtraso(Duration atraso) {
        if (boletim.getTempoPartidaEfetivo() == null) {
            boletim.setTempoPartidaEfetivo(boletim.getTempoPartidaPrevisto().plus(atraso));
        }
    }
    @Override
    public void registrarLargada(Duration tempo) {
        boletim.setTempoPartidaEfetivo(tempo);
        boletim.setEstado(new PistaState(boletim));
    }

    @Override
    public void registrarPassagem(Prisma prisma, Duration tempo) {
        throw new IllegalStateException("Passagem não permitida antes da largada");
    }

    @Override
    public void registrarChegada(Duration tempo) {
        throw new IllegalStateException("Chegada não permitida antes de entrar na pista");
    }
}
