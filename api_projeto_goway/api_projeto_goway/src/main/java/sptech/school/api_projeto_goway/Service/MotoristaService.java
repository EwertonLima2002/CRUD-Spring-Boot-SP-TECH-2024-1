package sptech.school.api_projeto_goway.Service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.api_projeto_goway.Model.MotoristaModel;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    @Autowired
    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public MotoristaModel cadastrarMotorista(@Valid MotoristaModel motorista) {
        return motoristaRepository.save(motorista);
    }

    public MotoristaModel atualizarMotorista(@Valid MotoristaModel motorista) {
        if (motorista.getId() == null) {
            return null;
        }
        Optional<MotoristaModel> motoristaExistente = motoristaRepository.findById(motorista.getId());

        if (motoristaExistente.isPresent()) {
            MotoristaModel motoristaAtualizado = motoristaExistente.get();
            motoristaAtualizado.setNome(motorista.getNome());
            motoristaAtualizado.setCnh(motorista.getCnh());
            return motoristaRepository.save(motoristaAtualizado);
        } else {
            return null;
        }
    }


    public void deletarMotorista(Long id) {

        motoristaRepository.deleteById(id);
    }

    public Optional<MotoristaModel> buscarMotoristaPorNome(@NotEmpty String nome) {
        return motoristaRepository.findByNome(nome);
    }

    public List<MotoristaModel> listarMotoristas() {
        return motoristaRepository.findAll();
    }

    public MotoristaModel buscarMotorista(MotoristaModel motorista) {
        return motoristaRepository.findById(motorista.getId()).orElse(null);
    }

    public List<MotoristaModel> ordenarMotoristas() {
        List<MotoristaModel> motoristas = motoristaRepository.findAll();

        if (motoristas != null && motoristas.size() > 1) {
            quickSort(motoristas, 0, motoristas.size() - 1);
        }

        return motoristas;
    }

    private void quickSort(List<MotoristaModel> motoristas, int low, int high) {
        if (low < high) {
            int pi = partition(motoristas, low, high);

            quickSort(motoristas, low, pi - 1);
            quickSort(motoristas, pi + 1, high);
        }
    }

    private int partition(List<MotoristaModel> motoristas, int low, int high) {
        String pivot = motoristas.get(high).getNome();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (motoristas.get(j).getNome().compareTo(pivot) < 0) {
                i++;

                MotoristaModel temp = motoristas.get(i);
                motoristas.set(i, motoristas.get(j));
                motoristas.set(j, temp);
            }
        }

        MotoristaModel temp = motoristas.get(i + 1);
        motoristas.set(i + 1, motoristas.get(high));
        motoristas.set(high, temp);

        return i + 1;
    }
    public Optional<MotoristaModel> buscarMotoristaPorId(Long id) {
        return motoristaRepository.findById(id);
    }

}
