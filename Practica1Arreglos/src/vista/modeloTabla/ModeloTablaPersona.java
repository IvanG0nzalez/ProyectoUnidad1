/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author Iván González
 */
public class ModeloTablaPersona extends AbstractTableModel{
    private Persona personas[];

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    @Override
    public int getRowCount() {
        return personas.length;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
//            case 0: return "Nro";
            case 0: return "Nombre";
            case 1: return "Genero";
            case 2: return "Edad";
            case 3: return "Clasificación";
            case 4: return "Practicas";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona p = personas[rowIndex];
        switch(columnIndex){
//            case 0: return (rowIndex + 1);
            case 0: return (p != null) ? p.getNombre() + " " + p.getApellido(): "SIN ESPECIFICAR";
            case 1: return (p != null) ? p.getGenero(): "SIN ESPECIFICAR";
            case 2: return (p != null) ? p.getEdad().toString(): "SIN ESPECIFICAR";
            case 3: return (p != null) ? p.getClasificacion(): "SIN ESPECIFICAR";
            case 4: return (p != null) ? p.getPracticas(): "SIN ESPECIFICAR";
            default: return null;
        }
    }
    
    
}
