package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Registro;
@Component
@Repository
public interface IRegistrarseRepository extends CrudRepository<Registro, Long> {

    public List<Registro> findByEstado(boolean estado);

    @Query("SELECT r FROM Registro r WHERE r.sexo LIKE %:sexo% AND r.estado = true")
    public List<Registro> findBySexo(String sexo);

}