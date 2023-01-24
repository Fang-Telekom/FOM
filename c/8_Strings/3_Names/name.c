#include <stdio.h>
#include <string.h>

void main(){
	char* vorname[5] = {"Franz", "Meriam", "Justin", "Kai", "Bob"};
	char* nachname[5] = {"Bauer", "Schmidt", "Mueller", "Fang", "Baumeister"};
        char* underscore = "_";

	printf("\n\nWillkommen. Hier werden 5 Namen aufgelistet.\n");
	
	for(int i = 0; i < 5; i++){
		char zeile[81];
		strcpy(zeile, vorname[i]);
		for(int x = strlen(vorname[i]); x <= 80 - strlen(nachname[i]); x++){
		 	strcat(zeile, underscore);
		}
		strcat(zeile, nachname[i]);
		// zeile[81] = '\0';
		printf("\n%s",zeile);
	}
	printf("\n\n");
}

