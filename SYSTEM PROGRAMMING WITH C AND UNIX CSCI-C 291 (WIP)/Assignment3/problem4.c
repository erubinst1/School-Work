#include <stdio.h>

int main (){
	int in = 0;

	printf("Enter a number to find the reverse binary representation: ");
	scanf("%d", &in);
	//input validity check
	if( in < 0 ){
		printf("Number must be a positive integer\n");
	}
	else{
		//turns the string to binary and prints as it goes to reverse it
		while( in > 0 ) {
        		printf("%d", in % 2);
        		in = in / 2;
    		}

		printf("\n");
	}
	return 0;
}
