package fr.diginamic.bibliotheque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Classe pour tester les requêtes en BDD
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 05/11/2021
 */
public class TestBibliotheque {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBibliotheque.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");
        EntityManager em = emf.createEntityManager();

//        Réalisez un find simple permettant d’extraire un livre en fonction de son identifiant et affichez son titre et son auteur.
        Livre livre = em.find(Livre.class, 1);
        if (livre != null) {
            String nom = livre.getTitre();
            String auteur = livre.getAuteur();
            LOGGER.info("Nom du livre : " + nom + ", auteur : " + auteur);
        } else {
            LOGGER.error("Livre non trouvé");
        }

//        Insérez un nouveau Livre de votre choix en base de données
        em.getTransaction().begin();
        Livre newLivre = new Livre("La Nuit des Temps","René Barjavel");
        em.persist(newLivre);
        em.getTransaction().commit();

//        Modifiez le titre du livre d’identifiant 5 qui possède une erreur : le nouveau titre doit être
//        « Du plaisir dans la cuisine » au lieu de « 1001 recettes de Cuisine ».
        Livre cuisine = em.find(Livre.class, 5);
        if (cuisine != null) {
            cuisine.setTitre("Du plaisir dans la cuisine");
        } else {
            LOGGER.error("Erreur de récupération des données");
        }

//        Faites une requête JPQL pour extraire de la base un livre en fonction de son titre.
        TypedQuery<Livre> searchTitle = em.createQuery("SELECT l FROM Livre l WHERE l.titre ='Germinal'", Livre.class);
        Livre nuitDesTemps = searchTitle.getResultList().get(0);
        if (nuitDesTemps != null) {
            String nom = nuitDesTemps.getTitre();
            String auteur = nuitDesTemps.getAuteur();
            LOGGER.info("Livre cherché : " + nom + ", par " + auteur);
        } else {
            LOGGER.error("Livre non trouvé");
        }

//        Faites une requête JPQL pour extraire de la base un livre en fonction de son auteur.
        TypedQuery<Livre> searchAuthor = em.createQuery("SELECT l FROM Livre l WHERE l.auteur ='Emile Zola'", Livre.class);
        Livre zola = searchAuthor.getResultList().get(0);
        if (zola != null) {
            String nom = zola.getTitre();
            String auteur = zola.getAuteur();
            LOGGER.info("Auteur cherché : " + auteur + ", livres : " + nom);
        } else {
            LOGGER.error("Livre non trouvé");
        }

//        Supprimez un livre de votre choix en base de données.
        em.getTransaction().begin();
        Livre delete = em.find(Livre.class, 7);
        if(delete != null){
            em.remove(delete);
        } else {
            LOGGER.error("Livre non trouvé");
        }
        em.getTransaction().commit();
    }
}