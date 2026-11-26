# Automatización Web — DemoWebShop

Proyecto de automatización de pruebas funcionales web sobre la tienda [DemoWebShop (Tricentis)](https://demowebshop.tricentis.com/), desarrollado en **Java** aplicando el patrón **Screenplay** con **Serenity BDD** y **Cucumber**.

---

## Tecnologías utilizadas

* **Java 17**
* **Maven** (gestión de dependencias y ejecución)
* **Serenity BDD 4.0.3** (Screenplay + reportes HTML)
* **Cucumber** (BDD / Gherkin)
* **JUnit 4**
* **Selenium WebDriver** (Google Chrome)

---

## Estructura del proyecto

```text
TareitaAutoWeb/
├── pom.xml
├── evidencias/                              # Capturas de pantalla generadas por escenario y paso
└── src/
    ├── main/java/org/example/
    │   ├── Pages/                           # Localizadores (Targets) por pantalla
    │   │   ├── HomePage.java
    │   │   ├── ResultadoBusquedaPage.java
    │   │   ├── DetalleProductoPage.java
    │   │   └── CarritoPage.java
    │   ├── Tasks/                           # Acciones reutilizables del usuario
    │   │   ├── NavigateHome.java
    │   │   ├── BuscarProducto.java
    │   │   ├── SeleccionarProducto.java
    │   │   ├── AñadirProductoCarrito.java
    │   │   ├── AbrirCarrito.java
    │   │   └── RemoverProductoCarrito.java
    │   ├── Questions/                       # Validaciones de estado y mensajes
    │   │   ├── Notificacion.java
    │   │   ├── InformacionCarrito.java
    │   │   └── MensajeResultadoBusqueda.java
    │   └── Utils/                           # Utilidades para capturas y rutas
    │       ├── Parameters.java
    │       └── ScreenShot.java
    └── test/
        ├── java/org/example/
        │   ├── RunnerTest.java              # Runner principal de Cucumber + Serenity
        │   ├── Hooks/
        │   │   └── StageHooks.java          # Configuración de escenario y capturas por paso
        │   └── StepDefinitions/
        │       ├── ParameterDefinition.java # Definición del actor Screenplay
        │       └── CarritoStepDefinitions.java
        └── resources/
            ├── serenity.conf                # Configuración de WebDriver y Serenity
            ├── logback-test.xml             # Configuración de logs en consola
            └── features/
                └── agregar_carrito.feature  # Escenarios en Gherkin
```

---

## Escenarios automatizados

| Tag | Tipo | Descripción |
| :--- | :--- | :--- |
| `@AgregarCarrito` | `@HappyPath` | Busca un producto (`14.1-inch Laptop` y `Health Book`), ingresa una cantidad específica, lo agrega al carrito, valida la notificación de confirmación y verifica nombre y cantidad dentro del carrito. |
| `@EliminarCarrito` | `@HappyPath` | Agrega un producto al carrito, ingresa al carrito, lo elimina y valida el mensaje `"Your Shopping Cart is empty!"`. |
| `@BusquedaSinResultados` | `@UnhappyPath` | Busca un producto inexistente y valida el mensaje `"No products were found that matched your criteria."`. |

---

## Requisitos previos

* **JDK 17** instalado y configurado en `JAVA_HOME`
* **Apache Maven 3.8+**
* **Google Chrome** instalado (el WebDriver se descarga automáticamente)

---

## Cómo ejecutar las pruebas

### Ejecutar todos los escenarios y generar reporte Serenity
```bash
mvn clean verify
```

### Ejecutar un escenario específico por tag
```bash
mvn clean verify -Dcucumber.filter.tags="@AgregarCarrito"
mvn clean verify -Dcucumber.filter.tags="@EliminarCarrito"
mvn clean verify -Dcucumber.filter.tags="@BusquedaSinResultados"
```

### Ejecutar desde IntelliJ IDEA
Abrir `src/test/java/org/example/RunnerTest.java` y ejecutar con **Run 'RunnerTest'**.

---

## Reportes y evidencias

* **Reporte HTML de Serenity BDD**: al finalizar `mvn clean verify`, abrir:
  ```text
  target/site/serenity/index.html
  ```
* **Capturas por paso**: se guardan automáticamente en la carpeta `evidencias/`, organizadas por fecha, hora y nombre del escenario.

---

## 👥 Autor
Luis Gustavo Silva Suárez
