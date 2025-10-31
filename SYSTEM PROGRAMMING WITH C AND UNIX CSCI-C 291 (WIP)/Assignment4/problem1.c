#include <stdio.h>

int addThenMultiply ( int a, int b, int m, int t);
int multiply( int n, int m, int t, int acc );

//Main takes 4 inputs. The first two are added in the addThenMultiply function. That result is multiplied by the third number fouth number times

int main (){
	int num1, num2, num3, num4;

	printf("Enter the first integer to add: ");
	scanf("%d", &num1);

	printf("Enter the second integer to add: ");
	scanf("%d", &num2);

	printf("Enter the integer to multiply by: ");
	scanf("%d", &num3);

	printf("Enter the number of times to multiply: ");
	scanf("%d", &num4);

	//addThenMultiply is added to the stack with the input values num1, num2, num3, num4	
	printf("Result of adding %d and %d then multiplying the result by %d %d times is %d\n", num1, num2, num3, num4, addThenMultiply(num1, num2, num3, num4));	


	return 0;
}

int addThenMultiply ( int a, int b, int m, int t ){
	//multiply is then added to the stack with the values of a+b, m, t, and 0
	return multiply( a + b, m, t, 0); 
}

int multiply( int n, int m, int t, int acc ){
	//base case, the accumulated value is returned when the times to multiply reaches 0. This is tail recursive so the accumulator will be returned from the top of the call stack straight to addThenMultiply since it does not need to return a series of values to be accumulated/trace down the call stack. This causes all of the multiply calls in the stack to be popped, leaving just the addThenMultiply call which returns acc to the origional print statement
	if( t <= 0 ){
		return acc;
	}
	acc += n * m;
	return multiply( n, m, t-1, acc );
}
