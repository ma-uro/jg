/**
 * 
 * @author Mauro
 * @version 1.0
 *
 */

package com.jogo.control;

public class Contador
{
    private static int contador;
    
    static {
        Contador.contador = 1;
    }
    
    public static final int getContador() {
        return Contador.contador;
    }
    
    public final void incrementa() {
        ++Contador.contador;
    }
}
