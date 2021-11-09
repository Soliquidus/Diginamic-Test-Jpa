package fr.diginamic.bibliotheque.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Classe qui représente l'entité Emprunt
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 05/11/2021
 */
@Table(name = "EMPRUNT")
@Entity
public class Emprunt {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "DATE_DEBUT", nullable = false)
    private Date dateDebut;

    @Column(name = "DATE_FIN")
    private Date dateFin;

    @Column(name = "DELAI")
    private Integer delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns =@JoinColumn(name = "ID_EMP", referencedColumnName = "ID"))
    private Set<Livre> livres;

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
     * Gets date debut.
     *
     * @return the date debut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * Sets date debut.
     *
     * @param dateDebut the date debut
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Gets date fin.
     *
     * @return the date fin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Sets date fin.
     *
     * @param dateFin the date fin
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Gets delai.
     *
     * @return the delai
     */
    public Integer getDelai() {
        return delai;
    }

    /**
     * Sets delai.
     *
     * @param delai the delai
     */
    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    /**
     * Gets id client.
     *
     * @return the id client
     */
    public Client getIdClient() {
        return client;
    }

    /**
     * Sets id client.
     *
     * @param client the client
     */
    public void setIdClient(Client client) {
        this.client = client;
    }

    /**
     * Gets livres.
     *
     * @return the livres
     */
    public Set<Livre> getLivres() {
        return livres;
    }

    /**
     * Sets livres.
     *
     * @param livres the livres
     */
    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }
}