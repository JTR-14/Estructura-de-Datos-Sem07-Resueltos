/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaCircular;

import javax.swing.DefaultListModel;


public class ListaCircularSimple<T> {
    

    protected Nodo<T> ultimo;

    public ListaCircularSimple() {
        this.ultimo = null;
    }

    public boolean esVacia() {
        return ultimo == null;
    }

    public void inserta(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        
        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.setSgte(ultimo);
        } else {
            nuevo.setSgte(ultimo.getSgte());
            ultimo.setSgte(nuevo);
            ultimo = nuevo;
        }
    }
    public Nodo<T> buscar(T valor) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> p = ultimo.getSgte();
            do {
                if (p.getInfo().equals(valor)) {
                    return p;
                } else {
                    p = p.getSgte();
                }
            } while (p != ultimo.getSgte());
            return null;
        }
    }

    public int contar() {
        if (esVacia()) {
            return 0;
        } else {
            int contador = 0;
            Nodo<T> p = ultimo.getSgte();
            do {
                contador++;
                p = p.getSgte();
            } while (p != ultimo.getSgte());
            return contador;
        }
    }
     public boolean eliminar(T valor) {
        if (esVacia()) {
            return false;
        } else {
            Nodo<T> p = ultimo.getSgte();
            if (p.getInfo().equals(valor)) {
                if (p == ultimo) {
                    ultimo = null;
                } else {
                    ultimo.setSgte(p.getSgte());
                }
                return true;
            } else {
                Nodo<T> anterior = p;
                p = p.getSgte();
                do {
                    if (!p.getInfo().equals(valor)) {
                        anterior = p;
                        p = p.getSgte();
                    }
                } while (p != ultimo.getSgte() && !p.getInfo().equals(valor));
                
                if (p == ultimo.getSgte()) {
                    return false;
                } else {
                    anterior.setSgte(p.getSgte());
                    if (p == ultimo) {
                        ultimo = anterior;
                    }
                    return true;
                }
            }
        }
    }
     public void mostrar(DefaultListModel<T> modelo) {
    modelo.removeAllElements();
    if (!esVacia()) {
        Nodo<T> p = ultimo.getSgte();
        do {
            modelo.addElement(p.getInfo());
            p = p.getSgte();
        } while (p != ultimo.getSgte());
    }
}
}
