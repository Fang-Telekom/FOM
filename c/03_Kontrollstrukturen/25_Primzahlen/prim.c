#include <stdio.h>
#include "count.h"

void main(){
	int n;
	printf("\n\nWillkomen zur Optimus Primer! ^^");
	printf("\n\nWie viele Prim-Zahlen solle ich Ihnen nennen?\n");
	scanf("%d",&n);
	if(count(n))
		printf("\nDas waren %d Primzahlen! Auf nie wieder sehen!\n", n);
	else
		printf("\nWer denkst du bin ich?! Bye!\n");
}
