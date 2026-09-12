package com.huellitas.service;

import com.huellitas.exception.RecursoNoEncontradoException;
import com.huellitas.model.Estado;
import com.huellitas.model.Mascota;
import com.huellitas.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public Mascota registrarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    public Mascota buscarMascotaPorId(Long id) {
        return mascotaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(
                "No existe el mascota con el id: " + id
        ));
    }

    public List<Mascota> buscarMascotaPorEstado(Estado estado) {
        return mascotaRepository.findByEstado(estado);
    }

    public Mascota actualizar(Long id, Mascota datos) {
        Mascota existente = buscarMascotaPorId(id);

        existente.setNombre(datos.getNombre());
        existente.setTipo(datos.getTipo());
        existente.setEdad(datos.getEdad());
        existente.setEstado(datos.getEstado());

        return mascotaRepository.save(existente);
    }

    public void eliminarMascotaPorId(Long id) {
        Mascota existente = buscarMascotaPorId(id);
        mascotaRepository.delete(existente);
    }
}
