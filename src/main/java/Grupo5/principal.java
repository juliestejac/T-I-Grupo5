package Grupo5;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class principal {
    public static void main (String[] args) throws SQLException{

        String archivoPartidos = "partidos.csv";
        // contarnos a la base
        Connection conexionBase = null;
        conexionBase = operacionesConBaseDatos.crearConexion( conexionBase );
        if (conexionBase != null) {
            ArchivoPartido Partidos = new ArchivoPartido(archivoPartidos);
            Partidos.LeerArchivoPartido();
            ResultSet listaPronosticos= operacionesConBaseDatos.importarDatos(conexionBase);
            archivoPronostico pronosticos = new archivoPronostico(listaPronosticos);
            pronosticos.LeerArchivoPronostico();
// modificando algo
            Resultados resultado = new Resultados();
            resultado.calcularAciertos();
            resultado.listarAciertos();
        }
    }
}
