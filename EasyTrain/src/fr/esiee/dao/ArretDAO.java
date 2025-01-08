package fr.esiee.dao;

import fr.esiee.modele.Arret;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArretDAO {
    private Connection connection;

    public ArretDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createArret(Arret arret) {
        String query = "INSERT INTO Arret (ville, heure) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, arret.getVille());
            stmt.setTime(2, Time.valueOf(arret.getHeure()));
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    arret.setId(keys.getInt(1)); // Associe l'ID généré
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Arret getArretById(int id) {
        String query = "SELECT * FROM Arret WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Arret(
                        rs.getInt("id"),
                        rs.getString("ville"),
                        rs.getTime("heure").toString()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Arret> findAllArrets() {
        List<Arret> arrets = new ArrayList<>();
        String query = "SELECT * FROM Arret";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
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

    public boolean updateArret(Arret arret) {
        String query = "UPDATE Arret SET ville = ?, heure = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, arret.getVille());
            stmt.setTime(2, Time.valueOf(arret.getHeure()));
            stmt.setInt(3, arret.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteArret(int id) {
        String query = "DELETE FROM Arret WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
