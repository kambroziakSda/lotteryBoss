FROM jboss/wildfly:12.0.0.Final

ADD ./target/lotteryBoss.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]