/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidades;

import com.google.gson.Gson;
import controlador.lista.ListaEnlazada;
import controlador.persona.PersonaController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import modelo.Genero;
import modelo.Persona;

/**
 *
 * @author Iván González
 */
public class Utilidades {

    public static String DISCARPDATA = "data";
    public static String fichero = "";
    public static Gson gson = new Gson();
        
    public static void cargarGenero(JComboBox cbx){
        cbx.removeAllItems();
        for (Genero genero : Genero.values()) {
            cbx.addItem(genero);
        }
    }
    
    public static Genero obtenerGenero(JComboBox cbx){
        return(Genero)cbx.getSelectedItem();
    }
    
    public static void seleccionarPersona(JTable tbl, JTextArea txt){
        try {
            int fila=tbl.getSelectedRow();
            if (fila>=0) {
                txt.setText(tbl.getValueAt(fila, 4).toString());
            }else JOptionPane.showMessageDialog(null, "Fila no seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e.toString());
        }
    }
    
    public static boolean guardarJson(PersonaController personas){
        String json = gson.toJson(personas);
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(DISCARPDATA + File.separatorChar + "persona.json"))) {
            bw.write(json);
            System.out.println("Fichero creado");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    public static PersonaController cargarJson(){
        try(BufferedReader br = new BufferedReader(new FileReader(DISCARPDATA + File.separatorChar + "persona.json"))){
            String linea;
            while ((linea = br.readLine()) != null) {                
                fichero = fichero + linea;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        PersonaController personas = gson.fromJson(fichero, PersonaController.class);
        return personas;
    }
}
