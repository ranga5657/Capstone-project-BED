FROM openjdk:11
EXPOSE 9999
ARG JAR_FILE=target/super6.jar 
ADD ${JAR_FILE} super6.jar
ENTRYPOINT ["java","-jar","/super6.jar"] 