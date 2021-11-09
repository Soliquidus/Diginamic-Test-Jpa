package fr.diginamic.banque.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Classe qui représente l'entité Client
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
@Table(name = "Client")
@Entity
public class ClientBanque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;
    @Column(name = "date_naissance", nullable = false, length = 50)
    private LocalDate dateNaissance;
    @Embedded
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;
    @ManyToMany
    @JoinTable(name = "Compte_Actif",
            joinColumns = @JoinColumn(name = "ID_CLI", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COM", referencedColumnName = "ID"))
    private Set<Compte> comptes;

    /**
     * Instantiates a new Client banque.
     *
     * @param nom           the nom
     * @param prenom        the prenom
     * @param dateNaissance the date naissance
     * @param adresse       the adresse
     * @param banque        the banque
     * @param comptes       the comptes
     */
    public ClientBanque(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque, Set<Compte> comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.banque = banque;
        this.comptes = comptes;
    }

    /**
     * Instantiates a new Client banque.
     *
     * @param nom           the nom
     * @param prenom        the prenom
     * @param dateNaissance the date naissance
     * @param adresse       the adresse
     */
    public ClientBanque(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    /**
     * Instantiates a new Client banque.
     */
    public ClientBanque() {
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
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets prenom.
     *
     * @param prenom the prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Gets date naissance.
     *
     * @return the date naissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Sets date naissance.
     *
     * @param dateNaissance the date naissance
     */
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Gets adresse.
     *
     * @return the adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse the adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Gets banque.
     *
     * @return the banque
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * Sets banque.
     *
     * @param banque the banque
     */
    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    /**
     * Gets comptes.
     *
     * @return the comptes
     */
    public Set<Compte> getComptes() {
        return comptes;
    }

    /**
     * Sets comptes.
     *
     * @param comptes the comptes
     */
    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}