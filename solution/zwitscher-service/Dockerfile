FROM qaware-oss-docker-registry.bintray.io/base/alpine-k8s-ibmjava8:8.0-3.10
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /app/zwitscher-service

COPY build/libs/zwitscher-service-1.0.0.jar /app/zwitscher-service/zwitscher-service.jar
COPY src/main/docker/zwitscher-service.conf /app/zwitscher-service/

EXPOSE 8080
CMD /app/zwitscher-service/zwitscher-service.jar