package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import pe.com.composstark.entity.Cliente;

public interface ClienteService {

    // MOSTRAR TODA LA LISTA
    public List<Cliente> findAll();

    // MOSTRAR SOLO LOS HABILITADOS
    public List<Cliente> findAllCustom();

    // BUSCAR POR CODIGO
    public Optional<Cliente> findById(long id);

    // REGISTRAR
    public Cliente add(Cliente c);

    // ACTUALIZAR
    public Cliente update(Cliente c);

    // BORRAR
    public Cliente delete(Cliente c);
}
