FROM nginx

RUN apt-get -y update
RUN apt-get -y install iproute2
COPY ./default.conf /etc/nginx/conf.d/default.conf
COPY ./dist /usr/share/nginx/html
COPY init.sh /
