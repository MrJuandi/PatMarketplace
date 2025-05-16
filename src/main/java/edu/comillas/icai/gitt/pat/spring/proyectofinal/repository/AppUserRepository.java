package edu.comillas.icai.gitt.pat.spring.proyectofinal.repository;

import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
