package fr.esiee.dao;

import fr.esiee.modele.Trajet;
import fr.esiee.modele.Arret;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrajetDAO {
    private Connection connection;

    public TrajetDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createTrajet(Trajet trajet) {
        String query = "INSERT INTO Trajet (moyen_transport, duree) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, trajet.getMoyenTransport());
            stmt.setInt(2, trajet.getDuree());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    trajet.setId(keys.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Trajet getTrajetById(int id) {
        String query = "SELECT * FROM Trajet WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                List<Arret> arrets = findArretsByTrajetId(id); // Récupère les arrêts associés
                return new Trajet(
                        rs.getInt("id"),
                        rs.getString("moyen_transport"),
                        rs.getInt("duree"),
                        arrets
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Arret> findArretsByTrajetId(int trajetId) {
        List<Arret> arrets = new ArrayList<>();
        String query = "SELECT a.id, a.ville, a.heure FROM Trajet_Arret ta JOIN Arret a ON ta.arret_id = a.id WHERE ta.trajet_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, trajetId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                arrets.add(new Arret(
                        rs.getInt("id"),
                        rs.getString("ville"),
                        rs.getTime("heure").toString()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrets;
    }


    public List<Trajet> findAllTrajets() {
        List<Trajet> trajets = new ArrayList<>();
        String query = "SELECT * FROM Trajet";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                List<Arret> arrets = findArretsByTrajetId(rs.getInt("id")); // Récupère les arrêts pour chaque trajet
                trajets.add(new Trajet(
                        rs.getInt("id"),
                        rs.getString("moyen_transport"),
                        rs.getInt("duree"),
                        arrets
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trajets;
    }


    public boolean updateTrajet(Trajet trajet) {
        String query = "UPDATE Trajet SET moyen_transport = ?, duree = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, trajet.getMoyenTransport());
            stmt.setInt(2, trajet.getDuree());
            stmt.setInt(3, trajet.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTrajet(int id) {
        String query = "DELETE FROM Trajet WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
