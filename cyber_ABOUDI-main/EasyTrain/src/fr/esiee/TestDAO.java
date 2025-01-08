package fr.esiee;

import fr.esiee.modele.Trajet;
import fr.esiee.modele.Arret;
import fr.esiee.dao.TrajetDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/redaaboudi_easytrain";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            TrajetDAO trajetDAO = new TrajetDAO(connection);

            Trajet trajet = new Trajet("Train", 45, null);
            if (trajetDAO.createTrajet(trajet)) {
                System.out.println("Trajet ajouté : ID = " + trajet.getId());
            }

            Trajet fetchedTrajet = trajetDAO.getTrajetById(trajet.getId());
            if (fetchedTrajet != null) {
                System.out.println("Trajet récupéré : " + fetchedTrajet.getMoyenTransport() + ", Durée : " + fetchedTrajet.getDuree());
            }

            List<Trajet> trajets = trajetDAO.findAllTrajets();
            System.out.println("Liste des trajets :");
            for (Trajet t : trajets) {
                System.out.println("ID : " + t.getId() + ", Moyen : " + t.getMoyenTransport() + ", Durée : " + t.getDuree());
                if (t.getArrets() != null) {
                    System.out.println("Arrêts associés :");
                    for (Arret a : t.getArrets()) {
                        System.out.println("    - " + a.getVille() + " à " + a.getHeure());
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
