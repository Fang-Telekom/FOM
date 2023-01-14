header = kleiner.h

default: vergleiche

vergleiche.o: vergleiche.c $(header)
	gcc -c vergleiche.c -o vergleiche.o

kleiner.o: kleiner.c
	gcc -c kleiner.c -o kleiner.o

vergleiche: vergleiche.o kleiner.o
	gcc vergleiche.o kleiner.o -o vergleiche

clean:
	-rm -f vergleiche.o
	-rm -f kleiner.o
	-rm -f vergleiche 
