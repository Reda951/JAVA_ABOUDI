package fr.ecole;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeviseTest {

    @Test
    public void testAdditionDevises() {
        // On prend deux kichta de dinars
        Devise dinars1 = new Devise(300, "Dinar");
        Devise dinars2 = new Devise(200, "Dinar");

        // Petit check sympa
        System.out.println("Première devise : " + dinars1.getQuantite() + " " + dinars1.getMonnaie());
        System.out.println("Deuxième devise : " + dinars2.getQuantite() + " " + dinars2.getMonnaie());

        // On fait la somme, inshaAllah que ça marche !
        Devise sommeObtenue = dinars1.add(dinars2);

        // Résultat de notre richesse ;)
        System.out.println("Résultat de l'addition : " + sommeObtenue.getQuantite() + " " + sommeObtenue.getMonnaie());

        // Vérification que l'on a bien 500 dinars, comme prévu
        assertEquals(new Devise(500, "Dinar"), sommeObtenue, "Euh, ça devrait être 500 dinars khoya !");
    }

    @Test
    public void testAdditionDevisesDifferentes() {
        // On mélange des Euros et des Dollars (tema la taille de la kichta)
        Devise euros = new Devise(100, "Euro");
        Devise dollars = new Devise(50, "Dollar");

        // Un petit selem aux devises avant l'erreur
        System.out.println("Première devise : " + euros.getQuantite() + " " + euros.getMonnaie());
        System.out.println("Deuxième devise : " + dollars.getQuantite() + " " + dollars.getMonnaie());

        // On teste que l'addition déclenche bien une erreur
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            euros.add(dollars);
        });

        // On vérifie le message d'erreur
        String expectedMessage = "Frérot, les monnaies doivent être les mêmes pour les calculer wsh !";
        String actualMessage = exception.getMessage();
        System.out.println("Message d'erreur attendu : " + actualMessage);

        assertEquals(expectedMessage, actualMessage, "Le message d'erreur est pas ce qu'on espérait !");
    }

    @Test
    public void testEqualsDevise() {
        // On déclare notre kichta en dinars
        System.out.println("Déclarons les kichta : 12 dinars, 14 dinars et 14 dinars mais en dollars !");
        Devise m12Dinar = new Devise(12, "Dinar");
        Devise m14Dinar = new Devise(14, "Dinar");
        Devise m14Dollar = new Devise(14, "Dollar");

        // Tester que m12Dinar est bien égale à lui-même
        System.out.println("On vérifie que 12 dinars est bien égal à lui-même (logique, wsh).");
        assertTrue(m12Dinar.equals(m12Dinar), "12 dinars devrait être égal à lui-même, logique khoya !");

        // Tester que m12Dinar n'est pas égale à m14Dinar
        System.out.println("On vérifie que 12 dinars c'est pas égal à 14 dinars (pas la même thune frère).");
        assertFalse(m12Dinar.equals(m14Dinar), "12 dinars ne devrait pas être égal à 14 dinars, ça sent l'la 3asba.");

        // Tester que m14Dinar n'est pas égale à m14Dollar
        System.out.println("On vérifie que 14 dinars c'est pas égal à 14 dollars (on mélange pas les monnaies khoya).");
        assertFalse(m14Dinar.equals(m14Dollar), "14 dinars ne devrait pas être égal à 14 dollars, si seulement...");
    }
}
