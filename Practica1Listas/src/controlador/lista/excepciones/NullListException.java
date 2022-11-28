/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.lista.excepciones;

/**
 *
 * @author Iván González
 */
public class NullListException extends Exception{
    public NullListException(String msg){
        super(msg);
    }
    
    public NullListException(){
        super("La lista está vacía");
    }
}
