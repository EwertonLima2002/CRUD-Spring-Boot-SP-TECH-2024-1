package sptech.school.api_projeto_goway.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.api_projeto_goway.Model.MotoristaModel;
import sptech.school.api_projeto_goway.Service.MotoristaService;

import java.util.Optional;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    private final MotoristaService motoristaService;

    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }


    @PostMapping("/cadastrarMotorista")
    public void cadastrarMotorista(@RequestBody MotoristaModel motorista) {
        try {
            motoristaService.cadastrarMotorista(motorista);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar motorista", e);
        }
    }

    @PutMapping("/atualizarMotorista/{id}")
    public void atualizarMotorista(@RequestBody MotoristaModel motorista) {
        motoristaService.atualizarMotorista(motorista);
    }

    @DeleteMapping("/deletarMotorista")
    public void deletarMotorista( @RequestBody MotoristaModel motorista) {
        motoristaService.deletarMotorista(motorista.getId());
    }

    @GetMapping("/buscarMotorista")
    public void buscarMotorista(@RequestBody MotoristaModel motorista) {
        motoristaService.buscarMotorista(motorista);
    }

    @GetMapping("/listarMotoristas")
    public void listarMotoristas() {
        motoristaService.listarMotoristas();
    }
    @GetMapping ("/ordenarMotoristas")
    public void ordenarMotoristas() {
        motoristaService.ordenarMotoristas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaModel> buscarMotoristaPorId(@PathVariable Long id) {
        Optional<MotoristaModel> motoristaOptional = motoristaService.buscarMotoristaPorId(id);

        return motoristaOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
