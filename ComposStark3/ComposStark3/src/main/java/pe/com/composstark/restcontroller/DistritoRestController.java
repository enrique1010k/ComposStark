package pe.com.composstark.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.composstark.entity.Distrito;
import pe.com.composstark.service.DistritoService;

@RestController
@RequestMapping("/distrito")
public class DistritoRestController {

    @Autowired
    private DistritoService servicio;

    @GetMapping
    public List<Distrito> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Distrito> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Distrito> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Distrito add(@RequestBody Distrito d) {
        return servicio.add(d);
    }

    @PutMapping("/{id}")
    public Distrito update(@PathVariable long id, @RequestBody Distrito d) {
        d.setCodigo(id);
        return servicio.update(d);
    }

    @DeleteMapping("/{id}")
    public Distrito delete(@PathVariable long id) {
        Distrito objdistrito = new Distrito();
        objdistrito.setEstado(false);
        return servicio.delete(Distrito.builder().codigo(id).build());
    }
}
