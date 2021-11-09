package fr.diginamic.bibliotheque;

import fr.diginamic.bibliotheque.repository.Functions;

/**
 * Classe pour tester les requêtes en BDD
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 05/11/2021
 */
public class TestBibliotheque {

    public static void main(String[] args) {
        Functions functions = new Functions();
        functions.findEmpruntByClient(1);
    }
}