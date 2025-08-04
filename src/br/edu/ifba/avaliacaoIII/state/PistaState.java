package br.edu.ifba.avaliacaoIII.state;

import java.time.Duration;

import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.Prisma;

public class PistaState implements ProvaState {
    private final BoletimProva boletim;

    public PistaState(BoletimProva boletim) {
        this.boletim = boletim;
    }

    @Override
    public void registrarAtraso(Duration atraso) {
        throw new IllegalStateException("Atraso não pode ser registrado após a largada");
    }

    @Override
    public void registrarLargada(Duration tempo) {
        throw new IllegalStateException("Largada já registrada");
    }

    @Override
    public void registrarPassagem(Prisma prisma, Duration tempo) {
        boletim.addPassagem(prisma, tempo);
    }

    @Override
    public void registrarChegada(Duration tempo) {
        boletim.setTempoChegada(tempo);
        boletim.setEstado(new PosProvaState(boletim));
    }
}
