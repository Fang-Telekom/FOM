#include <stdio.h>

int count(int n){
	if(n<=0)
		return 0;
	else if(n==1){
		printf("1 ;\n Willst wirklich nur eins wissen?");
		return 0;
	}else {
		printf("1 ; 2 ; ");
		int p = 1, p_anzahl = 0, c = 3;
		while(p){
			if(n==2)
				break;
			int isP = 1;
			if(c%2==0){
				c++;
				continue;
			}	
			for(int i = 3; i<c/2;i+=2){
				if(c%i == 0){
					isP=0;
					break;
				}
			}
			if(isP){
				printf("%d ; ",c);
				p_anzahl++;
				if(p_anzahl >= n-2)
					p =0;
			}
			c++;
		}
		return 1;
	}

}
