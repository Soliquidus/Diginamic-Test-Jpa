package fr.diginamic.banque.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe qui représente l'entité Adresse
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
@Embeddable
public class Adresse {
    /**
     * The Numero.
     */
    @Column(name = "numero", nullable = false)
    private Integer numero;
    /**
     * The Rue.
     */
    @Column(name = "rue", nullable = false, length = 50)
    private String rue;
    /**
     * The Code postal.
     */
    @Column(name = "code_postal", nullable = false, length = 10)
    private Integer codePostal;
    /**
     * The Ville.
     */
    @Column(name = "ville", nullable = false, length = 50)
    private String ville;

    /**
     * Instantiates a new Adresse.
     *
     * @param numero     the numero
     * @param rue        the rue
     * @param codePostal the code postal
     * @param ville      the ville
     */
    public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    /**
     * Instantiates a new Adresse.
     */
    public Adresse() {

    }

    /**
     * Gets numero.
     *
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Sets numero.
     *
     * @param numero the numero
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Gets rue.
     *
     * @return the rue
     */
    public String getRue() {
        return rue;
    }

    /**
     * Sets rue.
     *
     * @param rue the rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * Gets code postal.
     *
     * @return the code postal
     */
    public Integer getCodePostal() {
        return codePostal;
    }

    /**
     * Sets code postal.
     *
     * @param codePostal the code postal
     */
    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Gets ville.
     *
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * Sets ville.
     *
     * @param ville the ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }
}