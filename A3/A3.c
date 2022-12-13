#include<stdio.h>

int main(){
	for(int i=0;i<10;i++){
		printf("\nZeile %d:", i+1);
		for(int n=0; n<10;n++){
			printf("*");
		}
	}
	printf("\n");
	return 0;
}
