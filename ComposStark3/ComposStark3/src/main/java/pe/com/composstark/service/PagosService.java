package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import pe.com.composstark.entity.Pagos;

public interface PagosService {

    // MOSTRAR TODA LA LISTA
    public List<Pagos> findAll();

    // MOSTRAR SOLO LOS HABILITADOS
    public List<Pagos> findAllCustom();

    // BUSCAR POR CODIGO
    public Optional<Pagos> findById(long id);

    // REGISTRAR
    public Pagos add(Pagos f);

    // ACTUALIZAR
    public Pagos update(Pagos f);

    // BORRAR
    public Pagos delete(Pagos f);
}