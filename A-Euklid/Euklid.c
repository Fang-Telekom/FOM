#include<stdio.h>

int main(){
	int weiter=1;
	do{
		int zahl1=0,zahl2=0;
		printf("\nHallo! Willkommen zur Euklid!\n");
		printf("Es wird die 1.Zahl benötigt: \n");
		scanf("%d",&zahl1);
		printf("Es wird die 2.Zahl benötigt: \n");
		scanf("%d",&zahl2);
 
		while(zahl1!=zahl2&&zahl1 >0){
			if(zahl1 > zahl2)
				zahl1-=zahl2;
			else
				zahl2-=zahl1;
		}
		printf("\nDie beste Zutat ist %d\n",zahl1);
		printf("\nNocheinmal? 	[1]ja	[0]nein\n");
		scanf("%d",&weiter);
	}while(weiter);

	return 0;
}
