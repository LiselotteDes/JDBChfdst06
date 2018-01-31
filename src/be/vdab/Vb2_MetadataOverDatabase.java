package be.vdab;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
Voorbeeld: de naam en het versienummer van de database engine ophalen.
*/
public class Vb2_MetadataOverDatabase {
    private static final String URL = "jdbc:mysql://localhost/tuincentrum?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDatabaseProductName() + ' ' +
                                metaData.getDatabaseMajorVersion() + ' ' +
                                metaData.getDatabaseMinorVersion());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
