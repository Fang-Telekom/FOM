#include <stdio.h>

void main(){

	int n;
	printf("\nWillkommen zur Eratostenes ^^ !");
	printf("\nBis zur welchen Zahl sollen Prim gefunden werden?\n");
	scanf("%d",&n);
	
	int prim[n-1];
	for(int i = 0; i < sizeof(prim)/sizeof(prim[0]); i++){
		prim[i] = 1;
	}
	for(int x = 2; x <= n/2; x++){
		if(!prim[x-2])
			continue;
		for(int y = x+x; y <= n; y+=x){
			prim[y-2] = 0;
			printf("\n%d ist keine Primzahl!", y);
		}
	}
	printf("\nPrimzahlen sind : \n");
	for(int i = 0; i < sizeof(prim)/sizeof(prim[0]); i++){
		if(prim[i])
			printf("%d ; ", i+2);
	}
	printf("\n");
}
