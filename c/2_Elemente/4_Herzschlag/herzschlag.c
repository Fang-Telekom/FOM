#include <stdio.h>

void main(){
	float schlaege, alter;
	printf("\n\nWillkommen zum Herzschlag-Rechner ^^\n");
	printf("\n\tHerzschlaege pro Minute: \n\t\t");
	scanf("%f", &schlaege);
	printf("\n\tAlter in Jahren: \n\t\t");
	scanf("%f", &alter);
	printf("\nIhr Herz hat seit Ihrer Geburt ");
	printf("%.0f", schlaege * 60 * 24 * 365.25 * alter);
	printf(" mal geschlagen.\n");
}
