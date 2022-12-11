package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.composstark.entity.Distrito;
import pe.com.composstark.repository.DistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository repositorio;

    @Override
    public List<Distrito> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Distrito> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Distrito> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Distrito add(Distrito d) {
        return repositorio.save(d);
    }

    @Override
    public Distrito update(Distrito d) {
        Distrito objdistrito = repositorio.getById(d.getCodigo());
        BeanUtils.copyProperties(d, objdistrito);
        return repositorio.save(objdistrito);
    }

    @Override
    public Distrito delete(Distrito d) {
        Distrito objdistrito = repositorio.getById(d.getCodigo());
        objdistrito.setEstado(false);
        return repositorio.save(objdistrito);
    }

}
