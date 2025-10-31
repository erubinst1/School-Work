#include <stdio.h>
#include <math.h>

int main(){
	int in;

	printf("Enter a number: ");
	scanf("%d", &in);

	int inSq = sqrt(in);

	if(inSq * inSq == in){
		printf("The input is a perfect square.\n");
	}
	else{
		printf("The input isnt a perfect square.\n");
	}

	return 1;
}
