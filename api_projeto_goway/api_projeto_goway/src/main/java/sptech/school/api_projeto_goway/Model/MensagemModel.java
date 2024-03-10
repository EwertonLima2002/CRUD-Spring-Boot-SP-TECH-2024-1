package sptech.school.api_projeto_goway.Model;

public class MensagemModel {

    private String conteudo;
    private String remetente;
    private String destinatario;
    private Tipo tipo;

    public enum Tipo {
        CHAT,
        JOIN,
        LEAVE
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
