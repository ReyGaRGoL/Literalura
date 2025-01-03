# 📚 **Literalura**
*Aplicación de Consola para Gestión de Libros y Autores*
Hola, esta es una aplicación sencilla que hice como parte de los desafíos de los cursos de Java en Alura Latam y Oracle. La idea era practicar conceptos importantes de backend y también aprender a consumir APIs gratuitas, en este caso, usé la API de Gutendex.com para obtener información de libros. 🚀

---

## 🎯 **Propósito del Proyecto**

La aplicación sirve para practicar el desarrollo backend. Usé tecnologías como Spring Boot y PostgreSQL para manejar datos y trabajé con la API de Gutendex.com para explorar cómo consumir servicios externos. También quería entender mejor cómo funcionan las consultas y relaciones en bases de datos. 🌟

---

## 🛠️ **Funciones Principales**

1️⃣ **Buscar libro por título**: Puedes buscar un libro ingresando su título.

2️⃣ **Listar libros registrados**: Muestra todos los libros que están en la base de datos.

3️⃣ **Listar autores registrados**: Muestra todos los autores que están registrados.

4️⃣ **Listar autores vivos en un año**: Puedes buscar autores que seguían vivos en un año específico.

5️⃣ **Listar libros por idioma**: Filtra los libros por idioma.

---

## 🧩 **Tecnologías Utilizadas**

- **Java**: Para la lógica de la aplicación.
- **Spring Boot**: Para manejar el backend de forma más sencilla.
- **JPA**: Para interactuar con la base de datos.
- **PostgreSQL**: Base de datos relacional donde se guardan los datos.
- **Gutendex API**: Fuente gratuita para obtener datos de libros.

---

## 📦 **Requisitos Previos**

Para correr el proyecto necesitas:

- **Java 17 o superior**
- **Maven**
- **PostgreSQL**
- Un editor o IDE como IntelliJ IDEA o Eclipse

---

## 🚀 **Cómo Usarlo**

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu-repo/aplicacion-consola.git
   cd aplicacion-consola
   ```

2. **Configurar la base de datos**:
   - Crea una base de datos en PostgreSQL llamada `biblioteca`.
   - Configura el archivo `application.properties` con tus credenciales de PostgreSQL.

3. **Compilar y correr**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Interactuar con la aplicación**:
   Sigue las instrucciones que aparecen en la consola.

---

## 🎉 **Notas Finales**

Este proyecto es parte de mi proceso de aprendizaje. Si estás siguiendo cursos similares, te animo a intentar algo similar y experimentar con APIs gratuitas. ¡Espero que te sirva como inspiración! 🚀

