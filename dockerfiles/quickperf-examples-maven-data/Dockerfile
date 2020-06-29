FROM quay.io/eclipse/che-java11-maven:nightly as builder
COPY --chown=1001:1001 . /quickperf-examples/
WORKDIR /quickperf-examples
RUN env && \
    mvn dependency:go-offline

FROM registry.access.redhat.com/ubi8/ubi-minimal
COPY --from=builder /home/user/.m2/repository /work/m2repo
COPY dockerfiles/quickperf-examples-maven-data/data-copy.sh /data-copy.sh
RUN  chmod 775 /data-copy.sh
CMD ["/data-copy.sh"]


