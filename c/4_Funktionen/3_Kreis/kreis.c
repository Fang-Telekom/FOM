#include "funktion.h"

void main(){
	float r, pi = 3.14159265359;
	printf("\n\nWillkommen zum Kreisrechner!\n");
	printf("Geben Sie bitte den Radius des Kreises ein: ");
	scanf("%f",&r);

	printf("\nDer Kreisumfang ist \t %f", umfang(r, pi));
	printf("\nDer Flächeninhalt ist \t %f", inhalt(r, pi));
	printf("\nVielen Dank für Ihren Beitrag!\n\n");
}
