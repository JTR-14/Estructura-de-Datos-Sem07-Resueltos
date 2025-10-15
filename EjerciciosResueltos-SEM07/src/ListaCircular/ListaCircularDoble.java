/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaCircular;

/**
 *
 * @author USER
 */

import javax.swing.DefaultListModel;

public class ListaCircularDoble<T> {

    private NodoDoble<T> ultimo;

    public ListaCircularDoble() {
        this.ultimo = null;
    }

    public boolean esVacia() {
        return ultimo == null;
    }

    public void inserta(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);
        if (esVacia()) {
            nuevo.setSig(nuevo);
            nuevo.setAnt(nuevo);
            ultimo = nuevo;
        } else {
            NodoDoble<T> primero = ultimo.getSig();
            nuevo.setSig(primero);
            primero.setAnt(nuevo);
            nuevo.setAnt(ultimo);
            ultimo.setSig(nuevo);
            ultimo = nuevo;
        }
    }

    public boolean eliminar(T valor) {
        if (esVacia()) {
            return false;
        }

        NodoDoble<T> p = ultimo.getSig();

        do {
            if (p.getInfo().equals(valor)) {
                if (p == ultimo && p.getSig() == p) {
                    ultimo = null;
                } else {
                    NodoDoble<T> anterior = p.getAnt();
                    NodoDoble<T> siguiente = p.getSig();
                    anterior.setSig(siguiente);
                    siguiente.setAnt(anterior);

                    if (p == ultimo) {
                        ultimo = anterior;
                    }
                }
                return true;
            }
            p = p.getSig();
        } while (p != ultimo.getSig());

        return false;
    }

    public NodoDoble<T> buscar(T valor) {
        if (esVacia()) {
            return null;
        }
        NodoDoble<T> p = ultimo.getSig();
        do {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getSig();
        } while (p != ultimo.getSig());
        return null;
    }

    public int contar() {
        if (esVacia()) {
            return 0;
        }
        int contador = 0;
        NodoDoble<T> p = ultimo.getSig();
        do {
            contador++;
            p = p.getSig();
        } while (p != ultimo.getSig());
        return contador;
    }

    public void mostrar(DefaultListModel<T> modelo) {
        modelo.removeAllElements();
        if (!esVacia()) {
            NodoDoble<T> p = ultimo.getSig();
            do {
                modelo.addElement(p.getInfo());
                p = p.getSig();
            } while (p != ultimo.getSig());
        }
    }

}
