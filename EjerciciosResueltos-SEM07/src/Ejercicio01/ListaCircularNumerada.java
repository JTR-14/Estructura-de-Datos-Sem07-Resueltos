/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01;

import ListaCircular.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
public class ListaCircularNumerada extends ListaCircularSimple<Integer> {
    public void llenar(int n){
        if(n<=0)
            JOptionPane.showMessageDialog(null,"El Numero debe ser mayor a cero","ERROR",0);
        else{
            for(int i = 1; i<=n; i++)
                this.inserta(i);
            
        }
    }
    public void eliminarK(int k, DefaultListModel modelo){
        modelo.removeAllElements();
        if( k<=0 || esVacia() || contar() == 1){
            JOptionPane.showMessageDialog(null,"No se puede realizar la eliminacion con esos cambios","ERROR",0);
        }
        else{
            Nodo<Integer> anterior = ultimo;
            int numeroDeOrden = 1;
            while(contar()>1){
                for(int i=0; i < k-1; i++)
                    anterior = anterior.getSgte();
                Nodo<Integer> eliminado = anterior.getSgte();
                modelo.addElement(numeroDeOrden+". "+eliminado.getInfo());
                numeroDeOrden++;
                anterior.setSgte(eliminado.getSgte());
                if(ultimo == eliminado)
                    ultimo = anterior;
            }
        }
    }
    public void mostrarSobreviviente(){
        JOptionPane.showMessageDialog(null,"El sobreviviente es: " + ultimo.getInfo());
    }
}
