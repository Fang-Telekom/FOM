#include <stdio.h>

void main(){
	printf("\n\nBenzinverbrauch je 100 Kilometer ^^\n");
	float km, l;

	printf("\nBitte geben sie die gefahrene Kilometer an: \t");
	scanf("%f", &km);
	printf("\nBitte geben den Benzinverbrauch(l) je Kilometer: \t");
	scanf("%f", &l);
	printf("\nDer Verbrauch pro 100 Kilomenter ist %.04f", l*km);

	printf("\n\nDas Programm hat es berechnet. Viel Spass ^^\n");

}
