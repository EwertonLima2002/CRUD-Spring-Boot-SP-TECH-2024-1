
package sptech.school.api_projeto_goway.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin; // Importe a anotação CrossOrigin
import sptech.school.api_projeto_goway.Model.MensagemModel;

@Controller
@CrossOrigin(origins = "http://localhost:8080") // Permitir solicitações apenas a partir deste domínio
public class ChatController {

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public MensagemModel registrarMensagem(@Payload MensagemModel chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getConteudo());
        return chatMessage;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MensagemModel enviar(@Payload MensagemModel mensagem) {
        return mensagem;
    }
}
