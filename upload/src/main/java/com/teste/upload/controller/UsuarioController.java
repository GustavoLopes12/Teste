package com.teste.upload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.teste.upload.model.Usuario;
import com.teste.upload.repository.UsuarioRepository;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.http.MediaType;




@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static String caminhoimg = System.getProperty("user.home") + "\\Desktop\\Teste-Upload\\imagens\\";
	
	//pegar todos os usuarios
	@GetMapping
	public Iterable<Usuario> getUsuario(){
		return usuarioRepository.findAll();
	}
	//GET por id	
	@GetMapping("/{id}")
	public Usuario BuscaUsuarioId(@PathVariable long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	// Get imagem do usuario por id 
	
	//criar usuario com id auto incrementado e foto 
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Usuario adicionarUsuario(@ModelAttribute Usuario user, @RequestParam("file") MultipartFile arquivo) {
		try {
			if(arquivo != null) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths.get(caminhoimg+arquivo.getOriginalFilename());
				Files.write(caminho, bytes);
				user.setImage_url(arquivo.getOriginalFilename());
			} else {
				user.setImage_url(null);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return usuarioRepository.save(user);
	}
	//ver a foto do usuario
	
	
}
