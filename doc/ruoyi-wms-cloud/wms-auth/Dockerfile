FROM java:8

ADD target/wms-auth.jar app.jar

EXPOSE 9200

ENTRYPOINT ["java","-jar","app.jar"]