package TascaS1_01.N1.N1.N1exercisi4;



public abstract class Noticia {

    protected Redactor redactor;
    protected String text = "";
    protected String titular;
    protected int puntuacion;
    protected int precio;

    public Noticia(String titular, Redactor redactor) {
        this.titular = titular;
        this.redactor = redactor;
    }

    public Redactor getRedactor() {
        return redactor;
    }

    public void setRedactor(Redactor redactor) {
        this.redactor = redactor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public abstract void calcularPrecioNoticia();

    public abstract void calcularPuntos();
}