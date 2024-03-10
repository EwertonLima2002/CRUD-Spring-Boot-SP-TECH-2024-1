package sptech.school.api_projeto_goway.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.school.api_projeto_goway.Model.UsuarioModel;
import sptech.school.api_projeto_goway.Service.UsuarioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioModel> buscarUsuarioPorNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuario) {
        usuario.setId(null);
        usuario.setDataCriacao(new Date());
        usuario.setDataAtualizacao(new Date());

        return usuarioRepository.save(usuario);
    }

    public UsuarioModel atualizarUsuario(UsuarioModel usuario) {
        if (usuario.getId() != null && usuarioRepository.existsById(usuario.getId())) {
            usuario.setDataAtualizacao(new Date());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioModel buscarIdUsuario(UsuarioModel usuario) {
        return usuarioRepository.findById(usuario.getId()).orElse(null);
    }


}
