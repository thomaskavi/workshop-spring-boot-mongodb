package com.thomaskavi.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thomaskavi.workshopmongo.domain.Post;
import com.thomaskavi.workshopmongo.resources.util.URL;
import com.thomaskavi.workshopmongo.services.PostService;

// Anotação que indica que esta classe é um controlador REST.
@RestController
// Mapeia todas as requisições que começarem com "/users" para esta classe.
@RequestMapping(value = "/posts")
public class PostResource {

	// Injeta automaticamente uma instância de UserService.
	@Autowired
	private PostService service;

	// Mapeia requisições GET para o método findById, ou seja, quando um usuário
	// fizer uma requisição GET para "/users/{id}".
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		// Chama o serviço para buscar o usuário pelo ID.
		Post obj = service.findById(id);
		// Retorna o UserDTO correspondente com o status HTTP 200 (OK).
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
