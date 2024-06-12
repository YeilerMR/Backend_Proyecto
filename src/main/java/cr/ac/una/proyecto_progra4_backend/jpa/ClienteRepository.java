/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.proyecto_progra4_backend.jpa;

import cr.ac.una.proyecto_progra4_backend.domain.Cliente;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aaron
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.usuario.credencial = 0")
    List<Cliente> getClientes();

    @Query("SELECT c FROM Cliente c WHERE c.usuario.credencial = 0")
    Page<Cliente> getClientesPages(Pageable pageable);

    @Query("SELECT c FROM Cliente c WHERE c.usuario.cedula = :cedula")
    Cliente findByCedula(String cedula);

    @Query("SELECT c FROM Cliente c WHERE c.usuario.email = :email")
    Cliente findByEmail(String email);

    @Query("SELECT c FROM Cliente c WHERE c.usuario.telefono = :telefono")
    Cliente findByTelefono(String telefono);
    // @Query("SELECT DISTINCT e.cliente FROM Envio e")
    // List<Cliente> findClientesConEnvios();
}
