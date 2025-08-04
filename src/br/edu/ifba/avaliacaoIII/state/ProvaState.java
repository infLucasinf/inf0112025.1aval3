package br.edu.ifba.avaliacaoIII.state;

import java.time.Duration;
import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.Prisma;

public interface ProvaState {
    void registrarAtraso(Duration atraso);
    void registrarLargada(Duration tempo);
    void registrarPassagem(Prisma prisma, Duration tempo);
    void registrarChegada(Duration tempo);
}