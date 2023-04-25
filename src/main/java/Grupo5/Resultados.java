package Grupo5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resultados {

    private String archivo;

    private List<String> personas;
    private List<String> rondas;
    private List<Pronostico> pronosticos;
    private int puntosPronosticos;
    private int puntosPorPersona;
    private String personaAfiltrar;

    public Resultados(String archivo) {
        this.archivo = archivo;
        this.personas = new ArrayList<>();
        this.rondas = new ArrayList<>();
        this.pronosticos = new ArrayList<>();

    }
    public void ResultadosPronostico(){


        // Obtener la lista de pronósticos del objeto archivoPronostico
        List<Pronostico> pronosticos = archivoPronostico.getPronosticos();

        // Obtener la lista de partidos del objeto archivoPartido
        List<Partido> partidos = archivoPartido.getResultados();
        puntosPronosticos = 0;

        for (int i = 0; i < pronosticos.size() && i < partidos.size(); i++) {
            Pronostico resultadoPronostico = pronosticos.get(i);
            Partido resultadoPartido = partidos.get(i);
            if (resultadoPronostico.calculoPronostico() == resultadoPartido.calculoResultado()) {
                puntosPronosticos++;
            }
        }
    }

    public void LeerPronosticoPersona(){

        List<Pronostico> pronosticos = archivoPronostico.getPronosticos();
        List<Partido> partidos = archivoPartido.getResultados();

        //Ingreso por consola el nombre de la persona y lo filtro
        Scanner scanner = new Scanner(System.in);
        puntosPorPersona=0;
        System.out.printf("Ingrese el nombre de persona para filtrar:");
        String personaFiltrada = scanner.nextLine();
        personaAfiltrar=personaFiltrada;
        for (int i = 0; i < pronosticos.size() && i < partidos.size(); i++) {
            Pronostico resultadoPronostico = pronosticos.get(i);
            Partido resultadoPartido = partidos.get(i);
            if (resultadoPronostico.getPersona().equals(personaFiltrada)) {
                if (resultadoPronostico.calculoPronostico().equals(resultadoPartido.calculoResultado()) ) {
                    puntosPorPersona++;
                }
            }
        }
    }

    public int getPuntosPronostico(){ return puntosPronosticos;}
    public int getPuntosPorPersona(){ return puntosPorPersona;}
    public String getPersonaAfiltrar(){ return personaAfiltrar;}


}
