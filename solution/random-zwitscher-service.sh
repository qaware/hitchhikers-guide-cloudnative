#!/bin/bash
RAND=$(( ( RANDOM % 42 )  + 1 ))
for (( i=1; i<=RAND; i++ ))
do
  curl -s -o /dev/null http://147.75.100.207/zwitscher-service/admin/info
done

curl http://147.75.100.207/zwitscher-service/admin/info
