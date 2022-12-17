FROM centos:7
RUN yum -y update && yum clean all
RUN yum -y install httpd httpd-devel gcc* make && yum clean all
COPY httpd-proxy.conf /etc/httpd/conf.d/
COPY run-httpd.sh /run-httpd.sh
RUN chmod -v +x /run-httpd.sh
CMD ["/run-httpd.sh"]