package br.edu.ifba.avaliacaoIII.state;

import java.time.Duration;
import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.Prisma;

public class PreProvaState implements ProvaState {
    private final BoletimProva boletim;

    public PreProvaState(BoletimProva boletim) {
        this.boletim = boletim;
    }

    @Override
    public void registrarAtraso(Duration atraso) {
        throw new IllegalStateException("Registro de atraso não permitido em Pré-Prova");
    }

   
    @Override
    public void registrarLargada(Duration tempo) {
        boletim.setEstado(new PistaState(boletim)); 
        boletim.setTempoPartidaEfetivo(tempo); 
    }

    @Override
    public void registrarPassagem(Prisma prisma, Duration tempo) {
        throw new IllegalStateException("Registro de passagem não permitido em Pré-Prova");
    }

    @Override
    public void registrarChegada(Duration tempo) {
        throw new IllegalStateException("Registro de chegada não permitido em Pré-Prova");
    }
}