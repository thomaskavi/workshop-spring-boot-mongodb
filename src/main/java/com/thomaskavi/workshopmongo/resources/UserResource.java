package com.thomaskavi.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.thomaskavi.workshopmongo.domain.User;
import com.thomaskavi.workshopmongo.dto.UserDTO;
import com.thomaskavi.workshopmongo.services.UserService;

// Anotação que indica que esta classe é um controlador REST.
@RestController
// Mapeia todas as requisições que começarem com "/users" para esta classe.
@RequestMapping(value = "/users")
public class UserResource {

	// Injeta automaticamente uma instância de UserService.
	@Autowired
	private UserService service;

	// Mapeia requisições GET para o método findAll, ou seja, quando um usuário
	// fizer uma requisição GET para "/users".
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		// Chama o serviço para buscar todos os usuários.
		List<User> list = service.findAll();
		// Converte a lista de User para uma lista de UserDTO.
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		// Retorna a lista de UserDTO com o status HTTP 200 (OK).
		return ResponseEntity.ok().body(listDto);
	}

	// Mapeia requisições GET para o método findById, ou seja, quando um usuário
	// fizer uma requisição GET para "/users/{id}".
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		// Chama o serviço para buscar o usuário pelo ID.
		User obj = service.findById(id);
		// Retorna o UserDTO correspondente com o status HTTP 200 (OK).
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		User obj = service.fromDTO(objDto); 
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
				
	}
}
