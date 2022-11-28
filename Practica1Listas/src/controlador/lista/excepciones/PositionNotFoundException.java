/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.lista.excepciones;

/**
 *
 * @author Iván González
 */
public class PositionNotFoundException extends Exception{
    public PositionNotFoundException(String msg){
        super(msg);
    }
    
    public PositionNotFoundException(){
        super("La posición solicitada no existe en la lista");
    }
}
