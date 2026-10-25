#!/usr/bin/env bash
set -eu
project_dir=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
cd "$project_dir"
mkdir -p build/classes
javac -encoding UTF-8 --release 11 -d build/classes src/*.java
exec java -cp build/classes Main
