#include <stdio.h>

int split();

void main(){
	int nenner, zaehler;	
	int con;
	do{
		printf("Bitte geben Sie den Nenner ein: ");
		scanf("%d", &nenner);
		printf("\nBitte geben Sie Zähler ein: ");
		scanf("%d", &zaehler);
		int teiler = split(nenner, zaehler);
		printf("\nDer Bruch ist %d / %d", (zaehler/teiler), (nenner / teiler));
		printf("\nDer Teiler ist %d", teiler);
		printf("\nContinue? 0 No | 1 Yes : ");
		scanf("%d", &con);
	} while(con);

}
int split(int nenner, int zaehler){
	int teiler;
	if(nenner / 2 > zaehler)
		teiler = zaehler;
	else
		teiler = nenner / 2;

	do{
		if(nenner % teiler == 0 && zaehler % teiler == 0)
			return teiler;
		else{
			teiler = teiler - 1;
		}
	} while(teiler > 1);

	return 1;
}

