package com.thomaskavi.workshopmongo.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// A anotação @Document indica que esta classe será mapeada para uma coleção no MongoDB.
@Document(collection = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	// A anotação @Id indica que este campo será a chave primária da coleção no
	// MongoDB.
	@Id
	private String id;
	private String name;
	private String email;

	// Construtor padrão (sem argumentos), necessário para algumas operações de
	// serialização e deserialização.
	public User() {
	}

	// Construtor com argumentos, permite criar um objeto User com valores iniciais
	// para id, name e email.
	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	// Métodos getter e setter para acessar e modificar os campos privados id, name
	// e email.
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Sobrescrita do método hashCode para gerar um código hash baseado no campo id.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// Sobrescrita do método equals para comparar dois objetos User com base no
	// campo id.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
