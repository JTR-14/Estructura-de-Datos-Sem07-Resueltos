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
}
