FROM java:8

ADD target/wms-modules-job.jar app.jar

EXPOSE 9203

ENTRYPOINT ["java","-jar","app.jar"]