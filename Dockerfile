FROM tomcat:9.0.13-jre8

COPY ./target/OpenAlprTest-1.0.jar ./xti-parkingapp-alpr.jar

CMD java -jar xti-parkingapp-alpr.jar