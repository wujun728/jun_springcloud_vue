FROM java:8

ADD target/wms-modules-file.jar app.jar

EXPOSE 9300

ENTRYPOINT ["java","-jar","app.jar"]