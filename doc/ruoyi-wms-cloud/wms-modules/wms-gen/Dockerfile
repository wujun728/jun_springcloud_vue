FROM java:8

ADD target/wms-modules-gen.jar app.jar

EXPOSE 9202

ENTRYPOINT ["java","-jar","app.jar"]