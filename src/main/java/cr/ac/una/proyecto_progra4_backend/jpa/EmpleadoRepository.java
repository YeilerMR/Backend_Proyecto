/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.jpa;

import cr.ac.una.proyecto_progra4_backend.domain.Empleado;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kinco
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query("SELECT c FROM Empleado c WHERE c.usuario.credencial = 1")
    List<Empleado> getEmpleados();

    @Query("SELECT c FROM Empleado c WHERE c.usuario.credencial = 1")
    Page<Empleado> getEmpleadosPages(Pageable pageable);

    @Query("SELECT c FROM Empleado c WHERE c.usuario.cedula = :cedula")
    Optional<Empleado> findByCedula(String cedula);

    @Query("SELECT c FROM Empleado c WHERE c.usuario.email = :email")
    Optional<Empleado> findByEmail(String email);

    @Query("SELECT c FROM Empleado c WHERE c.usuario.telefono = :telefono")
    Optional<Empleado> findByTelefono(String telefono);

}
