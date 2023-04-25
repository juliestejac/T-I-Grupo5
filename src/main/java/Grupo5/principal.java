package Grupo5;
import java.sql.Connection;

public class principal {
    public static void main (String[] args){

        String archivoPartidos = args[0];
        // contarnos a la base
        Connection conexionBase = null;
        Connection conexionBase = operacionesConBaseDatos.crearConexion( conexionBase );
        if (conexionBase != null) {
            ArchivoPartido Partidos = new ArchivoPartido(archivoPartidos);
            Partidos.LeerArchivoPartido();
            importarPronosticos (conexionBase);
            calcularResultados();
        }
    }
}
