package sptech.school.api_projeto_goway.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.api_projeto_goway.Model.Caronavel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carona")
public class CaronaApp {

    private List<Caronavel> caronas = new ArrayList<>();

}
