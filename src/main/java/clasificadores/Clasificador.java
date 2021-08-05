/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

/**
 *
 * @author nroda
 */
public class Clasificador {

    private final String[] NUMEROS;
    private final String[] LETRAS;
    private final String[] SIMBOLOS;
    private final String[] listaPalabras;

    public Clasificador(String[] listaPalabras) {
        this.NUMEROS = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        this.LETRAS = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        this.SIMBOLOS = new String[]{"[", "]", "{", "}", ";", ","};
        this.listaPalabras = listaPalabras;
    }

    public boolean clasificadorNumerosEnteros(int indice) {
        boolean esEntero = true;
        for (int j = 0; j < this.listaPalabras[indice].length() - 1; j++) {
            for (String NUMEROS1 : this.NUMEROS) {
                if (this.listaPalabras[indice].substring(j, j + 1).equals(NUMEROS1) & esEntero) {
                    esEntero = true;
                } else {
                    esEntero = false;
                    return esEntero;
                }
            }
        }
        return esEntero;
    }

    public boolean clasificadorNumerosDecimal(int indice) {
        boolean esDecimal = false;
        int puntosDecimal = 0;
        for (int i = 0; i < this.listaPalabras[indice].length() - 1; i++) {
            for (int j = 0; j < this.NUMEROS.length; j++) {
                if (this.listaPalabras[indice].substring(i, i + 1).equals(".") & puntosDecimal < 1) {
                    puntosDecimal++;
                    esDecimal = true;
                } else if (!this.listaPalabras[indice].substring(i, i + 1).equals(this.NUMEROS[j]) | this.listaPalabras[indice].substring(i, i + 1).equals(".")) {
                    esDecimal = false;
                    return esDecimal;
                }
            }
        }
        return esDecimal;
    }

    public boolean clasificarSimbolo(int indice) {
        boolean esSimbolo = false;
        for (int i = 0; i < this.listaPalabras[indice].length() - 1; i++) {
            for (int j = 0; j < this.SIMBOLOS.length; j++) {
                if (this.listaPalabras[indice].substring(i, i + 1).equals(this.SIMBOLOS[j])) {
                    esSimbolo = true;
                    return esSimbolo;
                }
            }
        }
        return esSimbolo;
    }

    public boolean clasificarId(int indice) {
        boolean esId = false;
        for (int i = 0; i < this.LETRAS.length; i++) {
            if (this.listaPalabras[indice].substring(0, 1).equals(this.LETRAS[i])) {
                esId = true;
            }
        }
        if (esId) {
            for (int i = 1; i < this.listaPalabras[indice].length() - 1; i++) {
                if (this.listaPalabras[indice].substring(i, i + 1).equals(".")) {
                    return false;
                }
            }
        }
        return esId;
    }
    

}
