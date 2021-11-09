package fr.diginamic.banque.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe qui représente l'entité Compte
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
@Table(name = "Compte")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numero", nullable = false, length = 50)
    private String numero;
    @Column(name = "solde", nullable = false)
    private Double solde;
    @ManyToMany(mappedBy = "comptes")
    private Set<ClientBanque> clients;
    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    /**
     * Instantiates a new Compte.
     *
     * @param numero the numero
     * @param solde  the solde
     */
    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    /**
     * Instantiates a new Compte.
     */
    public Compte() {
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
     * Gets numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets numero.
     *
     * @param numero the numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Gets solde.
     *
     * @return the solde
     */
    public Double getSolde() {
        return solde;
    }

    /**
     * Sets solde.
     *
     * @param solde the solde
     */
    public void setSolde(Double solde) {
        this.solde = solde;
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

    /**
     * Gets operations.
     *
     * @return the operations
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * Sets operations.
     *
     * @param operations the operations
     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}