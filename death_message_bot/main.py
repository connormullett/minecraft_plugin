#!/usr/bin/env python

import telegram
import requests
from flask import Flask
import os
import threading
from telegram.ext import Updater, CommandHandler, MessageHandler
import subprocess

bot = telegram.Bot(token=os.getenv('MC_BOT_TOKEN'))

app = Flask(__name__)


def run_server():
  app.run()


# accept http requests from server
@app.route('/death/<death_message>')
def send_death_message(death_message):
  bot.send_message(chat_id=os.getenv('CHAT_ID'), text=death_message)
  return None, 200


# sends mcrcon request to get players from plugin, /online is a custom command defined in the plugin
def online_players_command(update, context):
  stream = os.popen(f'mcrcon -c -H 127.0.0.1 -p {os.getenv("MCRCON_PASS")} online')
  out = stream.read()
  out = out.rstrip()

  update.message.reply_text(out)


def main():
  server_thread = threading.Thread(target=run_server)

  updater = Updater(os.getenv('MC_BOT_TOKEN'), use_context=True)
  dp = updater.dispatcher

  global bot
  bot = updater.bot

  server_thread.start()

  dp.add_handler(CommandHandler("online", online_players_command))

  updater.start_polling()
  updater.idle()
  

if __name__ == "__main__":
  main()

