/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.lista;

import controlador.lista.excepciones.NullListException;
import controlador.lista.excepciones.PositionNotFoundException;

/**
 *
 * @author Iván González
 */
public class ListaEnlazada<E> {
    
    private NodoLista<E> cabecera;
    private Integer size;
    private ListaEnlazada<E> lista;
    
    public ListaEnlazada(){
        cabecera = null;
        size = 0;
    }
    
    public Boolean estaVacia(){
        return cabecera == null;
    }
    
    public void insertar(E dato){
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if(estaVacia()){
            this.cabecera = nodo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {                
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }
    
    public void insertarCabecera(E dato){
        if(estaVacia()){
            insertar(dato);
        } else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }
    
    public void insertarPosicion(E dato, Integer pos) throws PositionNotFoundException{
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size){
            if (pos == (size - 1)) {
                insertar(dato);
            } else if (pos == 0){
                insertarCabecera(dato);
            } else {
                NodoLista<E> nodo = new NodoLista<>(dato, null);
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < (pos -1); i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }
        } else {
            throw new PositionNotFoundException();
        }
    }
 
    public Boolean imprimir() {
        System.out.println("-------------LISTA---------------");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.print(aux.getDato().toString() + "\n\n");
            aux = aux.getSiguiente();
        }
        System.out.println("\n--------------------------------");
        return true;
    }
    
    public E obtener(Integer pos) throws PositionNotFoundException, NullListException{
        if(!estaVacia()){
            E dato = null;
            if (pos >= 0 && pos < size) {
                if(pos == 0){
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PositionNotFoundException();
            }
            return dato;
        } else {
            throw new NullListException();
        }
    }
    
    public void modificarDato(E dato, Integer pos)throws PositionNotFoundException{
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size){
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {
                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }
        } else {
            throw new PositionNotFoundException();
        }
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ListaEnlazada<E> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<E> lista) {
        this.lista = lista;
    }
    
}
