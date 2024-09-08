#include <stdio.h>

float eingabeZahl(){
	float zahl;
	printf("\nGeben Sie bitte ein Zahl ein: ");
	scanf("%f",&zahl);
	return zahl;
}
float multipliziere(float a, float b){
	return a * b;
}
void ausgabe(float zahl){
	printf("Das Ergebnis der Multiplikation ist: %f\n\n", zahl);
}
void main(){
	ausgabe(multipliziere(eingabeZahl(), eingabeZahl()));
}
