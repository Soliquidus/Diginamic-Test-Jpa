package fr.diginamic.bibliotheque.repository;

import fr.diginamic.bibliotheque.TestBibliotheque;
import fr.diginamic.bibliotheque.entity.Client;
import fr.diginamic.bibliotheque.entity.Emprunt;
import fr.diginamic.bibliotheque.entity.Livre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Set;

/**
 * Class Functions
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
public class Functions {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");
    private static final EntityManager em = emf.createEntityManager();

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBibliotheque.class);
    //        Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné.
    public Set<Emprunt> findEmpruntByClient(Integer id){
        Client client = em.find(Client.class, id);
        Set<Emprunt> emprunts = null;
        int i = 0;
        if (client != null) {
            emprunts = client.getEmprunts();
            for (Emprunt emprunt : emprunts) {
                i++;
                LOGGER.info("Emprunt " + i + " : " +emprunt.getId() + " date d'emprunt : " +emprunt.getDateDebut());
            }
        } else {
            LOGGER.error("Emprunt non trouvé");
        }
        return emprunts;
    }

    //        Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.
    public Set<Livre> findLivreByEmprunt(Integer id){
        Emprunt emprunt = em.find(Emprunt.class, id);
        Set<Livre> livres = null;
        if (emprunt != null) {
            livres = emprunt.getLivres();
            for (Livre livre : livres) {
                LOGGER.info(livre.getTitre());
            }
        } else {
            LOGGER.error("Emprunt non trouvé");
        }
        return livres;
    }

    //    Réalisez un find simple permettant d’extraire un livre en fonction de son identifiant et affichez son titre et son auteur.
    public Livre getLivreById(Integer id) {
        Livre livre = em.find(Livre.class, id);
        if (livre != null) {
            String nom = livre.getTitre();
            String auteur = livre.getAuteur();
            LOGGER.info("Nom du livre : " + nom + ", auteur : " + auteur);
        } else {
            LOGGER.error("Livre non trouvé");
        }
        return livre;
    }

    //    Insérez un nouveau Livre de votre choix en base de données
    public void createLivre() {
        em.getTransaction().begin();
        Livre newLivre = new Livre("La Nuit des Temps", "René Barjavel");
        em.persist(newLivre);
        em.getTransaction().commit();
    }

    public void updateTitle(Integer id){
        //        Modifiez le titre du livre d’identifiant 5 qui possède une erreur : le nouveau titre doit être
//        « Du plaisir dans la cuisine » au lieu de « 1001 recettes de Cuisine ».
        Livre cuisine = em.find(Livre.class, id);
        if (cuisine != null) {
            cuisine.setTitre("Du plaisir dans la cuisine");
        } else {
            LOGGER.error("Erreur de récupération des données");
        }
    }

    public Livre findLivreByTitle(String title){
        //        Faites une requête JPQL pour extraire de la base un livre en fonction de son titre.
        TypedQuery<Livre> searchTitle = em.createQuery("SELECT l FROM Livre l WHERE l.titre ='" + title + "'", Livre.class);
        Livre livreCherche = searchTitle.getResultList().get(0);
        if (livreCherche != null) {
            String nom = livreCherche.getTitre();
            String auteur = livreCherche.getAuteur();
            LOGGER.info("Livre cherché : " + nom + ", par " + auteur);
        } else {
            LOGGER.error("Livre non trouvé");
        }
        return livreCherche;
    }

    public Livre findLivreByAuteur(String auteur){
        //        Faites une requête JPQL pour extraire de la base un livre en fonction de son auteur.
        TypedQuery<Livre> searchAuthor = em.createQuery("SELECT l FROM Livre l WHERE l.auteur ='" + auteur + "'", Livre.class);
        Livre livre = searchAuthor.getResultList().get(0);
        if (livre != null) {
            String nom = livre.getTitre();
            String aut = livre.getAuteur();
            LOGGER.info("Auteur cherché : " + aut + ", livres : " + nom);
        } else {
            LOGGER.error("Livre non trouvé");
        }
        return livre;
    }

    public void deleteLivre(Integer id){
        //        Supprimez un livre de votre choix en base de données.
        em.getTransaction().begin();
        Livre livre = em.find(Livre.class, id);
        if(livre != null){
            em.remove(livre);
            LOGGER.info("Livre supprimé");
        } else {
            LOGGER.error("Livre non trouvé");
        }
        em.getTransaction().commit();
    }

}