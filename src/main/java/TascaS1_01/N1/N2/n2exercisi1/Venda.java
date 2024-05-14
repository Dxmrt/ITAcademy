package TascaS1_01.N1.N2.n2exercisi1;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<Producto> productos;
    private double total;

    public Venda() {
        this.productos = new ArrayList<>();
    }

    public void addProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void calcularTotal() throws VendaBuidaException {
        if (productos.isEmpty()) {
            throw new VendaBuidaException("Para crear una venda primero debes añadir los productos");
        }
        double sum = 0;
        for (Producto producto : this.productos) {
            sum += producto.getPrecio();
        }
        this.total = sum;
    }

    public void imprimirVenda() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la venda.");
        } else {
            System.out.println("Productos en la venda:");
            for (Producto producte : productos) {
                System.out.println(producte.getNombre() + " - " + producte.getPrecio() + "€");
            }
            System.out.println("Total: " + total + "€");
        }
    }
}