FROM java:8

ADD target/wms-visual-monitor.jar app.jar

EXPOSE 9100

ENTRYPOINT ["java","-jar","app.jar"]