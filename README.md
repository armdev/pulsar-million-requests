# pulsar-million-requests
Spring boot apache pulsar with million requests

1. run with ./run.sh
2. send message from simple controller http://localhost:3021/webjars/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
3. attack from console: ab -k -c 100-n 1000 http://localhost:3021/api/v2/pulsars/send?message=ping
   ab -k -c 1000 -n 10000 http://localhost:3021/api/v2/pulsars/send/json
4. Dashboard http://localhost:9090/
