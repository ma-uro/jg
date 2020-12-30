/**
 * 
 * @author Mauro
 * @version 1.0
 *
 */

package com.jogo.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Telas
{
    static JFrame frame;
    
    static {
        Telas.frame = new JFrame("Jogo dos Animais");
    }
    
    public static void getPrimeiraPergunta() {
        JOptionPane.showMessageDialog(null, "Pense num animal");
    }
    
    public static Integer getPerguntaCaracteristica(final String charada) {
        return JOptionPane.showConfirmDialog(null, "O animal que voc\u00ea pensou " + charada + "?", "Jogo do Animais", 0);
    }
    
    public static Integer getPerguntaAnimal(final String animal) {
        return JOptionPane.showConfirmDialog(null, "O animal que voc\u00ea pensou \u00e9 " + animal + "?", "Jogo do Animais", 0);
    }
    
    public static Integer error(String error) {
    	return JOptionPane.showConfirmDialog(null, "Algo deu errado: " + error + ". Vamos jogar dinovo?", "Jogo do Animais", 0);
    }
    
    public static void agradecer() {
        JOptionPane.showMessageDialog(null, "Acertei!");
    }
    
    public static void agradecerNovamente() {
        JOptionPane.showMessageDialog(null, "Acertei de novo!");
    }
    
    public static String getNomeAnimal() {
        return JOptionPane.showInputDialog(Telas.frame, "Qual animal voc\u00ea pensou?");
    }
    
    public static String getCaracteristicaAnimal(final String nomePai, final String nomeFilho) {
        return JOptionPane.showInputDialog(Telas.frame, getFraseCaracteristicaAnimal(nomeFilho, nomePai));
    }
    
    private static String getFraseCaracteristicaAnimal(final String nomePai, final String nomeFilho) {
        final StringBuilder frase = new StringBuilder();
        frase.append("Um(a) ");
        frase.append(nomeFilho);
        frase.append(" ______ mas um(a) ");
        frase.append(nomePai);
        frase.append(" n\u00e3o.");
        return frase.toString();
    }
}
