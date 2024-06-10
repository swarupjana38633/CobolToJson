#!/bin/sh

BASEDIR=$(dirname $(realpath "$0"))
java -cp ${BASEDIR}/JRecordCodeGen.jar  ${1}
