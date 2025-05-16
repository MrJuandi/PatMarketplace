package edu.comillas.icai.gitt.pat.spring.proyectofinal.services;

import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.Cart;
import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.AppUser;
import edu.comillas.icai.gitt.pat.spring.proyectofinal.models.Product;
import edu.comillas.icai.gitt.pat.spring.proyectofinal.repository.CartRepository;
import edu.comillas.icai.gitt.pat.spring.proyectofinal.repository.AppUserRepository;
import edu.comillas.icai.gitt.pat.spring.proyectofinal.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final AppUserRepository appUserRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, AppUserRepository appUserRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.appUserRepository = appUserRepository;
        this.productRepository = productRepository;
    }

    public List<Cart> getCartByUserId(Long userId) {
        Optional<AppUser> user = appUserRepository.findById(userId);
        return user.map(cartRepository::findByUser).orElse(List.of());
    }

    public Cart addToCart(Long userId, Long productId, int quantity) {
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(quantity);

        return cartRepository.save(cart);
    }

    public void clearCart(Long userId) {
        AppUser user = appUserRepository.findById(userId).orElseThrow();
        cartRepository.deleteByUser(user);
    }
}
