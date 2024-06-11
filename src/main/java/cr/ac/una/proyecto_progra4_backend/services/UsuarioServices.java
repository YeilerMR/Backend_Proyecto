/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.services;

import cr.ac.una.proyecto_progra4_backend.domain.Usuario;
import cr.ac.una.proyecto_progra4_backend.jpa.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aaron
 */
@Service
@Primary
public class UsuarioServices implements IUsuarioServices {

    @Autowired
    private UsuarioRepository usrRepo;

    @Override
    public Usuario agregar(Usuario usuario) {
        try {
            return usrRepo.save(usuario);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usrRepo.findAll();
    }

    @Override
    public Usuario getUsuarioPorCedula(String cedula) {
        Optional<Usuario> optionalUsuario = usrRepo.findByCedulaIgnoreCase(cedula);
        return optionalUsuario.orElse(null);
    }

    @Override
    public Usuario getUsuarioPorID(int idUsuario) {
        Optional<Usuario> optionalUsuario = usrRepo.findById(idUsuario);
        return optionalUsuario.orElse(null);
    }

    @Override
    public boolean eliminar(int idUsuario) {
        try {
            usrRepo.deleteById(idUsuario);
            return true; // Se eliminó correctamente
        } catch (EmptyResultDataAccessException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
