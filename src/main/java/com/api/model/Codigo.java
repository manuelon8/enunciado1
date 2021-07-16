package com.api.model;

import java.io.Serializable;

public class Codigo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	private String codigo;

	public Codigo(int id, String codigo) {
		super();
		this.id = id;
		this.codigo = codigo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}  

}
