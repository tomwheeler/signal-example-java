#!/bin/bash

mvn compile exec:java \
	-Dexec.mainClass="moneytransferapp.Signaller"
