package sptech.school.api_projeto_goway.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.api_projeto_goway.Model.MotoristaModel;

import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<MotoristaModel, Long> {

    Optional<MotoristaModel> findByNome(String nome);

}
