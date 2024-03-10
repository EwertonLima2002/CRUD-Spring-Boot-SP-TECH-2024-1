package sptech.school.api_projeto_goway.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.api_projeto_goway.Model.CarroModel;
import sptech.school.api_projeto_goway.Model.MotoristaModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class CarroService {

    private final MotoristaRepository motoristaRepository;

    @Autowired
    public CarroService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    @PostMapping("/cadastrar-carro")
    public ResponseEntity<String> cadastrarCarroParaMotorista(
            @RequestParam Long idMotorista,
            @RequestBody CarroModel carro
    ) {
        Optional<MotoristaModel> motoristaOptional = MotoristaRepository.findById(idMotorista);
        if (motoristaOptional.isPresent()) {
            MotoristaModel motorista = motoristaOptional.get();
            carro.setMotorista(motorista);
            motorista.getCarros().add(carro);
            motoristaRepository.save(motorista);

            return ResponseEntity.ok("Carro cadastrado com sucesso para o motorista!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar-carro")
    public ResponseEntity<String> atualizarCarro(@RequestParam Long idMotorista, @RequestBody CarroModel carro) {
        Optional<MotoristaModel> motoristaOptional = motoristaRepository.findById(idMotorista);

        if (motoristaOptional.isPresent()) {
            MotoristaModel motorista = motoristaOptional.get();
            Optional<CarroModel> carroOptional = motorista.getCarros().stream()
                    .filter(c -> c.getId().equals(carro.getId()))
                    .findFirst();

            if (carroOptional.isPresent()) {
                CarroModel carroExistente = carroOptional.get();
                carroExistente.setMarcaCarro(carro.getMarcaCarro());
                carroExistente.setModeloCarro(carro.getModeloCarro());
                carroExistente.setPlacaCarro(carro.getPlacaCarro());
                motoristaRepository.save(motorista);
                return ResponseEntity.ok("Carro atualizado com sucesso!");
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar-carro")
    public ResponseEntity<String> deletarCarro(@RequestParam Long idMotorista, @RequestParam Long idCarro) {
        Optional<MotoristaModel> motoristaOptional = motoristaRepository.findById(idMotorista);
        if (motoristaOptional.isPresent()) {
            MotoristaModel motorista = motoristaOptional.get();
            Optional<CarroModel> carroOptional = motorista.getCarros().stream()
                    .filter(c -> c.getId().equals(idCarro))
                    .findFirst();
            if (carroOptional.isPresent()) {
                motorista.getCarros().remove(carroOptional.get());
                motoristaRepository.save(motorista);
                return ResponseEntity.ok("Carro deletado com sucesso!");
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/listar-carros")
    public ResponseEntity<List<CarroModel>> listarCarros(@RequestParam Long idMotorista) {
        Optional<MotoristaModel> motoristaOptional = motoristaRepository.findById(idMotorista);
        if (motoristaOptional.isPresent()) {
            MotoristaModel motorista = motoristaOptional.get();
            return ResponseEntity.ok(motorista.getCarros());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
