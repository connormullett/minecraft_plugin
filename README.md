
# Private Minecraft Server Plugin and Telegram Bot

- sends death messages to telegram channel using flask server
- gets online player count and names using `/online` command in telegram

# Development
### Requirements for local development
- MCRcon, a remote connection manager
- A registered telegram bot for access token
- Spigot server matching server version

### Minecraft Plugin
- Download a test server from spigot
- Use the Spigot docs to set up an environment and library
- NOTE: Server uses java 1.8, I will find errors when deploying
  changes 
- stick the built plugin JAR in the server's `plugins/` dir


### Telegram Bot
- `python3 -m venv venv`
- `source venv/bin/activate`
- `pip install -r requirements.txt`
- create a file called `.env` and place
  token and rcon password so that sourcing the file
  will create environment variables set in `main.py`
- run main.py as normal
- As long as a spigot server is running the plugin, 
  you should be able to test with the telegram
  and minecraft plugin via commands/actions (dying)

