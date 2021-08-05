/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokens;

/**
 *
 * @author nroda
 */
public enum Token {
    
    IDENTIFICADOR("Es identificador"),ENTERO("Es un entero"),DECIMAL("Es un decimal"),ERROR("Es un error"),SIMBOLO("Es un simbolo");
    private final String identificador;
    
    private Token(String tipo){
        this.identificador = tipo;
    }
}
