package br.edu.ifba.avaliacaoIII.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifba.avaliacaoIII.state.ProvaState;
import br.edu.ifba.avaliacaoIII.state.PreProvaState;

public class BoletimProva {
    private ProvaState estado;
    private String codigoAtleta;
    private List<TempoPassagem> passagens;
    private Duration tempoPartidaPrevisto;
    private Duration tempoPartidaEfetivo;
    private Duration tempoChegada;
    private Duration tempoMaximoProva;

    public Duration getTempoPartidaEfetivo() 
    { 
    	return tempoPartidaEfetivo; 
    }
    
    public String getCodigoAtleta() {
        return codigoAtleta;
    }
    
    public Duration getTempoPartidaPrevisto() 
    { 
    	return tempoPartidaPrevisto; 
    }
    public Duration getTempoChegada() 
    { 
    	return tempoChegada; 
    }
    
    public BoletimProva(String codigoAtleta, Duration tempoPartidaPrevisto, Duration tempoMaximoProva) {
        this.codigoAtleta = codigoAtleta;
        this.passagens = new ArrayList<>();
        this.tempoPartidaPrevisto = tempoPartidaPrevisto;
        this.tempoMaximoProva = tempoMaximoProva;
        this.estado = new PreProvaState(this);
    }
    
    public List<TempoPassagem> getPassagens() {
        return List.copyOf(passagens);
    }
    
    public void registrarAtraso(Duration atraso) {
        estado.registrarAtraso(atraso);
    }

    public void registrarLargada(Duration tempo) {
        estado.registrarLargada(tempo);
    }

    public void registrarPassagem(Prisma prisma, Duration tempo) {
        estado.registrarPassagem(prisma, tempo);
    }

    public void registrarChegada(Duration tempo) {
        estado.registrarChegada(tempo);
    }

    public Duration getTempoMaximoProva() {
        return tempoMaximoProva;
    }

    public Duration getTempoProva() {
        return tempoChegada.minus(tempoPartidaEfetivo);
    }

    public void setEstado(ProvaState estado) {
        this.estado = estado;
    }
    
    public void setTempoPartidaEfetivo(Duration tempo) {
        this.tempoPartidaEfetivo = tempo;
    }
    
    public void setTempoChegada(Duration tempo) {
        this.tempoChegada = tempo;
    }
    
    public Duration getTempoAtraso() {
        if (tempoPartidaEfetivo == null || tempoPartidaPrevisto == null) {
            return Duration.ZERO;
        }
        Duration atraso = tempoPartidaEfetivo.minus(tempoPartidaPrevisto);
        return atraso.isNegative() ? Duration.ZERO : atraso;
    }
    

    public void addPassagem(Prisma prisma, Duration tempo) {
        passagens.add(new TempoPassagem(prisma, tempo));
    }
}