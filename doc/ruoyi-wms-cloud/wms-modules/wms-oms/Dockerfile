FROM java:8

ADD target/wms-modules-oms.jar app.jar

EXPOSE 9204

ENTRYPOINT ["java","-jar","app.jar"]