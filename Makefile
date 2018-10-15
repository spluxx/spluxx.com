.POHNY: scp

scp:
	@echo "Execution of this rule requires appropriate identity file(.pem) set up in .ssh/config"

	rsync -a --omit-dir-times --exclude=pokeserver/target --exclude=web/node_modules . ec2-user@spluxx.com:~/ 
