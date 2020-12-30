/**
 * 
 * @author Mauro
 * @version 1.0
 *
 */

package com.jogo.model;

public class Animal
{
    private String nome;
    private String caracteristica;
    private Animal irmao;
    private Animal filho;
    
    public Animal(final String novoNome) {
        this.setNome(novoNome);
    }
    
    public Animal(final String novoNome, final String novaCaracteristica) {
        this.setNome(novoNome);
        this.setCaracteristica(novaCaracteristica);
    }
    
    public Animal() {
    }
    
    public Animal getFilho() {
        return this.filho;
    }
    
    public void setFilho(final Animal filho) {
        this.filho = filho;
    }
    
    public Animal getIrmao() {
        return this.irmao;
    }
    
    public void setIrmao(final Animal irmao) {
        this.irmao = irmao;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getCaracteristica() {
        return this.caracteristica;
    }
    
    public void setCaracteristica(final String caracteristica) {
        this.caracteristica = caracteristica;
    }
}
