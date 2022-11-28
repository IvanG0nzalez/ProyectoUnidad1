/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1listas;

import controlador.lista.ListaEnlazada;
import controlador.persona.PersonaController;
import modelo.Genero;
import modelo.Persona;

/**
 *
 * @author Iván González
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEnlazada<Persona> lista = new ListaEnlazada<>();
        PersonaController pc = new PersonaController();
        Persona p = new Persona("Iván", "González", Genero.Masculino ,"14/05/2003");
        Persona p2 = new Persona("Maria", "Delgado", Genero.Femenino ,"14/05/2007");
        Persona p3 = new Persona("Nikol", "Luna", Genero.Femenino,"23/07/2004");
        Persona p4 = new Persona("Claudia", "Encalada", Genero.Femenino ,"30/12/2003");
        Persona p5 = new Persona("Kevin", "Bustamante", Genero.Masculino ,"17/08/2003");//        pc.setPersona(p);
        try {
            pc.calcularEdad(p);
            pc.calcularEdad(p2);
            pc.calcularEdad(p3);
            pc.clasificarPorEdad(p);
            pc.clasificarPorEdad(p2);
            pc.clasificarPorEdad(p3);
        } catch (Exception e) {
            System.out.println(e);
        }
        lista.insertar(p);
        lista.insertar(p2);
        lista.insertar(p3);
        lista.insertar(p4);
        try {
            lista.insertarPosicion(p5, 2);
        } catch (Exception e) {
            System.out.println(e);
        }
//        lista.imprimir();
//        pc.setLista(lista);
//        System.out.println(pc.getLista().imprimir());
        
        
    }
    
}
