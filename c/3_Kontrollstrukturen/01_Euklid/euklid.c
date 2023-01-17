#include <stdio.h>

void main(){
	int x, y;
	printf("\n\nHier ist Euklid ^^\n\n");
	printf("Bitte geben Sie die erste Zahl ein: ");
	scanf("%d",&x);
	printf("\nBitte geben Sie die zweite Zahl ein: ");
	scanf("%d",&y);
	while(x!=y){
		if(x>y){
			x-=y;
		}else{
			y-=x;
		}
	}
	printf("\nDer ggT is %d\n",x);
	printf("\nEuklid verabschiedet sich ^^\n\n");
}
