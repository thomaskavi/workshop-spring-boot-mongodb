package com.thomaskavi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomaskavi.workshopmongo.domain.Product;
import com.thomaskavi.workshopmongo.dto.ProductDTO;
import com.thomaskavi.workshopmongo.repository.ProductRepository;
import com.thomaskavi.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<Product> findAll() {
		return repo.findAll();
	}

	public Product findById(String id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Product insert(Product obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Product update(Product obj) {
		Product newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Product newObj, Product obj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
		newObj.setSize(obj.getSize());
		newObj.setStockQuantity(obj.getStockQuantity());
		newObj.setTotalMoneyInvested(obj.getTotalMoneyInvested());
	}

	public Product fromDTO(ProductDTO objDto) {
		return new Product(objDto.getId(), objDto.getName(), objDto.getDescription(), objDto.getSize(),
				objDto.getStockQuantity(), objDto.getPrice());
	}

}
