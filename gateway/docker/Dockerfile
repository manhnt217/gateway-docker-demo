FROM nginx:latest
MAINTAINER manh.nguyen@jeppesen.com

COPY ./files/etc/nginx/* /etc/nginx/

COPY entry-point.sh /entry-point.sh

ENTRYPOINT ["/entry-point.sh", "nginx", "-g", "daemon off;"]