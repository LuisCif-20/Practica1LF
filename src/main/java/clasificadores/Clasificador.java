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
    private final char[] NUMEROSN;
    private final String[] listaPalabras;

    public Clasificador(String[] listaPalabras) {
        this.NUMEROS = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        this.LETRAS = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        this.SIMBOLOS = new String[]{"[", "]", "{", "}", ";", ","};
        this.listaPalabras = listaPalabras;
        this.NUMEROSN = new char[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    }

    public boolean clasificadorNumerosEnteros(int indice) {
        boolean esEntero = true;
        for (int j = 0; j < this.listaPalabras[indice].length(); j++) {
            if (!Character.isDigit(this.listaPalabras[indice].charAt(j))) {
                esEntero = false;
                return esEntero;
            }

        }
        return esEntero;
    }

    public boolean clasificadorNumerosDecimal(int indice) {
        boolean esDecimal = false;
        int puntosDecimal = 0;
        for (int i = 0; i < this.listaPalabras[indice].length(); i++) {
            char caracter = this.listaPalabras[indice].charAt(i);
            if (Character.compare(caracter, '.') == 0 & puntosDecimal < 1) {
                puntosDecimal++;
                esDecimal = true;
            } else if (!Character.isDigit(this.listaPalabras[indice].charAt(i)) | Character.compare(caracter, '.') == 0) {
                esDecimal = false;
                return esDecimal;
            }

        }
        return esDecimal;
    }

    public boolean clasificarSimbolo(int indice) {
        boolean esSimbolo = false;
        for (int i = 0; i < this.listaPalabras[indice].length(); i++) {
            char caracter = this.listaPalabras[indice].charAt(i);
            if (Character.compare(caracter, '[') == 0 | Character.compare(caracter, ']') == 0) {
                esSimbolo = true;
                return esSimbolo;
            } else if (Character.compare(caracter, '{') == 0 | Character.compare(caracter, '}') == 0) {
                esSimbolo = true;
                return esSimbolo;
            } else if (Character.compare(caracter, ';') == 0 | Character.compare(caracter, ',') == 0) {
                esSimbolo = true;
                return esSimbolo;
            }
        }
        return esSimbolo;
    }

    public boolean clasificarId(int indice) {
        boolean esId = false;

        if (Character.isLetter(this.listaPalabras[indice].charAt(0))) {
            esId = true;
            for (int i = 1; i < this.listaPalabras[indice].length(); i++) {
                if (Character.compare(this.listaPalabras[indice].charAt(i), '.') == 0) {
                    esId = false;
                    break;
                }
            }
            return esId;
        }
        return esId;
    }

}
