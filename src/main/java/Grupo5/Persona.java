package Grupo5;

public class Persona {

    private String nombre;
    private int aciertos;
    private int apuestas;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.aciertos = 0;
        this.apuestas = 0;
    }
    public void sumaApuestas(){
        apuestas++;
    }
    public void sumaAciertos(){
        aciertos++;
    }
    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getApuestas() {
        return apuestas;
    }

}
