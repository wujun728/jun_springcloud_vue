FROM java:8

ADD target/wms-modules-system.jar app.jar

EXPOSE 9201

ENTRYPOINT ["java","-jar","app.jar"]