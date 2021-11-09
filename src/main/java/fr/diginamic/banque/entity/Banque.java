package fr.diginamic.banque.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe qui représente l'entité Banque
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
@Table(name = "Banque")
@Entity
public class Banque{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nom", nullable = false, length = 50)
    private String nom;
    @OneToMany(mappedBy = "banque")
    private Set<ClientBanque> clients;

    /**
     * Instantiates a new Banque.
     *
     * @param nom the nom
     */
    public Banque(String nom) {
        this.nom = nom;
    }

    /**
     * Instantiates a new Banque.
     */
    public Banque() {
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
     * Gets clients.
     *
     * @return the clients
     */
    public Set<ClientBanque> getClients() {
        return clients;
    }

    /**
     * Sets clients.
     *
     * @param clients the clients
     */
    public void setClients(Set<ClientBanque> clients) {
        this.clients = clients;
    }
}