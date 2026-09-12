package com.huellitas.repository;

import com.huellitas.model.Estado;
import com.huellitas.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    List<Mascota> findByEstado(Estado estado);
}
