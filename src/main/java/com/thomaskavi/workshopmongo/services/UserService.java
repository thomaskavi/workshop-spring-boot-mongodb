package com.thomaskavi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomaskavi.workshopmongo.domain.User;
import com.thomaskavi.workshopmongo.repository.UserRepository;
import com.thomaskavi.workshopmongo.services.exception.ObjectNotFoundException;

// Indica que esta classe é um serviço do Spring, gerenciável pelo container de injeção de dependências.
@Service
public class UserService {

	// Injeta automaticamente uma instância de UserRepository.
	@Autowired
	private UserRepository repo;

	// Método para retornar todos os usuários.
	public List<User> findAll() {
		return repo.findAll();
	}

	// Método para encontrar um usuário pelo ID.
	public User findById(String id) {
		// Procura o usuário no repositório pelo ID.
		Optional<User> obj = repo.findById(id);
		// Se não encontrar o usuário, lança uma exceção customizada.
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
