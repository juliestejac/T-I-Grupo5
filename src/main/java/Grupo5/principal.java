package Grupo5;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class principal {
    public static void main (String[] args) throws SQLException{

        String archivoPartidos = args[0];
        // contarnos a la base
        Connection conexionBase = null;
        conexionBase = operacionesConBaseDatos.crearConexion( conexionBase );
        if (conexionBase != null) {
            archivoPartido Partidos = new archivoPartido(archivoPartidos);
            Partidos.LeerArchivoPartido();
            ResultSet listaPronosticos= operacionesConBaseDatos.importarDatos(conexionBase);
            archivoPronostico pronosticos = new archivoPronostico(listaPronosticos);
            pronosticos.LeerArchivoPronostico();

            Resultados.ResultadosPronostico();
        }
    }
}
