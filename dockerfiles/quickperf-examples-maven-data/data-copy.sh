#!/bin/bash
if [ ! -d /work/volumes/.m2/repository ]; then
  mkdir -p /work/volumes/.m2/repository;
  cp -rf /work/m2repo/* /work/volumes/.m2/repository/;
fi

tail -f /dev/null
