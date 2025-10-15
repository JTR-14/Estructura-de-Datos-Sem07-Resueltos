/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio03;

/**
 *
 * @author USER
 */
public class Perfil {

    private String usuario;
    private int nMensajes;
    private boolean activo;

    public Perfil(String usuario, int nMensajes, boolean activo) {
        this.usuario = usuario;
        this.nMensajes = nMensajes;
        this.activo = activo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getnMensajes() {
        return nMensajes;
    }

    public void setnMensajes(int nMensajes) {
        this.nMensajes = nMensajes;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
