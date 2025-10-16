/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

import ListaCircular.*;
import javax.swing.table.DefaultTableModel;


public class ListaCircularPlaylist extends ListaCircularDoble<PlaylistColaborativa> {
    NodoDoble<PlaylistColaborativa> nodoActual = null;
    int indiceActual = -1;
    
    public void mostrarTabla(DefaultTableModel modelo) {
        int n = contar();
        String[] titulos = {
            "ID", "CANCION", "USUARIO"
        };
        Object[][] datos = new Object[n][3];
        NodoDoble<PlaylistColaborativa> p = ultimo.getSig();
        int i = 0;

        do {
            PlaylistColaborativa play = p.getInfo();
            datos[i][0] = play.getId();
            datos[i][1] = play.getNombreCancion();
            datos[i][2] = play.getUsuarioCreador();

            p = p.getSig();
            i++;
        } while (p != ultimo.getSig());

        modelo.setDataVector(datos, titulos);
    }
     public int siguiente() {
        if (esVacia()) {
            return -1;
        }
        if (nodoActual == null) {
            nodoActual = ultimo.getSig();
            indiceActual = 0;
        } else {
            nodoActual = nodoActual.getSig();
            indiceActual++;
            if (indiceActual >= contar()) {
                indiceActual = 0;
            }
        }
        return indiceActual;
    }

    public int anterior() {
        if (esVacia()) {
            return -1;
        }
        if (nodoActual == null) {
            nodoActual = ultimo.getSig();
            indiceActual = 0;
        } else {
            nodoActual = nodoActual.getAnt();
            indiceActual--;
            if (indiceActual < 0) {
                indiceActual = contar() - 1;
            }
        }
        return indiceActual;
    }
     public void reiniciarNavegacion() {
        this.nodoActual = null;
        this.indiceActual = -1;
    }
     public void eliminarDuplicados() {
    if (esVacia() || contar() <= 1) {
        return;
    }

    NodoDoble<PlaylistColaborativa> actual = ultimo.getSig();
    
    for (int i = 0; i < contar(); i++) {
        NodoDoble<PlaylistColaborativa> comparador = actual.getSig();
        
        while (comparador != actual) {
            NodoDoble<PlaylistColaborativa> siguienteComparador = comparador.getSig();

            String nombreActual = actual.getInfo().getNombreCancion();
            String nombreComparador = comparador.getInfo().getNombreCancion();

            if (nombreActual.equalsIgnoreCase(nombreComparador)) {
                NodoDoble<PlaylistColaborativa> anterior = comparador.getAnt();
                anterior.setSig(siguienteComparador);
                siguienteComparador.setAnt(anterior);
                
                if (comparador == ultimo) {
                    ultimo = anterior;
                }
            }
            comparador = siguienteComparador;
        }
        actual = actual.getSig();
    }
}
}
