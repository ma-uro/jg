/**
 * 
 * @author Mauro
 * @version 1.0
 *
 */

package com.jogo.view;

import com.jogo.control.Perguntas;

public class Jogar
{
    public static void main(final String[] args) {
        final Jogar jogo = new Jogar();
        jogo.iniciar();
    }
    
    public void iniciar() {
        final Perguntas perguntas = new Perguntas();
        perguntas.carregarJogoInicio();
        perguntas.perguntas();
    }
}
