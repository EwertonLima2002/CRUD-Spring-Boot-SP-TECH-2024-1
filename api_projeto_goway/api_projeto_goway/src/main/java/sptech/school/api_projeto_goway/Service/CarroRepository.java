package sptech.school.api_projeto_goway.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.api_projeto_goway.Model.CarroModel;

public interface CarroRepository extends JpaRepository<CarroModel, Long> {
}
