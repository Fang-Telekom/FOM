#include <stdio.h>

void main(){
	int n;
	printf("\n\nWillkommen bei Fibonacci!\n");
	printf("\nWie viele Fibonacci Zahlen willst du sehen? ^^\n");
	scanf("%d", &n);
	if(n>40)
		printf("\nTut mir Leid, dafür bin ich zu dumm :<");
	else if(n<0)
		printf("\nBitte verarsche mich nicht >:!");
	else{
		switch (n){
			case 0:
				printf("\nTja. Dann eben nicht! Bye!!\n");
				break;
			case 1:
				printf("\n0. \nDas nächstes Mal bitte eine höhere Zahl. Danke!");
				break;
			case 2:
				printf("\n0 ; 1. \nNun das ist ziemlich wenig findest du nicht?");
				break;
			default:
				printf("\n0 ; 1");
				int a=0,b=1,c;

				for(int i = 2;i<=n;i++){
					c = a + b;
					printf(" ;%d",c);
					a = b;
					b = c;
				}
				printf(".\nVielen Dank! UND Aufwiedersehen!");
			break;
		}
	}
}			

	
