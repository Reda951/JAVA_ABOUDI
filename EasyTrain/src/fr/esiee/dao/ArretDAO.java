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

    public boolean arretExiste(String ville) {
        String query = "SELECT COUNT(*) FROM Arret WHERE ville = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, ville);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createArret(Arret arret) {
        if (arretExiste(arret.getVille())) {
            System.out.println("Erreur : L'arrêt existe déjà !");
            return false;
        }
        String query = "INSERT INTO Arret (ville, heure, typeArret) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, arret.getVille());
            stmt.setTime(2, Time.valueOf(arret.getHeure()));
            stmt.setString(3, arret.getTypeArret()); // on recupere typeArret
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    arret.setId(keys.getInt(1));
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
                        rs.getTime("heure").toString(),
                        rs.getString("typeArret")
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
                        rs.getTime("heure").toString(),
                        rs.getString("typeArret")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrets;
    }

    public boolean updateArret(Arret arret) {
        String query = "UPDATE Arret SET ville = ?, heure = ?, typeArret = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, arret.getVille());
            stmt.setTime(2, Time.valueOf(arret.getHeure()));
            stmt.setString(3, arret.getTypeArret());
            stmt.setInt(4, arret.getId());
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
