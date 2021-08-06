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

    public String[] dividirCadena() {
        int espacios = this.verEspaciosVacios();
        int indice = 0;
        String[] palabras = new String[espacios];
        for (int i = 0; i < palabras.length; i++) {
            for (int j = indice; j < this.cadenaingresada.length() - 1; j++) {
                if (j == this.cadenaingresada.length() - 1) {
                    palabras[i] = this.cadenaingresada.substring(indice, j + 1);
                    break;
                } else if (this.cadenaingresada.substring(j, j + 1).equals(" ")) {
                    palabras[i] = this.cadenaingresada.substring(indice, j);
                    indice = j + 1;
                    break;
                } else if (this.esSimbolo(j)) {
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
        return palabras;

    }

    public String[] dividirPalabras() {
        int espacios = this.verEspaciosVacios();
        int indice = 0;
        String[] palabras = new String[espacios];
        for (int i = 0; i < palabras.length; i++) {
            for (int j = indice; j < this.cadenaingresada.length(); j++) {
                char caracter = this.cadenaingresada.charAt(j);
                if (j == this.cadenaingresada.length() - 1) {
                    palabras[i] = this.cadenaingresada.substring(indice, j + 1);
                    break;
                } else if (Character.isWhitespace(caracter)) {
                    palabras[i] = this.cadenaingresada.substring(indice, j);
                    indice = j + 1;
                    break;
                } else if (this.esSimbolo(j)) {
                    if (j == 0) {
                        palabras[i] = this.cadenaingresada.substring(indice, j + 1);
                        indice++;
                        break;
                    } else {
                        if (Character.isWhitespace(this.cadenaingresada.charAt(j - 1))) {
                            palabras[i] = this.cadenaingresada.substring(indice, j + 1);
                            indice = j + 1;
                            break;
                        } else {
                            palabras[i] = this.cadenaingresada.substring(indice, j);
                            palabras[i + 1] = this.cadenaingresada.substring(j, j + 1);
                            i++;
                            if (Character.isWhitespace(this.cadenaingresada.charAt(j + 1))) {
                                indice = j + 2;

                            } else {
                                indice = j + 1;

                            }
                            break;
                        }
                    }
                }

            }
        }
        return palabras;
    }

//    public boolean esSimbolo(int j, int indice, String[] palabras, int i) {
//        for (int l = 0; l < simbolos.length; l++) {
//            if (this.cadenaingresada.substring(j, j + 1).equals(simbolos[l])) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean esSimbolo(int i) {
        if (Character.compare(this.cadenaingresada.charAt(i), '{') == 0 | Character.compare(this.cadenaingresada.charAt(i), '}') == 0) {
            return true;
        } else if (Character.compare(this.cadenaingresada.charAt(i), '[') == 0 | Character.compare(this.cadenaingresada.charAt(i), ']') == 0) {
            return true;
        } else if (Character.compare(this.cadenaingresada.charAt(i), ';') == 0 | Character.compare(this.cadenaingresada.charAt(i), ',') == 0) {
            return true;
        }

        return false;
    }

//    public int verEspaciosVacios() {
//        int espacios = 1;
//        for (int i = 0; i < this.cadenaingresada.length() - 1; i++) {
//            if (this.cadenaingresada.substring(i, i + 1).equals(" ")) {
//                espacios++;
//            } else {
//                for (int k = 0; k < simbolos.length; k++) {
//                    if (this.cadenaingresada.substring(i, i + 1).equals(simbolos[k])) {
//                        if (i == 0) {
//                            espacios++;
//                        } else {
//                            espacios += 2;
//
//                        }
//                    }
//                }
//            }
//        }
//        return espacios;
//
//    }
    public int verEspaciosVacios() {
        int espacios = 1;
        for (int i = 0; i < this.cadenaingresada.length(); i++) {
            if (Character.isWhitespace(this.cadenaingresada.charAt(i))) {
                espacios++;
            } else if (i != 0) {
                if (Character.compare(this.cadenaingresada.charAt(i), '{') == 0 | Character.compare(this.cadenaingresada.charAt(i), '}') == 0) {
                    espacios+= 2;
                } else if (Character.compare(this.cadenaingresada.charAt(i), '[') == 0 | Character.compare(this.cadenaingresada.charAt(i), ']') == 0) {
                    espacios+=2;
                } else if (Character.compare(this.cadenaingresada.charAt(i), ';') == 0 | Character.compare(this.cadenaingresada.charAt(i), ',') == 0) {
                    espacios+=2;
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
