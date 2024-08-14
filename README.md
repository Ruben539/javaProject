# innova_facturas_back

## Cargar las tablas de la base de datos

# Crear la tabla en la base de datos con el nombre innovafacturas

Verificar en el archivo `resources/liquibase.properties` que la base de datos se llame igual que en la BD

`url=jdbc:mysql://localhost:3306/innovafacturas`

# Luego ejecutar el comando para cargar las tablas dentro de la BD

Ejecutar el comando `mvn liquibase:update`
