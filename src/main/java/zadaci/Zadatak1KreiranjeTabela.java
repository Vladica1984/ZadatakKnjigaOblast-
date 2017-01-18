package zadaci;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vladimir on 1/18/2017.
 */
public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;

        try {
            //Potrebno je prvo konektovati se na bazu
            connectionSource=new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            TableUtils.dropTable(connectionSource, Oblast.class, true);
            TableUtils.dropTable(connectionSource, Knjiga.class, true);

            TableUtils.createTable(connectionSource, Knjiga.class);
            TableUtils.createTable(connectionSource, Oblast.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                //Zatvaranje konekcije sa bazom
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

