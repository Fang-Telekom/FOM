header = count.h

default: prim

prim.o: prim.c $(header)
	gcc -c prim.c -o prim.o

count.o: count.c
	gcc -c count.c -o count.o

prim: prim.o count.o
	gcc prim.o count.o -o prim

clean:
	-rm -f prim.o
	-rm -f count.o
	-rm -f prim
