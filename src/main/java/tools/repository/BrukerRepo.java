package tools.repository;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Resultat;
import models.UserModel;
import tools.DbTool;

public class BrukerRepo {
    /**
     * legger til bruker til databasen.
     * Denne er ikke implementert. Her må dere gjerne prøve å lage en egen servlet som kan kommunisere med
     * denne metoden.
     * @param user bruker objekt som inneholder all informasjon om personen.
     * Tips: Objektet må instansieres i en servlet før man kaller på addUser().
     * @param p printwriter for å skrive ut html i servlet. F.eks SQL feilmeldinger eller annen info.
     */

    public static void addResultat(Resultat test, PrintWriter p) {
        Connection db = null;
        PreparedStatement insertNewResultat = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            String query =
                    "INSERT INTO `Test` (Fornavn, Etternavn, Test1, Test2, Test3) values (?,?,?,?,?)";

            insertNewResultat = db.prepareStatement(query);
            insertNewResultat.setString(1, test.getFornavn());
            insertNewResultat.setString(2, test.getEtternavn());
            insertNewResultat.setString(3, test.getTest1());
            insertNewResultat.setString(4, test.getTest2());
            insertNewResultat.setInt (5, 1);
            insertNewResultat.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     * henter ut spesifikk person fra databasen
     * @param username brukerens epost-addresse ("trym@example.com");
     * @param p printwriter see metoden over.
     * @return et String objekt med eposten til brukeren.
     */

    public static String getUserName(String username, PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        String toReturn = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn(p);
            ResultSet rs = null;
            String query = "SELECT * FROM resultat.test where resultatID = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setString(1, username);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getString("User_Email");
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;

    }
}