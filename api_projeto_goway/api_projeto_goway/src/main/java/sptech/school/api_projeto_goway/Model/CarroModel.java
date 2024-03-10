package sptech.school.api_projeto_goway.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "carro")
public class CarroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marcaCarro;
    private String modeloCarro;
    private String placaCarro;
    private String corCarro;
    private String anoCarro;

    @ManyToMany
    @JoinColumn(name = "id_motorista")
    private MotoristaModel motorista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getCorCarro() {
        return corCarro;
    }

    public void setCorCarro(String corCarro) {
        this.corCarro = corCarro;
    }

    public String getAnoCarro() {
        return anoCarro;
    }

    public void setAnoCarro(String anoCarro) {
        this.anoCarro = anoCarro;
    }

    public MotoristaModel getMotorista() {
        return motorista;
    }

    public void setMotorista(MotoristaModel motorista) {
        this.motorista = motorista;
    }
}
