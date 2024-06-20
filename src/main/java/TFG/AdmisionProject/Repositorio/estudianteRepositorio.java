package TFG.AdmisionProject.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TFG.AdmisionProject.modelo.estudiantes;

@Repository
public interface estudianteRepositorio extends JpaRepository<estudiantes, Long> {

}
