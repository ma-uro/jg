/**
 * 
 * @author Mauro
 * @version 1.0
 *
 */

package com.jogo.model;

public class ArvoreGenealogica
{
    private Animal paideTodos;
    private Animal animalDaRodada;
    private Animal macaco;
    private Boolean agua;
    public final String CARACTERISTICA_PRINCIPAL = "vive na \u00e1gua";
    
    public ArvoreGenealogica() {
        this.macaco = new Animal("Macaco", null);
    }
    
    public void carregarAnimaisPais() {
        final Animal tubarao = new Animal("Tubar\u00e3o", "vive na \u00e1gua");
        this.setPaideTodos(tubarao);
        this.setAnimalDaRodada(this.paideTodos);
    }
    
    public Animal getPaideTodos() {
        return this.paideTodos;
    }
    
    public void setPaideTodos(final Animal paideTodos) {
        this.paideTodos = paideTodos;
    }
    
    public Boolean validarAnimal(final Animal animal) {
        return true;
    }
    
    public Animal getPaiDeTodos() {
        return this.paideTodos;
    }
    
    public Animal getMacaco() {
        return this.macaco;
    }
    
    public Animal getAnimalDaRodada() {
        return this.animalDaRodada;
    }
    
    public void setAnimalDaRodada(final Animal animalDaRodada) {
        this.animalDaRodada = animalDaRodada;
    }
    
    public Boolean getAgua() {
        return this.agua;
    }
    
    public void setAgua(final Boolean agua) {
        this.agua = agua;
    }
    
    public void setFilhoAnimalDaRodada() {
        this.setAnimalDaRodada(this.getAnimalDaRodada().getFilho());
    }
    
    public void setIrmaoAnimalDaRodada() {
        this.setAnimalDaRodada(this.getAnimalDaRodada().getIrmao());
    }
    
    public void resetAnimalDaRodada() {
        this.setAnimalDaRodada(this.getPaideTodos());
    }
    
    public void setValidaViveAgua(final boolean origem) {
        if (this.getAnimalDaRodada().getCaracteristica() == "vive na \u00e1gua") {
            this.setAgua(origem);
        }
    }
}
