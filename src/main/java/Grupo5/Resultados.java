package Grupo5;
import java.util.ArrayList;
import java.util.List;

public class Resultados {
    private List<Persona> personas;
    //private List<Pronostico> pronosticos;

    public Resultados() {
        this.personas = new ArrayList<>();
    //    this.pronosticos = new ArrayList<>();
    }
/*    public static void ResultadosPronostico(){


        // Obtener la lista de pronósticos del objeto archivoPronostico
        List<Pronostico> pronosticos = archivoPronostico.getPronosticos();

        // Obtener la lista de partidos del objeto archivoPartido
        List<Partido> partidos = ArchivoPartido.getResultados();

        for (int i = 0; i < pronosticos.size() && i < partidos.size(); i++) {
            Pronostico resultadoPronostico = pronosticos.get(i);
            Partido resultadoPartido = partidos.get(i);
            if (resultadoPronostico.calculoPronostico().equals(resultadoPartido.calculoResultado())) {
                puntosPronosticos++;
            }
        }
    }*/

/*    public void LeerPronosticoPersona(){

        List<Pronostico> pronosticos = archivoPronostico.getPronosticos();
        List<Partido> partidos = ArchivoPartido.getResultados();

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
    }*/
    public void listarAciertos(){
        for (Persona cada: personas) {
            System.out.println(cada.getNombre()+" hizo "+cada.getApuestas()+" pronosticos y obtuvo "+cada.getAciertos()+" aciertos.");
        }
    }
    public void calcularAciertos (){
        List<Pronostico> pronosticos = archivoPronostico.getPronosticos();
        List<Partido> partidos = ArchivoPartido.getResultados();
        //List<Persona> personas = new ArrayList<>();

        //primero creo la lista de personas que apostaron
        for (Pronostico cadaRegistro: pronosticos) {
            String nombre = cadaRegistro.getPersona();
            boolean hay=false;
            for (Persona sujeto: personas) {
                if (sujeto.getNombre().equals(nombre))
                    hay=true;
            }
            if (!hay){
                Persona nuevo = new Persona(nombre);
                personas.add(nuevo);
            }
        }
        for (Persona perso: personas) {
            for (Pronostico apuesta: pronosticos) {
                if (perso.getNombre().equals(apuesta.getPersona())){
                    //comparar el pronostico con el partido
                    for (Partido jugado: partidos) {
                        if (jugado.getEquipoLocal().equals(apuesta.getEquipoLocal()) && jugado.getEquipoVisitante().equals(apuesta.getEquipoVisitante())){
                            perso.sumaApuestas();
                            if (jugado.calculoNumeroResultado()==apuesta.calculoNumeroPronostico()){
                                perso.sumaAciertos();
                            }
                        }
                    }
                }
            }
        }

    }

}
