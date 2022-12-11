package pe.com.composstark.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.composstark.entity.Pagos;
import pe.com.composstark.repository.PagosRepository;

@Service
public class PagosServiceImpl implements PagosService {

    @Autowired
    private PagosRepository repositorio;

    @Override
    public List<Pagos> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Pagos> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Pagos> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Pagos add(Pagos p) {
        return repositorio.save(p);
    }

    @Override
    public Pagos update(Pagos p) {
        Pagos objpagos = repositorio.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objpagos);
        return repositorio.save(objpagos);
    }

    @Override
    public Pagos delete(Pagos p) {
        Pagos objpagos = repositorio.getById(p.getCodigo());
        objpagos.setEstado(false);
        return repositorio.save(objpagos);
    }

}
