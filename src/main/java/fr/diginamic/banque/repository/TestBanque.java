package fr.diginamic.banque.repository;

import fr.diginamic.banque.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Class TestBanque
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
public class TestBanque {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
    private static final EntityManager em = emf.createEntityManager();

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBanque.class);
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(1987, 1, 30);
        LocalDate dateFin = LocalDate.of(2025, 4, 25);
        LocalDateTime dateVirement = LocalDateTime.of(2021, 10, 12, 15, 30, 27);
        Adresse adresse = new Adresse(1, "Place du Test", 44110, "Nantes");
        ClientBanque client = new ClientBanque("Pfeifer", "Tibo", localDate, adresse);
        Banque banque = new Banque("Crédit Mutuel");
        Operation virement = new Virement(dateVirement, 50.0, "Sortie Bar", "Tibo");
        LivretA livretA = new LivretA("FRXX XXXX XXXX XXXX XXX", 1500.57, 10.0);
        AssuranceVie assuranceVie = new AssuranceVie("FRXX XXXX XXXX XXXX XXX", 24532.65, dateFin, 2.4);
        Operation operation = new Operation(dateVirement, 40.0, "Remboursement Bar");
        em.getTransaction().begin();
        em.persist(banque);
        em.persist(virement);
        em.persist(livretA);
        em.persist(client);
        em.persist(assuranceVie);
        Set<Operation> operations = new HashSet<>();
        Set<Operation> virements = new HashSet<>();
        operation.setCompte(livretA);
        virement.setCompte(assuranceVie);
        virements.add(virement);
        operations.add(operation);
        livretA.setOperations(operations);
        assuranceVie.setOperations(virements);
        em.getTransaction().commit();
        em.close();
        emf.close();
        LOGGER.info("Client créé.");
    }
}