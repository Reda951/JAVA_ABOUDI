package fr.esiee;

import fr.esiee.modele.Arret;
import fr.esiee.modele.Trajet;
import fr.esiee.dao.TrajetDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/redaaboudi_easytrain";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            TrajetDAO trajetDAO = new TrajetDAO(connection);

            // Test : récupération de tous les trajets
            List<Trajet> trajets = trajetDAO.findAllTrajets();
            System.out.println("Liste des trajets :");

            for (Trajet t : trajets) {
                System.out.println("ID : " + t.getId() + ", Moyen : " + t.getMoyenTransport() + ", Durée : " + t.getDuree());
                System.out.println("Arrêts associés :");
                if (t.getArrets() != null) {
                    for (Arret a : t.getArrets()) {
                        System.out.println("    - " + a.getVille() + " à " + a.getHeure());
                    }
                } else {
                    System.out.println("    Aucun arrêt associé.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
