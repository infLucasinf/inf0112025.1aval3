package br.edu.ifba.avaliacaoIII.model;

import java.time.Duration;

public class TempoPassagem {
    private final Prisma prisma;
    private final Duration tempo;

    public TempoPassagem(Prisma prisma, Duration tempo) {
        this.prisma = prisma;
        this.tempo = tempo;
    }

    public Duration getTempo() {
        return tempo;
    }
}
