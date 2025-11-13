#include <stdio.h>

int ggt(int, int);

void main(){
	int x, y;
	printf("\n\nWillkommen beim Größten gemeinsamen Teiler (GGT)!!!\n");
	printf("Nun, reichen Sie mir die zwei ganze Zahlen:\n");
	scanf("%d", &x);
	scanf("%d", &y);
	printf("\nDer GGT ist \t %d\n", ggt(x, y));
}

int ggt(int x, int y){
	if(x == y)
		return x;
	else if(x > y)
		return ggt(x - y, y);
	else
		return ggt(x, y - x);
}
