package be.vdab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/*
Metadata:
Je kan van een ResultSet het aantal kolommen vragen, per kolom de naam en het type vragen.
*/
public class Vb3_MetadataOverResultSet {
    private static final String URL = "jdbc:mysql://localhost/tuincentrum?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    private static final String SQL_SELECT = "select id, voornaam, indienst from werknemers";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SQL_SELECT)) {
            // De method getMetaData geeft metadata over de ResultSet
            ResultSetMetaData metaData = resultSet.getMetaData();
            // Leest het aantal kolommen in de ResultSet
            for (int index = 1; index <= metaData.getColumnCount(); index++) {
                System.out.println(
                            // Leest de naam van de kolom met een bepaald volgnummer
                            metaData.getColumnName(index) + ' ' +
                            // Leest het type van de kolom met een bepaald volgnummer
                            metaData.getColumnTypeName(index));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
