#include <stdio.h>

void printReverse(const char * s){
	int size = 0;
	
	for(int i = 0; s[i] != '\0'; i++){
		size++;
	}

	for(int i = size; i >= 0; i--){
		printf("%c", s[i]);
	}
	printf("\n");
}

int main(){
	char * str = "tool";
	printReverse(str);

	str = "fear inoculum";
	printReverse(str);
	
	return 1;
}
