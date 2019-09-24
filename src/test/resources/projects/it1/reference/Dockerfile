# declaration of NEXUS_VERSION must appear before first FROM command
# see: https://docs.docker.com/engine/reference/builder/#understand-how-arg-and-from-interact
ARG NEXUS_VERSION=latest

FROM maven:3-jdk-8-alpine AS build

COPY . /nexus-repository-foo/
RUN cd /nexus-repository-foo/; \
    mvn clean package -PbuildKar;

FROM sonatype/nexus3:$NEXUS_VERSION

ARG FORMAT_VERSION=0.0.1
ARG DEPLOY_DIR=/opt/sonatype/nexus/deploy/
USER root
COPY --from=build /nexus-repository-foo/nexus-repository-foo/target/nexus-repository-foo-${FORMAT_VERSION}-bundle.kar ${DEPLOY_DIR}
USER nexus
