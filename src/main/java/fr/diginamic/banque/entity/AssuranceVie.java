package fr.diginamic.banque.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Classe qui représente l'entité AssuranceVie
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
@Entity
@DiscriminatorValue("A")
public class AssuranceVie extends Compte {
    private LocalDate dateFin;
    private Double taux;

    /**
     * Instantiates a new Assurance vie.
     *
     * @param numero  the numero
     * @param solde   the solde
     * @param dateFin the date fin
     * @param taux    the taux
     */
    public AssuranceVie(String numero, Double solde, LocalDate dateFin, Double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    /**
     * Instantiates a new Assurance vie.
     *
     * @param dateFin the date fin
     * @param taux    the taux
     */
    public AssuranceVie(LocalDate dateFin, Double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    /**
     * Instantiates a new Assurance vie.
     */
    public AssuranceVie() {
    }

    /**
     * Gets date fin.
     *
     * @return the date fin
     */
    public LocalDate getDateFin() {
        return dateFin;
    }

    /**
     * Sets date fin.
     *
     * @param dateFin the date fin
     */
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
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
