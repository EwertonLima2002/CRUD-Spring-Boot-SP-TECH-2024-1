package sptech.school.api_projeto_goway.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

public class MotoristaModel extends UsuarioModel{

    private String cnh;
    private String categoriaCnh;
    private Date validadeCnh;
    private String estadoEmissorCnh;

    @OneToMany(mappedBy = "motorista" , cascade = CascadeType.ALL)
    private List<CarroModel> carros;

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCategoriaCnh() {
        return categoriaCnh;
    }

    public void setCategoriaCnh(String categoriaCnh) {
        this.categoriaCnh = categoriaCnh;
    }

    public Date getValidadeCnh() {
        return validadeCnh;
    }

    public void setValidadeCnh(Date validadeCnh) {
        this.validadeCnh = validadeCnh;
    }

    public String getEstadoEmissorCnh() {
        return estadoEmissorCnh;
    }

    public void setEstadoEmissorCnh(String estadoEmissorCnh) {
        this.estadoEmissorCnh = estadoEmissorCnh;
    }

    public List<CarroModel> getCarros() {
        return carros;
    }

    public void setCarros(List<CarroModel> carros) {
        this.carros = carros;
    }
}
