package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import pe.com.composstark.entity.Distrito;

public interface DistritoService {

    // MOSTRAR TODA LA LISTA
    public List<Distrito> findAll();

    // MOSTRAR SOLO LOS HABILITADOS
    public List<Distrito> findAllCustom();

    // BUSCAR POR CODIGO
    public Optional<Distrito> findById(long id);

    // REGISTRAR
    public Distrito add(Distrito d);

    // ACTUALIZAR
    public Distrito update(Distrito d);

    // BORRAR
    public Distrito delete(Distrito d);
}
