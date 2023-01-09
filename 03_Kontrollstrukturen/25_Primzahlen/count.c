#include <stdio.h>

int count(int n){
	switch (n){
		case 0:
			return 0;
		break;
		case 1:
			printf("1 ;\n Willst wirklich nur eins wissen?");
			return 0;
		break;
		case 2:
			printf("1 ; 2 ; ");
			return 1;
		break;
		defautlt:
			printf("1 ; 2 ; ");
			int allPrim = 1, p_anzahl = 0, c = 3;
			while(allPrim){
				if(n == 2)
					break;
				int isP = 1;
					
				for(int i = 3; i < c / 2; i += 2){
					if(c % i == 0){
						isP=0;
						break;
					}
				}
				if(isP){
					printf("%d ; ", c);
					p_anzahl++;
					if(p_anzahl >= n-2)
						allPrim = 0;
				}
				c += 2;
			}
			return 1;
		break;	
	}
}
