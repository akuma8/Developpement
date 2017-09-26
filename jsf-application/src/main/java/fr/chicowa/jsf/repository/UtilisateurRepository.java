package fr.chicowa.jsf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.chicowa.jsf.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmail( String email );
}
