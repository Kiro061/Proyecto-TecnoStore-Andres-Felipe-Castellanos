# TecnoStore — Sistema de Venta de Celulares

## Descripción del proyecto

TecnoStore es un sistema de consola desarrollado en Java para la gestión de ventas de una tienda de celulares. Permite administrar el inventario de celulares, los clientes registrados y el proceso completo de ventas (incluyendo el cálculo automático de IVA y el control de stock), además de generar reportes de negocio.

El proyecto aplica los siguientes conceptos:

- **Programación Orientada a Objetos**: encapsulamiento (setters con validación en los modelos), herencia implícita a través del uso de interfaces del lenguaje, y composición (una `Venta` contiene una lista de `DetalleVenta`).
- **Colecciones**: uso de `List`, `Map` y `Stream API` para listar datos y generar reportes.
- **Manejo de excepciones**: los modelos lanzan `IllegalArgumentException` cuando reciben datos inválidos, y las Vistas las capturan para mostrar mensajes claros sin detener el programa.
- **Persistencia con JDBC**: conexión a MySQL mediante `PreparedStatement`, con manejo de transacciones (`commit`/`rollback`) para el registro de ventas.
- **Patrón de diseño Factory**: `FactoryCelular` centraliza la creación de objetos `Celular`.
- **Arquitectura en capas (MVC)**: separación estricta entre Vista → Controlador → Persistencia.

## Estructura de clases

```
Proyecto-TecnoStore/
│
├── Principal/
│   └── Main.java                  Punto de entrada del programa
│
├── Vista/
│   ├── MenuPrincipal.java         Menú principal del sistema
│   ├── VistaCelular.java          Gestión de celulares (CRUD)
│   ├── VistaCliente.java          Gestión de clientes (CRUD)
│   ├── VistaVenta.java            Registro de ventas
│   └── VistaReportes.java         Menú de reportes
│
├── Controlador/
│   ├── GestorCelulares.java       Reglas de negocio de celulares
│   ├── GestorClientes.java        Reglas de negocio de clientes
│   ├── GestorVentas.java          Reglas de negocio de ventas (stock, IVA)
│   └── GestorReportes.java        Acceso a datos para los reportes
│
├── Modelo/
│   ├── Celular.java               Entidad Celular
│   ├── Cliente.java                Entidad Cliente
│   ├── Venta.java                 Entidad Venta
│   ├── DetalleVenta.java          Entidad DetalleVenta (línea de una venta)
│   └── CategoriaGama.java         Enum: ALTA, MEDIA, BAJA
│
├── Persistencia/
│   ├── ConexionDB.java             Conexión a la base de datos MySQL
│   ├── CelularDAO.java            Acceso a datos de celulares
│   ├── ClienteDAO.java            Acceso a datos de clientes
│   ├── VentaDAO.java              Acceso a datos de ventas (transaccional)
│   └── DetalleVentaDAO.java       Acceso a datos del detalle de venta
│
├── Patrones/
│   └── FactoryCelular.java        Factory para la creación de objetos Celular
│
├── Utilidades/
│   ├── Validador.java             Validación de entradas por consola
│   ├── ReporteUtils.java          Lógica de los reportes (stock bajo, top 3, ventas por mes)
│   └── ArchivoUtils.java          Generación del reporte en archivo .txt
│
└── tecnostore_db.sql              Script de creación de la base de datos
```

### Flujo de capas

```
Vista  →  Controlador (Gestor)  →  Persistencia (DAO)  →  MySQL
```

Ninguna Vista accede directamente a un DAO, y ningún Modelo realiza operaciones de entrada/salida — cada capa tiene una única responsabilidad.

## Indicaciones para conexión MySQL

1. Tener un servidor MySQL corriendo en `localhost:3306`.
2. Ejecutar el script `tecnostore_db.sql` incluido en este repositorio. Esto crea automáticamente la base de datos `Proyecto_TecnoStore` con sus tablas, llaves foráneas y los datos iniciales de `categoria_gama`.
3. Verificar que las credenciales configuradas en `Persistencia/ConexionDB.java` coincidan con tu instalación local:

   ```java
   DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/Proyecto_TecnoStore",
       "root",
       "R00t_MySQL!2026"
   );
   ```

   Si tu usuario o contraseña de MySQL son distintos, ajústalos directamente en este archivo antes de ejecutar el programa.
4. Asegurarse de tener el conector JDBC de MySQL (`mysql-connector-j`) como dependencia del proyecto (ya declarado en `pom.xml`).

## Ejemplo de ejecución

Al ejecutar `Main.java`, se muestra el menú principal:

```
=================================
        TECNOSTORE
=================================
1. Gestión de Celulares
2. Gestión de Clientes
3. Gestión de Ventas
4. Reportes
0. Salir

Seleccione una opción:
```

**Registrar un celular** (opción 1 → 1):

```
=== REGISTRAR CELULAR ===
Marca:
Samsung
Modelo:
Galaxy S23
Precio:
2500000
Stock:
10
Sistema Operativo:
Android

Gama:
1. Alta
2. Media
3. Baja

Seleccione la gama:
1
Celular registrado correctamente.
```

**Registrar una venta** (opción 3 → 1):

```
===== REGISTRAR VENTA =====
Identificación del cliente:
123456789

===== CELULARES DISPONIBLES =====
ID: 1  MARCA: Samsung  MODELO: Galaxy S23  ...

ID del celular:
1
Cantidad:
2

¿Desea agregar otro celular?
1. Sí
2. No
2
Venta registrada correctamente.
Total con IVA: $5950000.0
```

**Generar reporte de ventas** (opción 4 → 4): genera el archivo `reporte_ventas.txt` en la raíz del proyecto con el detalle de todas las ventas registradas.

## Entregables incluidos en este repositorio

- Código fuente completo (`.java`)
- Script SQL de creación de la base de datos (`tecnostore_db.sql`)
- Archivo `reporte_ventas.txt` de ejemplo
- Capturas de ejecución de las funciones principales
- Este README