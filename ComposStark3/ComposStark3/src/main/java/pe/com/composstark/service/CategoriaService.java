package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import pe.com.composstark.entity.Categoria;

public interface CategoriaService {

    // MOSTRAR TODA LA LISTA
    public List<Categoria> findAll();

    // MOSTRAR SOLO LOS HABILITADOS
    public List<Categoria> findAllCustom();

    // BUSCAR POR CODIGO
    public Optional<Categoria> findById(long id);

    // REGISTRAR
    public Categoria add(Categoria c);

    // ACTUALIZAR
    public Categoria update(Categoria c);

    // BORRAR
    public Categoria delete(Categoria c);
}
