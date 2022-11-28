/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.excepciones.FechaNoValidaException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
    private Persona[] personas;
    private Persona persona;

    public PersonaController(Integer nroPersonas) {
        personas = new Persona[nroPersonas];
        for (int i = 0; i < nroPersonas; i++) {
            Persona p = new Persona();
            p.setNombre(PersonaController.VALORDEFECTO);
            p.setApellido(VALORDEFECTO);
            p.setGenero(VALORDEFECTO);
            p.setClasificacion(VALORDEFECTO);
            p.setPracticas(VALORDEFECTO);
            p.setFechaNacimiento(VALORDEFECTO);
            p.setEdad(0);
            personas[i] = p;
        }
        
    }

    public PersonaController(){
        
    }

    public Integer calcularEdad(Persona persona) throws FechaNoValidaException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(persona.getFechaNacimiento(), formatter);
        
        if (fechaNacimiento.isAfter(LocalDate.now()) || fechaNacimiento.isBefore(LocalDate.of(1875, 2, 21))) {
            throw new FechaNoValidaException();
        } else {
            Period edad = Period.between(fechaNacimiento, LocalDate.now());
            persona.setEdad(edad.getYears());
        }
        return persona.getEdad();
    }
    

    public String clasificarPorEdad(Persona p){
        if (p.getEdad() >= 0 && p.getEdad() <= 14) {
            p.setClasificacion("Niño");
            p.setPracticas(practicasNiño);
        } else if(p.getEdad() > 14 && p.getEdad() <= 29){
            p.setClasificacion("Joven");
            p.setPracticas(practicasJoven);
        } else if (p.getEdad() > 29 && p.getEdad() <= 59) {
            p.setClasificacion("Adulto");
            p.setPracticas(practicasAdulto);
        } else if(p.getEdad() > 59){
            p.setClasificacion("Tercera Edad");
            p.setPracticas(practicasTerceraEdad);
        }
        return persona.getClasificacion();
    }
    
    

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "PersonaController{" + "personas=" + personas + '}';
    }

    
}
