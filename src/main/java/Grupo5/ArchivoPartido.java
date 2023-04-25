package Grupo5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
    public class ArchivoPartido {
        private static final Pattern SOLO_DIGITOS = Pattern.compile("^\\d+$");
        private static final Pattern SOLO_LETRAS_Y_NUMEROS = Pattern.compile("^[\\w ]+$");
        private static final Pattern SOLO_LETRAS = Pattern.compile("^[a-zA-Z ]+$");
        private String archivo;
        private List<String> rondas;
        private List<Partido> resultados;// agregue para poder leer el archivo Resultados.csv
        public ArchivoPartido(String archivo) {
            this.archivo = archivo;
            this.rondas = new ArrayList<>();
            this.resultados = new ArrayList<>();
        }
        public void LeerArchivoPartido () {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                // Leer encabezado y lo salta
                linea = br.readLine();
                while ((linea = br.readLine()) != null) {
                    String[] campos = linea.split(",");
                    // Validar campos
                    String ronda = campos[0];
                    String equipoLocal = campos[1];
                    String equipoVisitante = campos[2];
                    String golesLocalStr = campos[3];
                    String golesVisitanteStr = campos[4];
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
                    Partido resultado = new Partido( ronda, equipoLocal, equipoVisitante, golesLocal, golesVisitante);
                    resultados.add(resultado);
                    if (!rondas.contains(ronda)) {
                        rondas.add(ronda);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       public List<String> getRondas() {
            return rondas;
        }
       public List<Partido> getResultados() { return resultados; }

    }


