/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio04;

/**
 *
 * @author USER
 */
public class PlaylistColaborativa {
    private int id;
    private String nombreCancion;
    private String usuarioCreador;

    public PlaylistColaborativa(int id, String nombreCancion, String usuarioCreador) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.usuarioCreador = usuarioCreador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(String usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }
    
}
