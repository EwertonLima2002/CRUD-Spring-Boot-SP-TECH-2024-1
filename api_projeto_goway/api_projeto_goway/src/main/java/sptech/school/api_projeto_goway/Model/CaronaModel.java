package sptech.school.api_projeto_goway.Model;

import java.util.Date;

public class CaronaModel implements Caronavel {

    private String origem;
    private String destino;
    private boolean status;
    private Date dataCorrida;
    private UsuarioModel usuario;
    private MotoristaModel motorista;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDataCorrida() {
        return dataCorrida;
    }

    public void setDataCorrida(Date dataCorrida) {
        this.dataCorrida = dataCorrida;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public MotoristaModel getMotorista() {
        return motorista;
    }

    public void setMotorista(MotoristaModel motorista) {
        this.motorista = motorista;
    }

    @Override
    public double calcularValorDaViagem(double distancia, double tempoEstimado) {
        return 0;
    }
}
