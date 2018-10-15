.POHNY: publish-server, build, run, debug, stop
publish-server:
	(cd server ; sbt ";compile;docker:publishLocal")
	export DOCKER_ID_USER="spluxx"
	docker login
	docker tag spluxxcom_api ${DOCKER_ID_USER}/spluxxcom_api
	docker push ${DOCKER_ID_USER}/spluxxcom_api
build: 
	(cd web ; npm install ; npm run build)
	docker-compose build
run: 
	docker-compose up -d
debug:
	docker-compose up
stop:
	docker-compose down
deploy:
	@echo "Execution of this rule requires appropriate identity file(.pem) set up in .ssh/config"
	# make publish-server
	rsync -a --exclude=server --exclude=web/node_modules . ec2-user@poke.spluxx.com:~/
	ssh ec2-user@poke.spluxx.com 'make stop;make build;make run;'
