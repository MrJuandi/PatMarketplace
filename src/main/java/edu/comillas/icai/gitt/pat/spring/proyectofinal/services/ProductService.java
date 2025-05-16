package edu.comillas.icai.gitt.pat.spring.proyectofinal.services;

import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.AppUser;
import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.Product;

import java.util.List;

import edu.comillas.icai.gitt.pat.spring.proyectofinal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAll() {
        return productRepository.findAll();
    }


    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }


    public Product save(Product product) {
        return productRepository.save(product);
    }


    public void delete(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> searchByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getByOwnerId(Long ownerId) {
        return productRepository.findByOwnerId(ownerId);
    }

    public AppUser getOwnerByProductId(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return product.getOwner();
    }
}
