package com.teste.upload.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.teste.upload.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
}
