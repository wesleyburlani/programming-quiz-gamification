mkdir -p bin
jarFiles=$(ls jar | sed -e 's/^/jar\//' | tr '\n' ':')
javac -cp $jarFiles src/*.java src/*/*.java -d bin