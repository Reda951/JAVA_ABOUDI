package fr.esiee.dao;

import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {
    private Connection connection;

    public UtilisateurDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean createUtilisateur(Utilisateur utilisateur) {
        String query = "INSERT INTO Utilisateur (nom, prenom, email, mot_de_passe, telephone, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMotDePasse());
            stmt.setString(5, utilisateur.getTelephone());
            stmt.setString(6, utilisateur.getRole().name());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    utilisateur.setId(keys.getInt(1)); // Corrigé pour définir l'ID
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Utilisateur getUtilisateurById(int id) {
        String query = "SELECT * FROM Utilisateur WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        rs.getString("telephone"),
                        Role.valueOf(rs.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Utilisateur> findAllUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT * FROM Utilisateur";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                utilisateurs.add(new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        rs.getString("telephone"),
                        Role.valueOf(rs.getString("role"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

    public boolean updateUtilisateur(Utilisateur utilisateur) {
        String query = "UPDATE Utilisateur SET nom = ?, prenom = ?, email = ?, mot_de_passe = ?, telephone = ?, role = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMotDePasse());
            stmt.setString(5, utilisateur.getTelephone());
            stmt.setString(6, utilisateur.getRole().name());
            stmt.setInt(7, utilisateur.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUtilisateur(int id) {
        String query = "DELETE FROM Utilisateur WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
