FROM tomcat:9.0.1-alpine
COPY tomcat-users.xml /usr/local/tomcat/conf/
RUN rm -rf /usr/local/tomcat/webapps/ROOT
CMD ["catalina.sh", "run"]