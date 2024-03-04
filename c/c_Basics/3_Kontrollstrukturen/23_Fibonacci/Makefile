default: fibonacci

fibonacci.o: fibonacci.c
	gcc -c fibonacci.c -o fibonacci.o

fibonacci: fibonacci.o
	gcc fibonacci.o -o fibonacci

clean:
	rm -f fibonacci.o
	rm -f fibonacci
