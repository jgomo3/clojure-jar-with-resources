Having problems building uberjars with java resources, I wanted to
learn how to build these jar files with bare Clojure tools if
possible, so then I could try to add resources and replicate the
problem I was having. Long path, but it is for sure a learning path.

Anyways, I'm using this repo more for having something I can use to
ask for help to the community: kind of a big pastebin.

This can replicate the problem when trying to build the uberjar.

## Requirements

To test this simple hello world app, you would need at least version
1.10.3.905. I'm using 1.10.3.929, I'm installing in this way:

```
wget https://download.clojure.org/install/linux-install-1.10.3.929.sh
chmod +x linux-install-1.10.3.929.sh
./linux-install-1.10.3.929.sh --prefix /home/monkey/.local # I found full path is really needed for the prefix
```


## Run simply with Clojure

```
clojure -X:greet
clojure -X:greet :who you
clojure -M -m jgomo3.hola
clojure -M -m jgomo3.hola you
```

## Create the uberjar

This will not work (yet). Check the deps to see how I'm parametrizing
the userjar taks. It is based on depstar.

```
clojure -T:uberjar
```

Test it:

```
java -jar hola.jar
```

The error:

```
Exception in thread "main" java.lang.IllegalArgumentException: Not a file: jar:file:/home/monkey/Repositories/Playground/jar-with-resources/hola.jar!/hola.txt
	at clojure.java.io$fn__11416.invokeStatic(io.clj:61)
	at clojure.java.io$fn__11416.invoke(io.clj:44)
	at clojure.java.io$fn__11390$G__11372__11395.invoke(io.clj:35)
	at clojure.java.io$file.invokeStatic(io.clj:424)
	at clojure.java.io$file.invoke(io.clj:418)
	at jgomo3.hola$greet.invokeStatic(hola.clj:6)
	at jgomo3.hola$greet.invoke(hola.clj:5)
	at jgomo3.hola$_main.invokeStatic(hola.clj:13)
	at jgomo3.hola$_main.doInvoke(hola.clj:12)
	at clojure.lang.RestFn.invoke(RestFn.java:397)
	at clojure.lang.AFn.applyToHelper(AFn.java:152)
	at clojure.lang.RestFn.applyTo(RestFn.java:132)
	at jgomo3.hola.main(Unknown Source)
```

## Building the .jar "manually"

This works fine. The app can find and use the resource.

Clean the `target` folder (if any):

```
clojure -T:build clean
```

Create a .jar file in the `target` folder:

```
clojure -T:build jar 
```

And run the application from that jar:

```
java -cp `clojure -Spath`:target/hola.clj-1.1.1.jar jgomo3.hola
```

### Some Links about all this

- https://clojure.org/guides/tools_build
- https://clojureverse.org/t/how-to-depend-on-tools-build/7916
- https://stackoverflow.com/questions/22100421/clojure-how-does-clojure-java-io-resource-load-file
- https://clojure.org/reference/compilation
