FROM qaware-oss-docker-registry.bintray.io/base/centos7-jre8:8u77
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /app/zwitscher-service

COPY build/libs/zwitscher-service-1.1.0.jar /app/zwitscher-service/zwitscher-service.jar
COPY src/main/docker/zwitscher-service.conf /app/zwitscher-service/

EXPOSE 8080
CMD /app/zwitscher-service/zwitscher-service.jar