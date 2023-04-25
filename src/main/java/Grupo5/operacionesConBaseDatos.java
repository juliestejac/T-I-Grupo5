package Grupo5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class operacionesConBaseDatos {
    public static Connection crearConexion(Connection conexionBase) {

        try {
            // db parameters
            //           Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            String tipoyUbicacionBase = "jdbc:sqlite:g5ti.db";
            // create a connection to the database
            if (conexionBase != null){
                conexionBase = DriverManager.getConnection(tipoyUbicacionBase);
            }
            //System.out.println("Conection a SQLite ha sido establecida.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return conexionBase;
    }

    public static void procesarDatos(Connection conexionBase) throws SQLException {
        String consulta = "select * from equipos";
        Statement sentencia = conexionBase.createStatement();
        sentencia.execute("select * from equipos");
        ResultSet contenedorResultado = sentencia.getResultSet();
        int fila=0;
        while (contenedorResultado.next()){
            fila++;
            int id = contenedorResultado.getInt("id") ;
            String ronda = contenedorResultado.getString("ronda") ;
            String local = contenedorResultado.getString("equipolocal") ;
            String visitante = contenedorResultado.getString("equipovisitante") ;
            int golesLocal = contenedorResultado.getInt("goleslocal") ;
            int golesVisitante = contenedorResultado.getInt("golesVisitante") ;
            System.out.println("\t"+id+"-"+ronda+"\t"+local+"\t"+visitante+"\t"+golesLocal+"\t"+golesVisitante);
        }
        System.out.println("Cantidad de filas procesadas: "+fila);
    }

}
