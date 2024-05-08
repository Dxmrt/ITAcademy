package TascaS1_01.N1.N1.N1exercisi4;

import java.util.ArrayList;
import java.util.List;

public class Redactor {
    private String nombre;
    private String dni;
    protected int sueldo;

    List<Noticia> listaNoticias = new ArrayList<>();

    public void setListaNoticias(List<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    public Redactor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = 1500;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public List<Noticia> getListaNoticias() {
        return listaNoticias;
    }

    @Override
    public String toString() {
        return "Redactor{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", sueldo=" + sueldo +
                ", listaNoticias=" + listaNoticias +
                '}';
    }
}
