/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;

import ListaCircular.*;

/**
 *
 * @author USER
 */
public class ListaCircularModerador extends ListaCircularSimple<Moderador>{
    Nodo<Moderador> moderadorActual;
     @Override
    public void inserta(Moderador valor) {
        super.inserta(valor);
        
        if (moderadorActual == null) {
            moderadorActual = ultimo;
        }
    }
}
