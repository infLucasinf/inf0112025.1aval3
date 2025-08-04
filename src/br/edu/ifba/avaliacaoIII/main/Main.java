package br.edu.ifba.avaliacaoIII.main;
import java.time.Duration;
import java.util.List;
import br.edu.ifba.avaliacaoIII.model.BoletimProva;
import br.edu.ifba.avaliacaoIII.model.Prisma;
import br.edu.ifba.avaliacaoIII.model.ResultadoApuracao;
import br.edu.ifba.avaliacaoIII.strategy.Apurador;
import br.edu.ifba.avaliacaoIII.strategy.RegraApuracao;
import br.edu.ifba.avaliacaoIII.strategy.RegraOrdemPrismas;
import br.edu.ifba.avaliacaoIII.strategy.RegraPenalidadeAtraso;
import br.edu.ifba.avaliacaoIII.strategy.RegraTempoMaximo;

public class Main {

    public static void main(String[] args) {
        BoletimProva boletim = new BoletimProva("ATL123", Duration.ofMinutes(10), Duration.ofHours(1));
        List<RegraApuracao> regras = List.of(
            new RegraTempoMaximo(),
            new RegraOrdemPrismas(),
            new RegraPenalidadeAtraso()
        );
        Apurador apurador = new Apurador(regras);
        
     /*
        // Caso 1: Fluxo completo sem atrasos 
        boletim.registrarLargada(Duration.ofMinutes(10));
        boletim.registrarPassagem(new Prisma("P1"), Duration.ofMinutes(20));
        boletim.registrarPassagem(new Prisma("P2"), Duration.ofMinutes(30));
        boletim.registrarChegada(Duration.ofMinutes(40));
     */   
     
        // Caso 2: Com atraso e penalidade 
        boletim.registrarLargada(Duration.ofMinutes(15)); // atraso de 5 min
        boletim.registrarPassagem(new Prisma("P1"), Duration.ofMinutes(20));
        boletim.registrarChegada(Duration.ofMinutes(45));
        
        
    /*  // Caso 3: Ordem correta dos prismas
        boletim.registrarLargada(Duration.ofMinutes(10));
        boletim.registrarPassagem(new Prisma("P1"), Duration.ofMinutes(15));
        boletim.registrarPassagem(new Prisma("P2"), Duration.ofMinutes(25));
        boletim.registrarChegada(Duration.ofMinutes(50));
    */
        
        
    /*  // Caso 4: Tempo de prova igual ao tempo máximo permitido
        boletim.registrarLargada(Duration.ofMinutes(10));
        boletim.registrarChegada(Duration.ofMinutes(70)); // 60 minutos de prova
    */
        
        
     /*
        // Exceção 1: Registrar atraso antes da largada
        boletim.registrarAtraso(Duration.ofMinutes(5)); // Pré-Prova
        boletim.registrarLargada(Duration.ofMinutes(10));
      */  
        
    
     /*
        // Exceção 2: Segunda largada
        boletim.registrarLargada(Duration.ofMinutes(10));
        boletim.registrarLargada(Duration.ofMinutes(15)); // já foi registrada 
     */   
        
        
     //  Exceção 4: Passagem antes da largada
     //  boletim.registrarPassagem(new Prisma("P1"), Duration.ofMinutes(20)); 
        
          
    /*
        //Exceção 6: Passagem após chegada
        boletim.registrarLargada(Duration.ofMinutes(10));
        boletim.registrarChegada(Duration.ofMinutes(40));
        boletim.registrarPassagem(new Prisma("P1"), Duration.ofMinutes(45)); // Pós-Prova 
    */
        
        ResultadoApuracao resultado = apurador.apurar(boletim);
        
        if (resultado.getMotivoInvalidacao() != null) {
        	throw new IllegalStateException("Atenção: " + resultado.getMotivoInvalidacao()); // o objetivo é impedir a execução do código
        }
        
        System.out.println("Atleta:           " + boletim.getCodigoAtleta());  
        System.out.println("Atraso:           " + formatDuration(boletim.getTempoAtraso()));
        System.out.println("Chegada:          " + formatDuration(boletim.getTempoChegada()));
        System.out.println("Tempo Máximo:     " + formatDuration(boletim.getTempoMaximoProva()));
        System.out.println("Partida Prevista: " + formatDuration(boletim.getTempoPartidaPrevisto()));
        System.out.println("Partida Efetiva:  " + formatDuration(boletim.getTempoPartidaEfetivo()));
        System.out.println("Tempo de Prova:   " + formatDuration(boletim.getTempoProva()));
    }

    private static String formatDuration(Duration d) {

    	long totalMin = d.toMinutes();
        
        if (totalMin <= 0) {
            return "0 min";
        }
        
        long hours   = totalMin / 60;
        long minutes = totalMin % 60;

        if (hours > 0) {
            if (minutes > 0) {
                return String.format("%dh %d min", hours, minutes);
            } else {
                return String.format("%dh", hours);
            }
        } else {
            return String.format("%d min", minutes);
        }
    }
}
