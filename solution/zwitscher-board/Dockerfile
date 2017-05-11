FROM qaware-oss-docker-registry.bintray.io/base/centos7-jre8:8u77
MAINTAINER QAware GmbH <qaware-oss@qaware.de>

RUN mkdir -p /app/zwitscher-board

COPY build/libs/zwitscher-board-2.0.2.jar /app/zwitscher-board/zwitscher-board.jar
COPY src/main/docker/zwitscher-board.conf /app/zwitscher-board/

EXPOSE 8081
CMD /app/zwitscher-board/zwitscher-board.jar
