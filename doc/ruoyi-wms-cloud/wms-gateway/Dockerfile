FROM java:8

ADD target/wms-gateway.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]