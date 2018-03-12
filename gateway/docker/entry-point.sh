#!/bin/sh

export DNS="$(cat /etc/resolv.conf | grep "nameserver" | awk '{print $2}' | tr '\n' ' ')"

envsubst '$DNS' < /etc/nginx/nginx.conf > /etc/nginx/nginx.conf

exec nginx -g "daemon off;"