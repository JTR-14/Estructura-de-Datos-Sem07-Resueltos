/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio03;

import ListaCircular.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class ListaCircularPerfil extends ListaCircularDoble<Perfil>{
    private NodoDoble<Perfil> nodoActual = null;
    private int indiceActual = -1;
    public void mostrarTabla(DefaultTableModel modelo) {
        int n = contar();
        String[] titulos = {
            "USUARIO", "N° MENSAJES", "ACTIVO"
        };
        Object[][] datos = new Object[n][3];
        NodoDoble<Perfil> p = ultimo.getSig();
        int i = 0;
        
        do{
            Perfil mod = p.getInfo();
            datos[i][0] = mod.getUsuario();
            datos[i][1] = mod.getnMensajes();
            datos[i][2] = mod.isActivo();

            p = p.getSig();
            i++;
        }while(p != ultimo.getSig());

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
    public boolean eliminarInactivos(){
        if (esVacia()) {
            return false;
        }

        NodoDoble<Perfil> p = ultimo.getSig();
        do{
            NodoDoble<Perfil> anterior = p.getAnt();
            NodoDoble<Perfil> siguiente = p.getSig();
        }
    }
}
