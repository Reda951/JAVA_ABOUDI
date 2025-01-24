package fr.esiee;

import fr.esiee.dao.ArretDAO;
import fr.esiee.modele.Arret;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8889/redaaboudi_easytrain";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            ArretDAO arretDAO = new ArretDAO(connection);

            // Test d'ajout d'un arret pour Béjaïa à 12:00:00 de type "terminus"
            Arret arret = new Arret("Bejaia", "12:00:00", "terminus");

            if (arretDAO.createArret(arret)) {
                System.out.println("Arrêt ajouté avec succès !");
                arret.afficherInformations();
            } else {
                System.out.println("Échec de l'ajout de l'arrêt. Il existe déjà.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
