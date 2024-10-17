package com.teste.upload.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	//atributos
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String picole_favorito;
	private String image_url;
	//construtores
	public Usuario(long id, String nome, String picole_favorito, String image_url) {
		this.id = id;
		this.nome = nome;
		this.picole_favorito = picole_favorito;
		this.image_url = image_url;
	}
	public Usuario() {
		//default
	}
	//metodos get e set
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPicole_favorito() {
		return picole_favorito;
	}
	public void setPicole_favorito(String picole_favorito) {
		this.picole_favorito = picole_favorito;
	}
}
