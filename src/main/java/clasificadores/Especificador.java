/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import tokens.Token;

/**
 *
 * @author nroda
 */
public class Especificador {
    
    Clasificador clasificador;
    private String[] palabras;
    private String[] tipo;

    public Especificador(String[] palabras) {
        this.palabras = palabras;
        this.tipo = new String[this.palabras.length];
        this.clasificador = new Clasificador(this.palabras);
    }
    
    public void especificarPalabra(){
        for (int i = 0; i < this.palabras.length; i++) {
            if (clasificador.clasificarId(i)) {
                this.tipo[i] = Token.IDENTIFICADOR.getIdentificador();
            } else if (clasificador.clasificadorNumerosEnteros(i)) {
                this.tipo[i] = Token.ENTERO.getIdentificador();
            } else if (clasificador.clasificadorNumerosDecimal(i)) {
                this.tipo[i] = Token.DECIMAL.getIdentificador();
            } else if (clasificador.clasificarSimbolo(i)) {
                this.tipo[i] = Token.SIMBOLO.getIdentificador();
            } else {
                this.tipo[i] = Token.ERROR.getIdentificador();
            }
        }
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public Clasificador getClasificador() {
        return clasificador;
    }

    public void setClasificador(Clasificador clasificador) {
        this.clasificador = clasificador;
    }

    public String[] getPalabras() {
        return palabras;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }


    
    

    
    
}
