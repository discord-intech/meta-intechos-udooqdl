#!/bin/sh
python motordaemon_incrementer.py
bitbake motordaemon
sync
cd /home/discord/apt
./refresh.sh
sync
