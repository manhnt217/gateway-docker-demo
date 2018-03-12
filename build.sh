#!/bin/bash

export DOCKER_CMD="docker --tlsverify --tlscacert=/ca/ca.pem --tlscert=/ca/client/cert.pem --tlskey=/ca/client/key.pem -H=vm1:2376" 
export PACKAGE="vm2:443/"
export VERSION="0.1"

function build_maven() {



	if [[ -z $1 ]]; then
		# Clean all artifacts
		for container in ./*; do
			if [[ -e $container/docker/bin ]]; then
				rm -rf $container/docker/bin 
			fi
		done
		mvn clean package
	elif [[ -e "./$1/pom.xml" ]]; then
		rm -rf "./$1/docker/bin" 
		mvn clean package -pl $1 -am
	fi	
}

function build_all_docker() {

	for container in ./* ; do

		if [[ -e $container/docker/Dockerfile ]]; then
			
			pushd $container/docker > /dev/null
				if [[ $container == "./gateway" ]]; then

					${DOCKER_CMD} build -t ${PACKAGE}gateway:${VERSION} .
				else
					CONTAINER_NAME=${container:2}
					${DOCKER_CMD} build --build-arg JAR_FILE=bin/app.jar -t ${PACKAGE}${CONTAINER_NAME}:${VERSION} .
				fi
			popd > /dev/null
		fi
	done
}

function build_docker() {

	if [[ ! -e "./$1/docker/Dockerfile" ]]; then
		return;
	fi

	pushd ./$1/docker > /dev/null
		if [[ $1 == "gateway" ]]; then
			${DOCKER_CMD} build -t ${PACKAGE}$1:${VERSION} .
		else
			${DOCKER_CMD} build --build-arg JAR_FILE=bin/app.jar -t ${PACKAGE}$1:${VERSION} .
		fi
	popd > /dev/null
}

if [[ -z $1 ]]; then
	build_maven
	build_all_docker
else
	build_maven $1
	build_docker $1
fi