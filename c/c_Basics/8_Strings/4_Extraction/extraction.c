#include <stdio.h>
#include <string.h>

void main(){
	char string[] = "C:/Eigene_Dateien/FOM/C-Code/main.c";
	
	printf("\n%s", strrchr(string, '.')+1);
	char* name = strrchr (string, '/')+1;
	printf("\n%s", name);
	
	int size = sizeof(string)/sizeof(char);
	int nSize = sizeof(name)/sizeof(char);
	*name = '\0';
	printf("\n%s\n", string);

}

