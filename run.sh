jarFiles=$(ls jar | sed -e 's/^/jar\//' | tr '\n' ':')
java -cp $jarFiles:bin Main