package aa3_woodshops;
import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private List<Producto> almacen = new ArrayList<>();

    public Tienda(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProducto(Producto producto) {
        almacen.add(producto);
    }

    public List<Producto> listarProductosPorTipo(String tipo) {
        List<Producto> productosPorTipo = new ArrayList<>();

        for (Producto producto : this.almacen) {
            if (producto instanceof Tablero && tipo.equals("Tablero")) {
                productosPorTipo.add(producto);
            } else if (producto instanceof Barniz && tipo.equals("Barniz")) {
                productosPorTipo.add(producto);
            } else if (producto instanceof Articulo && tipo.equals("Artículo")) {
                productosPorTipo.add(producto);
            }
        }

        return productosPorTipo;
    }




    public int obtenerStockProducto(String codigo) {
        int stockTotal = 0;
        for (Producto producto : almacen) {
            if (producto.getCodigo().equals(codigo)) {
                stockTotal += producto.getStock();
            }
        }
        return stockTotal;
    }

    public String getNombreTienda() {
        return this.nombre;
    }


    // Otros métodos relacionados con la tienda según sea necesario
}

