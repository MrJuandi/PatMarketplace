package edu.comillas.icai.gitt.pat.spring.proyectofinal.repository;

import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.Cart;
import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {
    List<Cart> findByUser(AppUser user);
    void deleteByUser(AppUser user);
}