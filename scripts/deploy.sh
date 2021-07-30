#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i /Users/andreyzhukovskiy/.ssh/id_rsa \
  target/zuk-0.0.1-SNAPSHOT.jar \
  root@185.166:~/home/dru/

echo 'Restart Server...'

ssh -i /Users/andreyzhukovskiy/.ssh/id_rsa << EOF

pgrep java | xargs kill -9
nohup java -jar ~/home/dru/zuk-0.0.1-SNAPSHOT.jar > ~/home/dru/log.txt &

EOF

echo 'Bye'