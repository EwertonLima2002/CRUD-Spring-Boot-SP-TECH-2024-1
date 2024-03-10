package sptech.school.api_projeto_goway.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.api_projeto_goway.Model.UsuarioModel;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByNome(String nome);

    Optional<UsuarioModel> findById(Long id);
    UsuarioModel save(UsuarioModel usuario);

    void deleteById(Long id);

    boolean existsById(Long id);


}
