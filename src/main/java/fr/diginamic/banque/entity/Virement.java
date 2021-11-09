package fr.diginamic.banque.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Classe qui représente l'entité virement
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08 /11/2021
 */
@Entity
@DiscriminatorValue("V")
public class Virement extends Operation{
    @Column(name = "beneficiaire", length = 50)
    private String beneficiaire;

    /**
     * Instantiates a new Virement.
     *
     * @param date         the date
     * @param montant      the montant
     * @param motif        the motif
     * @param beneficiaire the beneficiaire
     */
    public Virement(LocalDateTime date, Double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    /**
     * Instantiates a new Virement.
     *
     * @param beneficiaire the beneficiaire
     */
    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    /**
     * Instantiates a new Virement.
     */
    public Virement() {

    }

    /**
     * Gets beneficiaire.
     *
     * @return the beneficiaire
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    /**
     * Sets beneficiaire.
     *
     * @param beneficiaire the beneficiaire
     */
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}