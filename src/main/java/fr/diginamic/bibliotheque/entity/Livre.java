package fr.diginamic.bibliotheque.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe qui représente l'entité Livre
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 05/11/2021
 */
@Table(name = "LIVRE")
@Entity
public class Livre {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "TITRE", nullable = false)
    private String titre;

    @Column(name = "AUTEUR", nullable = false, length = 50)
    private String auteur;

    @ManyToMany(mappedBy = "livres")
    private Set<Emprunt> emprunts;

    /**
     * Instantiates a new Livre.
     *
     * @param titre  the titre
     * @param auteur the auteur
     */
    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    /**
     * Instantiates a new Livre.
     */
    public Livre() {

    }

    /**
     * Gets auteur.
     *
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Sets auteur.
     *
     * @param auteur the auteur
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * Gets titre.
     *
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Sets titre.
     *
     * @param titre the titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets emprunts.
     *
     * @return the emprunts
     */
    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    /**
     * Sets emprunts.
     *
     * @param emprunts the emprunts
     */
    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}