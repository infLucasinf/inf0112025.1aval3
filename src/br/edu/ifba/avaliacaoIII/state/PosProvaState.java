package br.edu.ifba.avaliacaoIII.state;

import java.time.Duration;
import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.Prisma;

public class PosProvaState implements ProvaState {
    private final BoletimProva boletim;


    public PosProvaState(BoletimProva boletim) {
        this.boletim = boletim;
    }

    @Override
    public void registrarAtraso(Duration atraso) {
        throw new IllegalStateException("Atraso não pode ser registrado após a prova");
    }

    @Override
    public void registrarLargada(Duration tempo) {
        throw new IllegalStateException("Largada já ocorreu");
    }

    @Override
    public void registrarPassagem(Prisma prisma, Duration tempo) {
        throw new IllegalStateException("Passagens não podem ser registradas após a chegada");
    }

    @Override
    public void registrarChegada(Duration tempo) {
        throw new IllegalStateException("Chegada já registrada");
    }
}
