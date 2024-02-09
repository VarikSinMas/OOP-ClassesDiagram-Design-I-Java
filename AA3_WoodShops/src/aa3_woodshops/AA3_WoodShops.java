package aa3_woodshops;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AA3_WoodShops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WoodShop woodShop = new WoodShop("NIF_WoodShop", "WoodShop Tienda Principal");

        Tienda tienda1 = new Tienda("Tienda 1");
        Tienda tienda2 = new Tienda("Tienda 2");
        Tienda tienda3 = new Tienda("Tienda 3");

        woodShop.agregarTienda(tienda1);
        woodShop.agregarTienda(tienda2);
        woodShop.agregarTienda(tienda3);

        int tiendaSeleccionada = -1;

        List<Proveedor> proveedores = new ArrayList<>();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Menú de WoodShops:");
            System.out.println("1. Añadir nuevo producto en una tienda");
            System.out.println("2. Añadir más stock de un producto en una tienda");
            System.out.println("3. Listar productos de una tienda por tipo");
            System.out.println("4. Mostrar stock de un producto en todas las tiendas");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Selecciona una tienda:");
                    for (int i = 0; i < woodShop.getTiendas().size(); i++) {
                        System.out.println((i + 1) + ". " + woodShop.getTiendas().get(i).getNombreTienda());
                    }

                    tiendaSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    if (tiendaSeleccionada >= 1 && tiendaSeleccionada <= woodShop.getTiendas().size()) {
                        System.out.println("Introduce el código del producto:");
                        String codigo = scanner.nextLine();
                        System.out.println("Introduce la descripción del producto:");
                        String descripcion = scanner.nextLine();
                        System.out.println("Introduce el precio de venta del producto:");
                        double precioVenta = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Introduce el stock del producto:");
                        int stock = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Selecciona el tipo de producto:");
                        System.out.println("1. Tablero");
                        System.out.println("2. Barniz");
                        System.out.println("3. Artículo");
                        int tipoProducto = scanner.nextInt();
                        scanner.nextLine();

                        int altura = 0;
                        int anchura = 0;
                        int mililitros = 0;

                        Tablero.TipoTablero tipoTablero = Tablero.TipoTablero.AGLOMERADO;
                        Barniz.TipoColorBarniz tipoColor = Barniz.TipoColorBarniz.INCOLORO;
                        Articulo.TipoArticulo tipoArticulo = Articulo.TipoArticulo.ESTANTERIA;

                        if (tipoProducto == 1) {
                            System.out.println("Introduce la altura del tablero (cm):");
                            altura = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Introduce la anchura del tablero (cm):");
                            anchura = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Selecciona el tipo de tablero:");
                            System.out.println("1. Aglomerado");
                            System.out.println("2. Contrachapado");
                            System.out.println("3. MDF");
                            int tipo = scanner.nextInt();
                            scanner.nextLine();

                            switch (tipo) {
                                case 1:
                                    tipoTablero = Tablero.TipoTablero.AGLOMERADO;
                                    break;
                                case 2:
                                    tipoTablero = Tablero.TipoTablero.CONTRACHAPADO;
                                    break;
                                case 3:
                                    tipoTablero = Tablero.TipoTablero.MDF;
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    continue;
                            }
                        } else if (tipoProducto == 2) {
                            System.out.println("Introduce la cantidad de mililitros del barniz:");
                            mililitros = scanner.nextInt();

                            System.out.println("Selecciona el tipo de color del barniz:");
                            System.out.println("1. Incoloro");
                            System.out.println("2. Caoba");
                            System.out.println("3. Nogal");
                            int tipo = scanner.nextInt();
                            scanner.nextLine();

                            switch (tipo) {
                                case 1:
                                    tipoColor = Barniz.TipoColorBarniz.INCOLORO;
                                    break;
                                case 2:
                                    tipoColor = Barniz.TipoColorBarniz.CAOBA;
                                    break;
                                case 3:
                                    tipoColor = Barniz.TipoColorBarniz.NOGAL;
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    continue;
                            }
                        } else if (tipoProducto == 3) {
                            System.out.println("Selecciona el tipo de artículo:");
                            System.out.println("1. Estantería");
                            System.out.println("2. Mesa");
                            System.out.println("3. Silla");
                            System.out.println("4. Armario");
                            int tipo = scanner.nextInt();
                            scanner.nextLine();

                            switch (tipo) {
                                case 1:
                                    tipoArticulo = Articulo.TipoArticulo.ESTANTERIA;
                                    break;
                                case 2:
                                    tipoArticulo = Articulo.TipoArticulo.MESA;
                                    break;
                                case 3:
                                    tipoArticulo = Articulo.TipoArticulo.SILLA;
                                    break;
                                case 4:
                                    tipoArticulo = Articulo.TipoArticulo.ARMARIO;
                                    break;
                                default:
                                    System.out.println("Opción no válida");
                                    continue;
                            }
                        } else {
                            System.out.println("Opción no válida");
                            continue;
                        }

                        System.out.println("Introduce el NIF del proveedor:");
                        String nifProveedor = scanner.nextLine();
                        System.out.println("Introduce el nombre del proveedor:");
                        String nombreProveedor = scanner.nextLine();

                        Proveedor proveedor = new Proveedor(nifProveedor, nombreProveedor);

                        proveedores.add(proveedor);

                        Producto nuevoProducto;

                        if (tipoProducto == 1) {
                            nuevoProducto = new Tablero(codigo, descripcion, proveedor, precioVenta, stock, altura, anchura, tipoTablero);
                        } else if (tipoProducto == 2) {
                            nuevoProducto = new Barniz(codigo, descripcion, proveedor, precioVenta, stock, mililitros, tipoColor);
                        } else {
                            nuevoProducto = new Articulo(codigo, descripcion, proveedor, precioVenta, stock, tipoArticulo);
                        }

                        woodShop.getTiendas().get(tiendaSeleccionada - 1).agregarProducto(nuevoProducto);
                        System.out.println("El producto se ha añadido con exito!");
                    } else {
                        System.out.println("Tienda seleccionada no válida.");
                    }
                    break;

                case 2:
                    System.out.println("Selecciona una tienda:");
                    for (int i = 0; i < woodShop.getTiendas().size(); i++) {
                        System.out.println((i + 1) + ". " + woodShop.getTiendas().get(i).getNombreTienda());
                    }

                    int tiendaSeleccionadaAddStock = scanner.nextInt();
                    scanner.nextLine();

                    if (tiendaSeleccionadaAddStock >= 1 && tiendaSeleccionadaAddStock <= woodShop.getTiendas().size()) {
                        System.out.println("Selecciona el tipo de producto:");
                        System.out.println("1. Tablero");
                        System.out.println("2. Barniz");
                        System.out.println("3. Artículo");
                        int tipoProductoAddStock = scanner.nextInt();
                        scanner.nextLine();

                        String tipoProductoAddStockStr = "";
                        if (tipoProductoAddStock == 1) {
                            tipoProductoAddStockStr = "Tablero";
                        } else if (tipoProductoAddStock == 2) {
                            tipoProductoAddStockStr = "Barniz";
                        } else if (tipoProductoAddStock == 3) {
                            tipoProductoAddStockStr = "Artículo";
                        } else {
                            System.out.println("Opción no válida");
                            continue;
                        }

                        List<Producto> productosFiltradosAddStock = woodShop.getTiendas().get(tiendaSeleccionadaAddStock - 1).listarProductosPorTipo(tipoProductoAddStockStr);

                        if (productosFiltradosAddStock.isEmpty()) {
                            System.out.println("No hay productos de tipo " + tipoProductoAddStockStr + " en " + woodShop.getTiendas().get(tiendaSeleccionadaAddStock - 1).getNombreTienda());
                        } else {
                            System.out.println("Productos de tipo " + tipoProductoAddStockStr + " en " + woodShop.getTiendas().get(tiendaSeleccionadaAddStock - 1).getNombreTienda() + ":");

                            for (int i = 0; i < productosFiltradosAddStock.size(); i++) {
                                Producto producto = productosFiltradosAddStock.get(i);
                                System.out.println((i + 1) + ". " + producto.getCodigo() + ": " + producto.getDescripcion() + " (Stock actual = " + producto.getStock() + ")");
                            }

                            System.out.println("Selecciona el producto al que deseas añadir más stock:");
                            int seleccionProducto = scanner.nextInt();
                            scanner.nextLine();

                            if (seleccionProducto >= 1 && seleccionProducto <= productosFiltradosAddStock.size()) {
                                Producto productoSeleccionado = productosFiltradosAddStock.get(seleccionProducto - 1);

                                System.out.println("Introduce el número de unidades del producto que deseas añadir:");
                                int unidadesAAdd = scanner.nextInt();
                                scanner.nextLine();

                                productoSeleccionado.addStock(unidadesAAdd);

                                System.out.println("Stock actualizado con éxito. Nuevo stock de " + productoSeleccionado.getCodigo() + ": " + productoSeleccionado.getStock());
                            } else {
                                System.out.println("Selección de producto no válida.");
                            }
                        }
                    } else {
                        System.out.println("Tienda seleccionada no válida.");
                    }
                    break;


                case 3:
                    if (tiendaSeleccionada == -1) {
                        System.out.println("Debes seleccionar una tienda primero.");
                    } else {
                        System.out.println("Selecciona una tienda:");
                        for (int i = 0; i < woodShop.getTiendas().size(); i++) {
                            System.out.println((i + 1) + ". " + woodShop.getTiendas().get(i).getNombreTienda());
                        }

                        int tiendaElegida = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        if (tiendaElegida >= 1 && tiendaElegida <= woodShop.getTiendas().size()) {
                            System.out.println("Selecciona el tipo de producto:");
                            System.out.println("1. Tablero");
                            System.out.println("2. Barniz");
                            System.out.println("3. Artículo");
                            int tipoProductoListar = scanner.nextInt();
                            scanner.nextLine();

                            String tipoProductoListarStr = "";
                            if (tipoProductoListar == 1) {
                                tipoProductoListarStr = "Tablero";
                            } else if (tipoProductoListar == 2) {
                                tipoProductoListarStr = "Barniz";
                            } else if (tipoProductoListar == 3) {
                                tipoProductoListarStr = "Artículo";
                            } else {
                                System.out.println("Opción no válida");
                                continue;
                            }

                            List<Producto> productosFiltrados = woodShop.getTiendas().get(tiendaElegida - 1).listarProductosPorTipo(tipoProductoListarStr);

                            if (productosFiltrados.isEmpty()) {
                                System.out.println("No hay productos de tipo " + tipoProductoListarStr + " en " + woodShop.getTiendas().get(tiendaElegida - 1).getNombreTienda());
                            } else {
                                System.out.println("Productos de tipo " + tipoProductoListarStr + " en " + woodShop.getTiendas().get(tiendaElegida - 1).getNombreTienda() + ":");

                                for (Producto producto : productosFiltrados) {
                                    System.out.println("Código: " + producto.getCodigo());
                                    System.out.println("Descripción: " + producto.getDescripcion());
                                    System.out.println("Proveedor: " + producto.getProveedor().getNombre());
                                    System.out.println("NIF del Proveedor: " + producto.getProveedor().getNif());

                                    if (producto instanceof Tablero) {
                                        Tablero tablero = (Tablero) producto;
                                        System.out.println("Altura: " + tablero.getAltura());
                                        System.out.println("Anchura: " + tablero.getAnchura());
                                        System.out.println("Tipo de Tablero: " + tablero.getTipoTablero());
                                    } else if (producto instanceof Barniz) {
                                        Barniz barniz = (Barniz) producto;
                                        System.out.println("Mililitros: " + barniz.getMililitros());
                                        System.out.println("Tipo de Color: " + barniz.getTipoColor());
                                    } else if (producto instanceof Articulo) {
                                        Articulo articulo = (Articulo) producto;
                                        System.out.println("Tipo de Artículo: " + articulo.getTipoArticulo());
                                    }

                                    System.out.println("Stock: " + producto.getStock());
                                    System.out.println("Precio de Venta: " + producto.getPrecioVenta());
                                    System.out.println("------------------------------------------");
                                }
                            }
                        } else {
                            System.out.println("Tienda seleccionada no válida.");
                        }
                    }
                    break;




                case 4:
                    if (tiendaSeleccionada == -1) {
                        System.out.println("Debes seleccionar una tienda primero.");
                    } else {
                        System.out.println("Introduce el código del producto:");
                        String codigoProducto = scanner.nextLine();

                        System.out.println("Stock del producto " + codigoProducto + " en todas las tiendas:");

                        for (Tienda tienda : woodShop.getTiendas()) {
                            int stockProducto = tienda.obtenerStockProducto(codigoProducto);
                            System.out.println(tienda.getNombreTienda() + ": " + stockProducto);
                        }
                    }
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        System.out.println("Gracias por utilizar WoodShops.");
    }
}
