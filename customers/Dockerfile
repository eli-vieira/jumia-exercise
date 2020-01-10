FROM tomcat:8.0-alpine
LABEL maintainer="elianapvieira@gmail.com"
COPY ./target/database /usr/local/tomcat/webapps/
COPY ./target/customers-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
