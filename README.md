Una empresa WoodShops se dedica a la venta de productos de madera y quiere gestionar el almacén de sus tiendas.

La empresa dispone de una sede central y está compuesta por un conjunto de tiendas de forma que cada tienda tiene su propio almacén, es decir un almacén por tienda.

Los productos se almacenan en las tiendas, de forma que un mismo producto puede existir en varios almacenes, pero no todos los productos tienen porqué existir en todos los almacenes.

De cada producto queremos almacenar el código del producto, la descripción, el proveedor, el precio de venta y el stock, cada tienda o almacén almacena sus productos, por lo tanto, un mismo producto puede tener un stock y un precio de venta distinto en cada tienda.

Hay tres tipos de productos:

Tablero:

De los tableros además queremos saber la altura, la anchura y el tipo de tablero, los tipos de tablero pueden ser, por ejemplo: Aglomerado, Contrachapado, MDF, etc.

Barniz:

Sobre los barnices además debemos almacenar los mililitros y el tipo de color del barniz, como colores pueden ser, por ejemplo: Incoloro, Caoba, Nogal, etc.

 Articulo:

Como artículos se refiere al resto de productos y guardaremos el tipo de articulo de que se trata, que pueden ser, por ejemplo: Estantería, Mesa, Silla, Armario, etc.

 Teniendo en cuenta que cada producto lo suministra un proveedor, de los proveedores queremos almacenar el nif y el nombre, obviamente cada proveedor puede suministrar varios productos.

 Se deben implementar las opciones siguientes:

Añadir nuevos productos en cada tienda
Listar los productos de una tienda con la opción de seleccionar por los tres tipos de producto: tablero, barniz o artículo.
Dado un código de producto, mostrar el stock de cada una de las tiendas en que exista el producto.
