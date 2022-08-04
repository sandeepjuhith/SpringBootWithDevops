FROM openjdk:8
EXPOSE 8585
ADD target/springbootwithdevops.jar springbootwithdevops.jar
ENTRYPOINT ["java","-jar","/springbootwithdevops.jar"]