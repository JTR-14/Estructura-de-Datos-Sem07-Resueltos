/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02;

import ListaCircular.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    public void siguienteModerador(){
        if(esVacia() || contar()==1)
            JOptionPane.showMessageDialog(null, "No cuenta con los datos suficientes para realizar esta operacion","ADVERTENCIA",0);
        else{
            do{
                moderadorActual = moderadorActual.getSgte();
            }while(!moderadorActual.getInfo().isActivo());
            JOptionPane.showMessageDialog(null, "El siguiente moderador es: "+moderadorActual.getInfo().getNombre(),"INFORMACION",1);
        }
    }
    public void cicloTurnos(DefaultListModel modelo){
        modelo.removeAllElements();
        Nodo<Moderador> p = ultimo.getSgte();
        int i = 1;
        do{
            if(p.getInfo().isActivo()){
                modelo.addElement("Turno "+i+". "+p.getInfo().getNombre());
                i++;
            }
            p = p.getSgte();
        }while(p != ultimo.getSgte());
    }
    public void mostrarTabla(DefaultTableModel modelo) {
        int n = contar();
        String[] titulos = {
            "NOMBRE", "NIVEL", "ACTIVO"
        };
        Object[][] datos = new Object[n][3];
        Nodo<Moderador> p = ultimo.getSgte();
        int i = 0;
        
        do{
            Moderador mod = p.getInfo();
            datos[i][0] = mod.getNombre();
            datos[i][1] = mod.getNivel();
            datos[i][2] = mod.isActivo();

            p = p.getSgte();
            i++;
        }while(p != ultimo.getSgte());

        modelo.setDataVector(datos, titulos);
    }
}
