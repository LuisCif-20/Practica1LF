/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica1lf;

import clasificadores.DivisorDePalabras;

/**
 *
 * @author nroda
 */
public class Principal {
    
    public static void main(String[] args) {
        DivisorDePalabras clas = new DivisorDePalabras("adsfadsf 56523[adsf adsf;256 ghj ,");
        clas.dividirPalabras();
    }
    
}
