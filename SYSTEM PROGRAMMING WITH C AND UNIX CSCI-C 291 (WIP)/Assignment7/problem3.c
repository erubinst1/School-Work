#include <stdio.h>

#define MAX 100

void replaceAll(const char * string, char * target, char * replacement, char * destination);

int main(){
	char string[256];
	char target[256];
	char replacement[256];
	char destination[256];

	printf("Enter a string: ");
	scanf(" %100[^\n]", string);

	printf("Enter the target: ");
	scanf(" %100[^\n]", target);

	printf("Enter replacement: ");
	scanf(" %100[^\n]", replacement);

	replaceAll(string, target, replacement, destination);

	printf("Output: %s\n", destination);

	return 1;
}

void replaceAll(const char * string, char * target, char * replacement, char * destination){
	int tlen = 0, rlen = 0;

	while(target[tlen] != '\0'){
		tlen++;
	}
	while(replacement[rlen] != '\0'){
		rlen++;
	}

	int i = 0, j = 0;

	//copy over string if target is empty
	if (tlen == 0){
		while (string[i] != '\0' && j < MAX){
			destination[j++] = string[i++];
		}
		destination[j] = '\0';
		return;
	}

	int k;

	while (string[i] != '\0' && j < MAX){
		for (k = 0; k < tlen; k++){
			//check for matches at i
			if (string[i + k] == '\0' || string[i + k] != target[k]) break;
		}

		if (k == tlen) {
			// matched target
			for (k = 0; k < rlen && j < MAX; k++){
				destination[j++] = replacement[k];
			}
			i += tlen;

		}
		else{
			// copy one char
			destination[j++] = string[i++];
		}
	}

	destination[j] = '\0';

}
