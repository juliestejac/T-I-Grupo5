package Grupo5;
public class Pronostico {
    private String persona;
    private String ronda;
    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private int empate;

    public Pronostico(String persona, String ronda, String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante, int empate) {
        this.persona = persona;
        this.ronda = ronda;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.empate = empate;
    }

    public int calculoNumeroPronostico() {
        if (golesLocal == golesVisitante) {
            return 0; // empate
        } else if (golesLocal > golesVisitante) {
            return 1; // equipo local gana
        } else {
            return 2; // equipo visitante gana
        }
    }
    public String calculoPronostico() {
        if (golesLocal == golesVisitante) {
            return "Empate"; // empate
        } else if (golesLocal > golesVisitante) {
            return "Gano Local"; // equipo local gana
        } else {
            return "Gano Visitante"; // equipo visitante gana
        }
    }

    public String getPersona() {
        return persona;
    }
    public String getRonda() {
        return ronda;
    }
    public String getEquipoLocal() {
        return equipoLocal;
    }
    public String getEquipoVisitante() {
        return equipoVisitante;
    }
    public int getGolesLocal(){ return golesLocal;}
    public int getGolesVisitante(){ return golesVisitante;}

    @Override
    public String toString() {
        return "Pronostico{" +
                "persona='" + persona + '\'' +
                ", ronda='" + ronda + '\'' +
                ", equipoLocal='" + equipoLocal + '\'' +
                ", equipoVisitante='" + equipoVisitante + '\'' +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", empate=" + empate +
                '}';
    }
}
