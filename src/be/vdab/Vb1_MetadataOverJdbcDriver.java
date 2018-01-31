package be.vdab;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
Metadata zijn data die eigenschappen van andere data beschrijven.
Je kan bij JDBC metadata opvragen over de JDBC driver, de database of een ResultSet.
Voorbeeld: de naam en het versienummer van de JDBC driver ophalen.
*/
public class Vb1_MetadataOverJdbcDriver {
    private static final String URL = "jdbc:mysql://localhost/tuincentrum?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // De method getMetaData geeft metadata over de JDBC driver en over de database;
            DatabaseMetaData metaData = connection.getMetaData();
            // Leest de naam en de versienummers van de JDBC driver
            System.out.println(metaData.getDriverName() + ' ' +
                                metaData.getDriverMajorVersion() + ' ' +
                                metaData.getDriverMinorVersion());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
