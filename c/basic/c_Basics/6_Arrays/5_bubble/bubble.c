#include <stdio.h>

int liste[5];

void main(){
	int bubble;
	printf("\nWillkommen zur Bubble-Sort!\n");
	printf("\nEs werden 5 Zahlen deiner Wahl sortiert!\n");

	printf("Gib bitte jetz 5 Zahlen ein: \n");
	for(int i = 0; i < 5; i++){
		scanf("%d", &liste[i]);
	}
	for(int x = 1; x < 5; x++){
		for(int i = 0; i < 5 - x; i++){
			if(liste[i] > liste[i+1]){
				bubble = liste[i];
				liste[i] = liste[i+1];
				liste[i+1] = bubble;
			}
		}
	}
	for(int i = 0; i < 5; i++){
		printf("%d ; ", liste[i]);
	}
	printf("\nVielen Dank für Ihre Service!\n\n");
}

