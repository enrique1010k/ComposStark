package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import pe.com.composstark.entity.Detallefactura;

public interface DetallefacturaService {

    // MOSTRAR TODA LA LISTA
    public List<Detallefactura> findAll();

    // MOSTRAR SOLO LOS HABILITADOS
    public List<Detallefactura> findAllCustom();

    // BUSCAR POR CODIGO
    public Optional<Detallefactura> findById(long id);

    // REGISTRAR
    public Detallefactura add(Detallefactura d);

    // ACTUALIZAR
    public Detallefactura update(Detallefactura d);

    // BORRAR
    public Detallefactura delete(Detallefactura d);
}
