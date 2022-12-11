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
import pe.com.composstark.entity.Empleado;
import pe.com.composstark.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService servicio;

    @GetMapping
    public List<Empleado> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Empleado> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Empleado> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Empleado add(@RequestBody Empleado e) {
        return servicio.add(e);
    }

    @PutMapping("/{id}")
    public Empleado update(@PathVariable long id, @RequestBody Empleado e) {
        e.setCodigo(id);
        return servicio.update(e);
    }

    @DeleteMapping("/{id}")
    public Empleado delete(@PathVariable long id) {
        Empleado objempleado = new Empleado();
        objempleado.setEstado(false);
        return servicio.delete(Empleado.builder().codigo(id).build());
    }
}
