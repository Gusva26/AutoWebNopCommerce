@CarritoCompras
Feature: Busqueda y gestion de productos en el carrito de compras
  Como usuario de la tienda DemoWebShop
  Quiero buscar productos, agregarlos con una cantidad especifica y gestionarlos en el carrito
  Para asegurar que puedo preparar mi compra correctamente

  Background:
    Given el usuario esta en la pagina de inicio

  @AgregarCarrito @HappyPath
  Scenario Outline: Buscar un producto y agregarlo exitosamente al carrito con cantidad especifica
    When busca el producto "<producto>"
    And selecciona el producto "<producto>" de los resultados
    And ingresa la cantidad "<cantidad>" y lo agrega al carrito
    Then deberia ver el mensaje de confirmacion "The product has been added to your shopping cart"
    When ingresa al carrito de compras
    Then el producto "<producto>" deberia aparecer en el carrito con cantidad "<cantidad>"

    Examples:
      | producto         | cantidad |
      | 14.1-inch Laptop | 1        |
      | Health Book      | 2        |

  @EliminarCarrito @HappyPath
  Scenario: Eliminar un producto previamente agregado al carrito
    When busca el producto "Health Book"
    And selecciona el producto "Health Book" de los resultados
    And ingresa la cantidad "1" y lo agrega al carrito
    And ingresa al carrito de compras
    And elimina el producto del carrito
    Then deberia ver el carrito vacio con el mensaje "Your Shopping Cart is empty!"

  @BusquedaSinResultados @UnhappyPath
  Scenario: Buscar un producto inexistente muestra mensaje de sin resultados
    When busca el producto "ProductoInexistenteXYZ123"
    Then deberia ver el mensaje de busqueda sin resultados "No products were found that matched your criteria."