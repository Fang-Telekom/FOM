#include <stdio.h>
#include "kleiner.h"

void main(){
	float a, b;
	printf("\n\n\tWho is the little brother here!?\n");
	printf("\nGib mir die erste Größe:\t");
	scanf("%f",&a);
	printf("\nNun gib mir die zweite Größe:\t");
	scanf("%f",&b);

	if(a!=b){
		switch(kleiner(a, b)){
			case 0:	
				printf("\nHey, %f! YOU are the little Brother!\n",a);
			break;
			case 1:
				printf("\nHey, %f! YOU are the little Brother!\n", b);
			break;
			default:
			break;
		}
	} else{
		printf("\nWell, then! I am the Big Brother!\n");
	}
}
