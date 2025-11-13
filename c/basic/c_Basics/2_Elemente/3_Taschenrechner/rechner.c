#include <stdio.h>

void main(){
	float a, b;
	printf("\n\n Taschenrechner ^^\n\n");
	printf("Bitte geben Sie die 1. Zahl ein: \t");
	scanf("%f", &a);
	printf("\nBitte geben Sie die 2. Zahl ein: \t");
	scanf("%f", &b);
	printf("\nDie Summe ergibt %.02f.", a+b);
	printf("\n\nDas Programm hat gerechnet. BYE!\n");
} 
