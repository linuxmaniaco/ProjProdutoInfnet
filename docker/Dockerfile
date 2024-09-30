FROM amazoncorretto:21
LABEL authors="eduardo"
#ENV SENHA_BANCO=''
WORKDIR /app
COPY app.jar ./
ENTRYPOINT ["java", "-jar", "app.jar"]