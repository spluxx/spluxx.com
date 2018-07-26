.POHNY: build-server, build-web, build-docker, build, run, debug, stop

build-server:
	(cd server; sbt docker:stage)
build-web:
	(cd web; npm run build)
build-docker: 
	docker-compose build
build:
	build-server
	build-web
	build-docker
run: 
	docker-compose up -d
debug:
	docker-compose up
stop:
	docker-compose down
