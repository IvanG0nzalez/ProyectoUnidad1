/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;

/**
 *
 * @author Iván González
 */
public class ModeloTablaPersona extends AbstractTableModel{

    private ListaEnlazada<Persona> lista = new ListaEnlazada<>();

    public ListaEnlazada<Persona> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Persona> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
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
        Persona p = null;
        try {
            p = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println(e);
        }
        switch(columnIndex){
            case 0: return (p != null) ? p.getNombre() + " " + p.getApellido(): "SIN ESPECIFICAR";
            case 1: return (p != null) ? p.getGenero().toString(): "SIN ESPECIFICAR";
            case 2: return (p != null) ? p.getEdad(): "SIN ESPECIFICAR";
            case 3: return (p != null) ? p.getClasificacion(): "SIN ESPECIFICAR";
            case 4: return (p != null) ? p.getPracticas(): "SIN ESPECIFICAR";
            default: return null;
            }
    }
    
}
