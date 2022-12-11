package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import pe.com.composstark.entity.Producto;

public interface ProductoService {

    // MOSTRAR TODA LA LISTA
    public List<Producto> findAll();

    // MOSTRAR SOLO LOS HABILITADOS
    public List<Producto> findAllCustom();

    // BUSCAR POR CODIGO
    public Optional<Producto> findById(long id);

    // REGISTRAR
    public Producto add(Producto p);

    // ACTUALIZAR
    public Producto update(Producto p);

    // BORRAR
    public Producto delete(Producto p);
}
