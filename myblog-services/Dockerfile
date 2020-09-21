# Linux O/S
FROM openjdk:8-jdk-alpine
	
#Copy jar from local system to docker O/S
ADD target/myblog-0.0.1-SNAPSHOT.war /tmp/myblog.war
	
#Command to run the application - java -jar /tmp/myblog.war
CMD ["java", "-jar", "/tmp/myblog.war"]