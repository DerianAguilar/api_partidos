package com.apiPartidos.api_partidos.Services;

import com.apiPartidos.api_partidos.Data.entidades.UsuarioEntity;
import com.apiPartidos.api_partidos.Repositories.IUsuarioRepository;
import com.apiPartidos.api_partidos.Shared.UsuarioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {

        if (iUsuarioRepository.findByEmail(usuarioDto.getEmail()) != null){
            throw new RuntimeException("Este correo ya se encuentra Registrado");
        }
        if (iUsuarioRepository.findByUsername(usuarioDto.getUsername()) != null){
            throw new RuntimeException("Este nombre de usuario ya esta en uso");
        }

        UsuarioEntity usuario = modelMapper.map(usuarioDto, UsuarioEntity.class);
        usuario.setIdUsuario(UUID.randomUUID().toString());
        usuario.setPasswordEncriptada(passwordEncoder.encode(usuarioDto.getPassword()));

        UsuarioEntity usuarioEntity = iUsuarioRepository.save(usuario);

        UsuarioDto usuarioDto1 = modelMapper.map(usuarioEntity, UsuarioDto.class);

        return usuarioDto1;
    }

    @Override
    public UsuarioDto leerUsuario(String username) {

        UsuarioEntity usuarioEntity = iUsuarioRepository.findByUsername(username);

        if (usuarioEntity == null){
            throw new UsernameNotFoundException(username);
        }

        return modelMapper.map(usuarioEntity, UsuarioDto.class);
    }
}
