package Grupo5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class archivoPronostico {
    private static final Pattern SOLO_DIGITOS = Pattern.compile("^\\d+$");
    private static final Pattern SOLO_LETRAS_Y_NUMEROS = Pattern.compile("^[\\w ]+$");
    private static final Pattern SOLO_LETRAS = Pattern.compile("^[a-zA-Z ]+$");
    private String archivo;
    private List<String> personas;
    private List<String> rondas;
    private List<Pronostico> pronosticos;
   // private List<Partido> resultados;// agregue para poder leer el archivo Resultados.csv
    public archivoPronostico(String archivo) {
        this.archivo = archivo;
        this.personas = new ArrayList<>();
        this.rondas = new ArrayList<>();
        this.pronosticos = new ArrayList<>();
     //   this.resultados = new ArrayList<>();
    }
    public void LeerArchivoPronostico(Connection conexionBase) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            // Leer encabezado y lo salta
            linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");

                // Validar campos
                String persona = campos[0];
                String ronda = campos[1];
                String equipoLocal = campos[2];
                String equipoVisitante = campos[3];
                String golesLocalStr = campos[4];
                String golesVisitanteStr = campos[5];

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
                if (!SOLO_DIGITOS.matcher(golesLocalStr).matches()) {
                    continue;
                }
                int golesLocal = Integer.parseInt(golesLocalStr);
                if (!SOLO_DIGITOS.matcher(golesVisitanteStr).matches()) {
                    continue;
                }
                int golesVisitante = Integer.parseInt(golesVisitanteStr);
                // Crear objeto Pronostico y agregar a la lista
                Pronostico pronostico = new Pronostico(persona, ronda, equipoLocal, equipoVisitante, golesLocal, golesVisitante);
                pronosticos.add(pronostico);
                // Agregar persona y ronda a las listas si no existen
                if (!personas.contains(persona)) {
                    personas.add(persona);
                }
                if (!rondas.contains(ronda)) {
                    rondas.add(ronda);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> getPersonas() {
        return personas;
    }
    public List<String> getRondas() {
        return rondas;
    }
    public List<Pronostico> getPronosticos() { return pronosticos; }
  //  public List<Partido> getResultados() { return resultados; }
}



