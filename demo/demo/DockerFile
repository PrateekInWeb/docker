FROM ubuntu AS GIT_CLONE
#Install git
RUN apt-get update \        
     apt-get install -y git
RUN mkdir /home/sampleTest \      
           cd /home/sampleTest \        
           git clone https://github.com/jagadish12/SampleTest.git
#Set working directory
WORKDIR /home/sampleTest/demo/demo/

FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
COPY --from=GIT_CLONE pom.xml /build/
COPY --from=GIT_CLONE src /build/src/
WORKDIR /build/
RUN mvn package
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/demo-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "docker-boot-intro-0.1.0.jar"]