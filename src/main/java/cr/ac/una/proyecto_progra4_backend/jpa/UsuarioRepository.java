/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.jpa;

/**
 *
 * @author Aaron
 */
import cr.ac.una.proyecto_progra4_backend.domain.Usuario;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aaron
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query("SELECT u FROM Usuario u WHERE LOWER(u.cedula) = LOWER(:cedula)")
    Optional<Usuario> findByCedulaIgnoreCase(@Param("cedula") String cedula);
}
