#!/bin/sh
java \
	-Djdk.gtk.version=2 \
    -p ".;.\libs" \
    -m de.skymatic.app/de.skymatic.app.App
