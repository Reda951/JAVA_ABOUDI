package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/redaaboudi_easytrain";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String insertSQL = "INSERT INTO Arret (ville, heure) VALUES ('Alger', '10:00:00')";
            int rowsInserted = statement.executeUpdate(insertSQL);
            System.out.println("Insertion réussie : " + rowsInserted + " ligne(s) insérée(s).");

            String updateSQL = "UPDATE Arret SET heure = '11:00:00' WHERE ville = 'Alger'";
            int rowsUpdated = statement.executeUpdate(updateSQL);
            System.out.println("Mise à jour réussie : " + rowsUpdated + " ligne(s) mise(s) à jour.");

            String selectSQL = "SELECT * FROM Arret WHERE id = 1";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            if (resultSet.next()) {
                System.out.println("Ville : " + resultSet.getString("ville"));
                System.out.println("Heure : " + resultSet.getString("heure"));
            } else {
                System.out.println("Aucun résultat trouvé.");
            }

            String selectAllSQL = "SELECT * FROM Arret";
            ResultSet resultSetAll = statement.executeQuery(selectAllSQL);
            while (resultSetAll.next()) {
                System.out.println("ID : " + resultSetAll.getInt("id"));
                System.out.println("Ville : " + resultSetAll.getString("ville"));
                System.out.println("Heure : " + resultSetAll.getString("heure"));
                System.out.println("-----------");
            }

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote JDBC introuvable : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
}
