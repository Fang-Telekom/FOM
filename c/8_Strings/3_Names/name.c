#include <stdio.h>
#include <string.h>

char ausgabe[](char* vorname, char* nachname){
	char zeile[81];
	strcpy(zeile, vorname);
	for(int x = strlen(vorname); x <= 80 - strlen(nachname); x++){
		zeile[x] = 'x';
	}
	strcat(zeile, nachname);
	zeile[81] = '\0';
	return zeile[0];
}

void main(){
	char* vorname[5] = {"Franz", "Meriam", "Justin", "Kai", "Bob"};
	char* nachname[5] = {"Bauer", "Schmidt", "Müller", "Fang", "Baumeister"};

	printf("\n\nWillkommen. Hier werden 5 Namen aufgelistet.\n");
	
	for(int i = 0; i < 5; i++){
		char zeile[81];
		strcpy(zeile, vorname[i]);
		for(int x = strlen(vorname[i]); x <= 80 - strlen(nachname[i]); x++){
			zeile[x] = 'x';
		}
		strcat(zeile, nachname[i]);
		zeile[81] = '\0';
		
		printf("\n%s",zeile);
	}
	printf("\n\n");
}

