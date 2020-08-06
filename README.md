
# Private Minecraft Server Plugin and Telegram Bot

- sends death messages to telegram channel using flask server
- gets online player count using `/online` command in telegram

# Development

### Minecraft Plugin
- Download a test server from spigot
- Use the Spigot docs to set up an environment and library
- NOTE: Server uses openjdk 1.8, use that build
- stick the built plugin JAR in the server's `plugins/` dir


### Telegram Bot
- `python3 -m venv venv`
- `source venv/bin/activate`
- `pip install -r requirements.txt`
- get token and mcrcon password from me
- create file called `.env` and place
  token and rcon password so that sourcing the file
  will create environment variables
- run main.py as normal

- As long as a spigot server is running the plugin, 
  you should be able to test with telegram
  and minecraft via commands/actions (dying)

