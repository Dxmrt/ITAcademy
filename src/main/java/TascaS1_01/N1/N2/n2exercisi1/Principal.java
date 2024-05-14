package TascaS1_01.N1.N2.n2exercisi1;

public class Principal {
    public static void main(String[] args) {
        Venda venda = new Venda();

        venda.addProducto(new Producto("Producto 1", 10.0));
        venda.addProducto(new Producto("Producto 2", 20.0));
        venda.addProducto(new Producto("Producto 3", 5.0));

        try {
            venda.calcularTotal();
            venda.imprimirVenda();
        } catch (VendaBuidaException e) {
            System.out.println(e.getMessage());
        }
    }
}