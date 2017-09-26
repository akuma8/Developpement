package fr.chicowa.jsf.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fr.chicowa.jsf.entities.Product;
import fr.chicowa.jsf.entities.Utilisateur;

@Repository
public class RepositoryContainer {

    public interface ProductRepository extends JpaRepository<Product, Long> {
    }

    public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
        Utilisateur findByEmail( String email );
    }

    @Component
    public class Container {

        @Autowired
        public ProductRepository     productRepository;

        @Autowired
        public UtilisateurRepository utilisateurRepository;
    }
}
