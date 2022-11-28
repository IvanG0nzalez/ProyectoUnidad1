/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.excepciones;

/**
 *
 * @author Iván González
 */
public class FechaNoValidaException extends Exception{
    public FechaNoValidaException(String msg){
        super(msg);
    }
    
    public FechaNoValidaException(){
        super("La fecha ingresada no es válida");
    }
}
