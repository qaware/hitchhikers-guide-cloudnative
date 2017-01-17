FROM qaware-oss-docker-registry.bintray.io/base/alpine-k8s-ibmjava8:8.0-3.10
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /app/zwitscher-board

COPY build/libs/zwitscher-board-1.0.0.jar /app/zwitscher-board/zwitscher-board.jar
COPY src/main/docker/zwitscher-board.conf /app/zwitscher-board/

EXPOSE 8081
CMD /app/zwitscher-board/zwitscher-board.jar
