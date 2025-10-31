#include <stdio.h>

void printPyramid(char * c, int n){
	int count = 1;
	for(int i = *c; i < *c+n; i++){
		for(int j = 0; j < count; j++){
			printf("%c", i);
		}
		count++;
		printf("\n");
	}
}

int main(){
	char c = 'A';
	printPyramid(&c, 4);

	c = 'D';
	printPyramid(&c, 5);

	return 1;
}
