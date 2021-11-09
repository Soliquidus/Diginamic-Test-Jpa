package fr.diginamic.banque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe qui représente l'entité Livret A
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
@Entity
@DiscriminatorValue("L")
public class LivretA extends Compte {
    @Column(name = "taux", nullable = false)
    private Double taux;

    /**
     * Instantiates a new Livret a.
     *
     * @param numero the numero
     * @param solde  the solde
     * @param taux   the taux
     */
    public LivretA(String numero, Double solde, Double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    /**
     * Instantiates a new Livret a.
     *
     * @param taux the taux
     */
    public LivretA(Double taux) {
        this.taux = taux;
    }

    /**
     * Instantiates a new Livret a.
     */
    public LivretA() {
    }

    /**
     * Gets taux.
     *
     * @return the taux
     */
    public Double getTaux() {
        return taux;
    }

    /**
     * Sets taux.
     *
     * @param taux the taux
     */
    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
