Having problems building uberjars with java resources, I wanted to
learn how to build these jar files with bare Clojure tools if
possible, so then I could try to add resources and replicate the
problem I was having. Long path, but it is for sure a learning path.

Anyways, I'm using this repo more for having something I can use to
ask for help to the community: kind of a big pastebin.

To test this simple hello world app, you would need at least version
1.10.3.905. I'm using 1.10.3.929, I'm installing in this way:

```
wget https://download.clojure.org/install/linux-install-1.10.3.929.sh
chmod +x linux-install-1.10.3.929.sh
./linux-install-1.10.3.929.sh --prefix /home/monkey/.local # I found full path is really needed for the prefix
```

Run with Clojure; any of...

```
clojure -X:greet
clojure -X:greet :who you
clojure -M -m jgomo3/hola
clojure -M -m jgomo3/hola you
```

Create a .jar file in the `target` folder:

```
clojure -T:build jar 
```

And run the application from that jar:

```
java -cp `clojure -Spath`:target/hola.clj-1.1.1.jar jgomo3.hola
```
