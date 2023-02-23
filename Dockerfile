FROM tomcat

COPY . .

RUN useradd -ms /bin/bash testuser

RUN apt-get update ; apt-get install maven default-jdk -y ; update-alternatives --config javac

RUN mvn clean package ; cp target/*.war /usr/local/tomcat/webapps/

USER testuser
WORKDIR /home/testuser
CMD ["catalina.sh","run"]

