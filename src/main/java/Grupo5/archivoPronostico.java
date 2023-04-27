package Grupo5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class archivoPronostico {
    private static final Pattern SOLO_DIGITOS = Pattern.compile("^\\d+$");
    private static final Pattern SOLO_LETRAS_Y_NUMEROS = Pattern.compile("^[\\w ]+$");
    private static final Pattern SOLO_LETRAS = Pattern.compile("^[a-zA-Z ]+$");
    private ResultSet archivo;
    private List<String> personas;
    private List<String> rondas;
    private static List<Pronostico> pronosticos;
   // private List<Partido> resultados;// agregue para poder leer el archivo Resultados.csv
    public archivoPronostico(ResultSet archivo) {
        this.archivo = archivo;
        this.personas = new ArrayList<>();
        this.rondas = new ArrayList<>();
        this.pronosticos = new ArrayList<>();
     //   this.resultados = new ArrayList<>();
    }
    public void LeerArchivoPronostico() throws SQLException {
            while (archivo.next()){
                // tomar los campos
                String persona = archivo.getString("persona");
                String ronda = archivo.getString("ronda");
                String equipoLocal = archivo.getString("equipolocal");
                String equipoVisitante = archivo.getString("equipovisitante");
                int golesLocal = archivo.getInt("ganalocal");
                int golesVisitante = archivo.getInt("ganavisitante");
                int empate = archivo.getInt("empate");
                // Validar campos
                if (!SOLO_LETRAS.matcher(persona).matches()) {
                    continue;
                }
                if (!SOLO_LETRAS.matcher(equipoLocal).matches()) {
                    continue;
                }
                if (!SOLO_LETRAS.matcher(equipoVisitante).matches()) {
                    continue;
                }
                if (!SOLO_LETRAS_Y_NUMEROS.matcher(ronda).matches()) {
                    continue;
                }
                // Crear objeto Pronostico y agregar a la lista
                Pronostico prono = new Pronostico(persona, ronda, equipoLocal, equipoVisitante, golesLocal, golesVisitante,empate);
                pronosticos.add(prono);
                // Agregar persona y ronda a las listas si no existen
                if (!personas.contains(persona)) {
                    personas.add(persona);
                }
                if (!rondas.contains(ronda)) {
                    rondas.add(ronda);
                }
            }
    }
    public List<String> getPersonas() {
        return personas;
    }
    public List<String> getRondas() {
        return rondas;
    }
    public static List<Pronostico> getPronosticos() { return pronosticos; }
    /* public List<Partido> getResultados() { return resultados; } */
}



