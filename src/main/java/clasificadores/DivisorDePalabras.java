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
public class DivisorDePalabras {

    private String cadenaingresada;
    private final String[] simbolos = {"{", "}", "[", "]", ";", ","};

    public DivisorDePalabras(String cadenaingresada) {
        this.cadenaingresada = cadenaingresada;
    }

    public String[] dividirPalabras() {
        int espacios = this.verEspaciosVacios();
        System.out.println(espacios);
        int indice = 0;
        String[] palabras = new String[espacios];
        for (int i = 0; i < palabras.length; i++) {
            for (int j = indice; j < this.cadenaingresada.length(); j++) {
                if (j == this.cadenaingresada.length() - 1) {
                    palabras[i] = this.cadenaingresada.substring(indice, j + 1);
                    break;
                }
                if (this.cadenaingresada.substring(j, j + 1).equals(" ")) {
                    palabras[i] = this.cadenaingresada.substring(indice, j);
                    indice = j + 1;
                    break;
                } else if (this.esSimbolo(j, indice, palabras, i)) {
                    if (j == 0) {
                        palabras[i] = this.cadenaingresada.substring(j, j + 1);
                        indice = j + 1;
                        break;
                    } else {
                        palabras[i] = this.cadenaingresada.substring(indice, j);
                        palabras[i + 1] = this.cadenaingresada.substring(j, j + 1);
                        i++;
                        indice = j + 1;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }
        return palabras;
    }

    public boolean esSimbolo(int j, int indice, String[] palabras, int i) {
        for (int l = 0; l < simbolos.length; l++) {
            if (this.cadenaingresada.substring(j, j + 1).equals(simbolos[l])) {
                return true;
            }
        }
        return false;
    }

    public int verEspaciosVacios() {
        int espacios = 1;
        for (int i = 0; i < this.cadenaingresada.length() - 1; i++) {
            if (this.cadenaingresada.substring(i, i + 1).equals(" ")) {
                espacios++;
            } else {
                for (int k = 0; k < simbolos.length; k++) {
                    if (this.cadenaingresada.substring(i, i + 1).equals(simbolos[k])) {
                        if (i == 0) {
                            espacios++;
                        } else {
                            espacios += 2;

                        }
                    }
                }
            }
        }
        return espacios;

    }

    public String getCadenaingresada() {
        return cadenaingresada;
    }

    public void setCadenaingresada(String cadenaingresada) {
        this.cadenaingresada = cadenaingresada;
    }

}
