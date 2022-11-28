/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.persona;

import controlador.excepciones.FechaNoValidaException;
import controlador.lista.ListaEnlazada;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import modelo.Genero;
import modelo.Persona;

/**
 *
 * @author Iván González
 */
public class PersonaController {
    
    public static String VALORDEFECTO = "Sin Especificar";
    private final String practicasNiño = "-Mantenerse hidratado\t\n-Ingerir bebidas o alimentos frios\n-Chupar caramelos duros\n-Aplicar gotas nasales de solución salina\n-Usar humificador de vapor frío";
    private final String practicasJoven = "-Matenerse hidratado\n-Hacer gárgaras con agua salada\n-Utilizar atomizadores para la congestión\n-Chupar caramelos duros";
    private final String practicasAdulto ="-Mantenerse hidratado\n-Ingerir líquidos calientes\n-Descansar lo suficiente\n-Evitar fumar\n";
    private final String practicasTerceraEdad ="-Mantenerse hidratado\n-Mantener un dieta rica en vitaminas\n-Descansar lo suficiente\n-Matener un ambiente húmedo";
    private ListaEnlazada<Persona> personas = new ListaEnlazada<>();
    private Persona persona;

    public PersonaController() {
    }
    
    public Integer calcularEdad(Persona persona) throws FechaNoValidaException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(persona.getFechaNacimiento(), formatter);
        
        if (fechaNacimiento.isAfter(LocalDate.now()) || fechaNacimiento.isBefore(LocalDate.of(1875, 2, 21))) {
            throw new FechaNoValidaException();
        } else {
            Period edad = Period.between(fechaNacimiento, LocalDate.now());
            persona.setEdad(edad.getYears());
//            this.persona.setEdad(edad.getYears());
        }
        return persona.getEdad();
    }
     
    
    public String clasificarPorEdad(Persona persona){
        if (persona.getEdad() > 0 && persona.getEdad() <= 12) {
            persona.setClasificacion("Niño");
            persona.setPracticas(practicasNiño);
        } else if(persona.getEdad() > 12 && persona.getEdad() <= 18){
            persona.setClasificacion("Joven");
            persona.setPracticas(practicasJoven);
        } else if (persona.getEdad() > 18 && persona.getEdad() <= 59) {
            persona.setClasificacion("Adulto");
            persona.setPracticas(practicasAdulto);
        } else if(persona.getEdad() > 59){
            persona.setClasificacion("Tercera Edad");
            persona.setPracticas(practicasTerceraEdad);
        }
        return persona.getClasificacion();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ListaEnlazada<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ListaEnlazada<Persona> personas) {
        this.personas = personas;
    }

    
    
    
    
    
}
