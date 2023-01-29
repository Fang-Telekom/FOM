header = funktion.h

default: kreis

kreis.o: kreis.c $(header)
	gcc -c kreis.c -o kreis.o

umfang.o: umfang.c
	gcc -c umfang.c -o umfang.o
inhalt.o: inhalt.c
	gcc -c inhalt.c -o inhalt.o

kreis: kreis.o umfang.o inhalt.o
	gcc kreis.o umfang.o inhalt.o -o kreis
	rm -f *.o

clean:
	rm -f *.o
	rm -f kreis
