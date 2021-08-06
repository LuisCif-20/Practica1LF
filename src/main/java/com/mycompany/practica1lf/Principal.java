/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1lf;

import clasificadores.DivisorDePalabras;
import clasificadores.Especificador;
import tokens.Token;

/**
 *
 * @author nroda
 */
public class Principal {

    public static void main(String[] args) {
        DivisorDePalabras clas = new DivisorDePalabras("adsf56 [bjv.hj 65.235,asdf 56 13 as.lp");
        for (int i = 0; i < clas.dividirPalabras().length; i++) {
            System.out.println(clas.dividirPalabras()[i]);
        }
        System.out.println("------------------------------------------------");
        
        Especificador es = new Especificador(clas.dividirPalabras());
        es.especificarPalabra();
        for (int i = 0; i < es.getPalabras().length; i++) {
            System.out.println(es.getPalabras()[i] + "          " + es.getTipo()[i]);
        }
        
    }

}
