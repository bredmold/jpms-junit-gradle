FROM debian:10-slim

USER root

RUN apt-get -y update && \
    apt-get -y upgrade && \
    mkdir /opt/image

COPY build/image /opt/image

ENTRYPOINT ["/opt/image/bin/service.impl"]
CMD ["this", "is", "docker"]
