/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1arreglos;

import controlador.PersonaController;

import java.util.Arrays;
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
        Persona p = new Persona("Maria", "Delgado", "Femenino", "20/03/2003");
        PersonaController pc = new PersonaController(5);
        pc.setPersona(p);
        try {
            System.out.println(pc.getPersona().getNombre() + " " + pc.getPersona().getApellido());
            pc.calcularEdad(p);
            System.out.println(pc.calcularEdad(p));
            System.out.println(pc.clasificarPorEdad(p));
            System.out.println(pc.getPersona().getPracticas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
