/**
 * 
 * @author Mauro
 * @version 1.0
 *
 */

package com.jogo.control;

import com.jogo.view.Telas;
import com.jogo.model.Animal;
import com.jogo.model.ArvoreGenealogica;

public class Perguntas
{
    private static ArvoreGenealogica arvoreAnimais;
    private static Contador contador;
    private Boolean respostaCerta;
    private final Boolean RAMO_FILHO;
    private final Boolean RAMO_IRMAO;
    
    static {
        Perguntas.arvoreAnimais = new ArvoreGenealogica();
        Perguntas.contador = new Contador();
    }
    
    public Perguntas() {
        this.respostaCerta = Boolean.TRUE;
        this.RAMO_FILHO = Boolean.TRUE;
        this.RAMO_IRMAO = Boolean.FALSE;
    }
    
    public void carregarJogoInicio() {
        Perguntas.arvoreAnimais.carregarAnimaisPais();
    }
    
    public void perguntas() {
    	try {    		
	        Telas.getPrimeiraPergunta();
	        while (this.respostaCerta) {
	            final int ret1 = Telas.getPerguntaCaracteristica(Perguntas.arvoreAnimais.getAnimalDaRodada().getCaracteristica());
	            this.validaVivenaAgua(ret1);
	            if (ret1 == 0) {
	                this.tratarFilho();
	            }
	            else {
	                this.tratarIrmao();
	            }
	        }
	        this.respostaCerta = Boolean.TRUE;
	        Perguntas.arvoreAnimais.resetAnimalDaRodada();
	        this.perguntas();	        
    	} catch (Exception e) {
    		int retJogar = Telas.error(e.getMessage());
    		if (retJogar == 0) {
	    		this.respostaCerta = Boolean.TRUE;
		        Perguntas.arvoreAnimais.resetAnimalDaRodada();
		        this.perguntas();
    		} 
        }
    }
    
    private void definirFilhoAnimalDaRodada() {
        Perguntas.arvoreAnimais.setFilhoAnimalDaRodada();
    }
    
    private void definirIrmaoDaRodada() {
        Perguntas.arvoreAnimais.setIrmaoAnimalDaRodada();
    }
    
    private void tratarFilho() {
        if (this.existeFilho()) {
            this.definirFilhoAnimalDaRodada();
        }
        else {
            this.trataUltimaPergunta(this.RAMO_FILHO);
            this.respostaCerta = Boolean.FALSE;
        }
    }
    
    private void tratarIrmao() {
        if (this.existeIrmao()) {
            this.definirIrmaoDaRodada();
        }
        else {
            this.trataUltimaPergunta(this.RAMO_IRMAO);
            this.respostaCerta = Boolean.FALSE;
        }
    }
    
    private void trataUltimaPergunta(final Boolean ramo) {
        final String nome = this.getNomeAnimalDaUltimaRodada(ramo);
        final int ret1 = Telas.getPerguntaAnimal(nome);
        if (ret1 == 0) {
            this.fimdeJogo();
        }
        else if (ramo) {
            this.criarFilho();
        }
        else {
            this.criarIrmao(ramo);
        }
    }
    
    private String getNomeAnimalDaUltimaRodada(final Boolean ramo) {
        if (Perguntas.arvoreAnimais.getAgua()) {
            return ramo ? Perguntas.arvoreAnimais.getAnimalDaRodada().getNome() : Perguntas.arvoreAnimais.getPaiDeTodos().getNome();
        }
        return ramo ? Perguntas.arvoreAnimais.getAnimalDaRodada().getNome() : Perguntas.arvoreAnimais.getMacaco().getNome();
    }
    
    private void criarIrmao(final Boolean ramo) {
        final String nomeNovoAnimal = Telas.getNomeAnimal();
        final String caracteristicaNovoAnimal = Telas.getCaracteristicaAnimal(nomeNovoAnimal, this.getNomeAnimalDaUltimaRodada(ramo));
        final Animal novoanimal = new Animal(nomeNovoAnimal, caracteristicaNovoAnimal);
        Perguntas.arvoreAnimais.getAnimalDaRodada().setIrmao(novoanimal);
    }
    
    private void criarFilho() {
        final String nomeNovoAnimal = Telas.getNomeAnimal();
        final String caracteristicaNovoAnimal = Telas.getCaracteristicaAnimal(nomeNovoAnimal, Perguntas.arvoreAnimais.getAnimalDaRodada().getNome());
        final Animal novoanimal = new Animal(nomeNovoAnimal, caracteristicaNovoAnimal);
        Perguntas.arvoreAnimais.getAnimalDaRodada().setFilho(novoanimal);
    }
    
    private boolean existeFilho() {
        return Perguntas.arvoreAnimais.getAnimalDaRodada().getFilho() != null;
    }
    
    private boolean existeIrmao() {
        return Perguntas.arvoreAnimais.getAnimalDaRodada().getIrmao() != null;
    }
    
    public void fimdeJogo() {
        if (Contador.getContador() == 1) {
            Telas.agradecer();
            Perguntas.contador.incrementa();
        }
        else {
            Telas.agradecerNovamente();
        }
    }
    
    public void validaVivenaAgua(final int ret1) {
        Perguntas.arvoreAnimais.setValidaViveAgua(ret1 == 0);
    }
}
