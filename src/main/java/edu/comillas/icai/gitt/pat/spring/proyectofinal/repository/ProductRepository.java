package edu.comillas.icai.gitt.pat.spring.proyectofinal.repository;

import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll(); // útil para listar productos

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByOwnerId(Long ownerId);
}