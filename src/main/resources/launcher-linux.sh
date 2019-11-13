#!/bin/sh
java \
	-Djdk.gtk.version=2 \
    -p ".;.\libs" \
    -m de.skymatic.javafxtest/de.skymatic.javafxtest.App
