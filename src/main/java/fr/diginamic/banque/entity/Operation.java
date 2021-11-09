package fr.diginamic.banque.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe qui représente l'entité Operation
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
@Table(name = "Operation")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @Column(name = "montant", nullable = false)
    private Double montant;
    @Column(name = "motif", length = 50)
    private String motif;
    @ManyToOne
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

    /**
     * Instantiates a new Operation.
     *
     * @param date    the date
     * @param montant the montant
     * @param motif   the motif
     */
    public Operation(LocalDateTime date, Double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }

    /**
     * Instantiates a new Operation.
     */
    public Operation() {
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
     * Gets date.
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Gets montant.
     *
     * @return the montant
     */
    public Double getMontant() {
        return montant;
    }

    /**
     * Sets montant.
     *
     * @param montant the montant
     */
    public void setMontant(Double montant) {
        this.montant = montant;
    }

    /**
     * Gets motif.
     *
     * @return the motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * Sets motif.
     *
     * @param motif the motif
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * Gets compte.
     *
     * @return the compte
     */
    public Compte getCompte() {
        return compte;
    }

    /**
     * Sets compte.
     *
     * @param compte the compte
     */
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}