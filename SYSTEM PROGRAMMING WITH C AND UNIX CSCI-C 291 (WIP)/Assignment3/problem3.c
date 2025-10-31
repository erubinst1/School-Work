#include <stdio.h>

int main () {
	int count = 0, in = 0;

	printf("Enter a starting int: ");
	scanf("%d", &in);
	//input validity check
	if( in < 1 ){
		printf("Cannot compute FizzBuzz of %d", in);
	}
	else{

		do{
			if( in % 3 == 0 && in % 5 == 0 ){
				printf("Fizz-Buzz ");
			}
			else if( in % 3 == 0){
				printf("Fizz ");
			}
			else if( in % 5 == 0){
				printf("Buzz ");
			}
			else{
				printf("%d ", in);
			}

			count++;
			in--;

			if( count == 4){
				printf("\n");
				count = 0;
			}

		} while( in > 0 ); 
	}
	
	printf("\n");

	return 0;
}
