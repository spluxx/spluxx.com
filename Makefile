.POHNY: build-server, build-web, build-docker, build, run, debug, stop

build: 
	(cd server ; sbt ";compile;docker:publishLocal")
	(cd web ; npm run build)
	docker-compose build
run: 
	docker-compose up -d
debug:
	docker-compose up
stop:
	docker-compose down
