# pulsar-million-requests
Spring boot apache pulsar with million requests

1. run with ./run.sh
2. send message from simple controller http://localhost:3021/webjars/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
3. attack from console: ab -k -c 10000 -n 1000000 http://localhost:3021/api/v2/pulsars/send?message=ping
