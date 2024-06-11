/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.Usuario;
import java.util.List;

/**
 *
 * @author Aaron
 */
public interface IUsuarioServices {
    public Usuario agregar(Usuario usuario);

    public List<Usuario> getUsuarios();

    public Usuario getUsuarioPorCedula(String cedula);

    public Usuario getUsuarioPorID(int idUsuario);

    public boolean eliminar(int idUsuario);
}
