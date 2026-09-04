# Etapa 1: Construcción (Builder)
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . .

# Da permisos de ejecución al wrapper de Maven y compila el JAR
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# Etapa 2: Imagen de ejecución (Final)
FROM eclipse-temurin:21-jre-alpine    
WORKDIR /app

# Ahora la ruta /app/target/ existirá correctamente gracias al WORKDIR de arriba
COPY --from=builder /app/target/TodoCode-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
