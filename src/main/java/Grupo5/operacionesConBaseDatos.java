package Grupo5;
import java.sql.*;

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

    public static ResultSet importarDatos(Connection conexionBase) throws SQLException {
        String consulta = "select * from pronostico";
        Statement sentencia = conexionBase.createStatement();
        sentencia.execute(consulta);
        ResultSet contenedorResultado = sentencia.getResultSet();

  /*      while (contenedorResultado.next()){
            fila++;
            int id = contenedorResultado.getInt("id") ;
            String ronda = contenedorResultado.getString("ronda") ;
            String local = contenedorResultado.getString("equipolocal") ;
            String visitante = contenedorResultado.getString("equipovisitante") ;
            int golesLocal = contenedorResultado.getInt("goleslocal") ;
            int golesVisitante = contenedorResultado.getInt("golesVisitante") ;
            System.out.println("\t"+id+"-"+ronda+"\t"+local+"\t"+visitante+"\t"+golesLocal+"\t"+golesVisitante);
        }
*/        return contenedorResultado;

    }

}
