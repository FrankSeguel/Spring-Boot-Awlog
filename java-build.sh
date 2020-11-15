#!/bin/bash
echo "Compilando Fuentes"

export JAVA_HOME=/opt/jdk1.8.0_221/
export MAVEN_HOME=/opt/apache-maven-3.6.3/

export PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH

# Compilacion del proyecto.
mvn clean install -DskipTests=true

echo '==FIN del Build=='
