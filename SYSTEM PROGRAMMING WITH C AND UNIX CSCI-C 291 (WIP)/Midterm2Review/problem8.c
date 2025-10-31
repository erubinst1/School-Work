#include <stdio.h>

int main(){
	int in;

	printf("Enter an integer: ");
	scanf("%d", &in);

	if(in%2 == 0){
		printf("The number is even.\n");
	}
	else{
		printf("The number is odd.\n");
	}

	return 1;
}
