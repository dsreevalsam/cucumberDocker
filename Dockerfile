FROM openjdk:8u191-jre-alpine3.8
RUN apk add curl jq
WORKDIR /usr/share/selenium-docker

# Add jars under target from host
ADD target/selenium-docker.jar	selenium-docker.jar
ADD target/selenium-docker-tests.jar	selenium-docker-tests.jar
ADD target/libs	libs

#Add Suite files
ADD E2ETests.xml	E2ETests.xml
ADD healthcheck.sh healthcheck.sh
ADD src/test/java/com/tests/features/*.feature src/test/java/com/tests/features/


#Uncomment below line if test is run from a windows machine
#RUN dos2unix healthcheck.sh


ENTRYPOINT sh healthcheck.sh