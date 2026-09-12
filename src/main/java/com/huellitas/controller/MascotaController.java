package com.huellitas.controller;

import com.huellitas.model.Estado;
import com.huellitas.model.Mascota;
import com.huellitas.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
    private final MascotaService service;

    public MascotaController(MascotaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Mascota> registrar(@Valid @RequestBody Mascota mascota) {
        Mascota creada = service.registrarMascota(mascota);

        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }


    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas() {
        return ResponseEntity.ok(service.listarMascotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> buscarMascota(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarMascotaPorId(id));
    }

    //-------Nueva funcionalidad

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Mascota>> buscarMascotaPorEstado(@PathVariable Estado estado) {
        return ResponseEntity.ok(service.buscarMascotaPorEstado(estado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Long id, @Valid @RequestBody Mascota mascota) {
        return ResponseEntity.ok(service.actualizar(id, mascota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarMascotaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
