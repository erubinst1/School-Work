#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int questionHandler( int a, int b, int q );
int add ( int a, int b );
int sub ( int a, int b );
int mul ( int a, int b );
int divi ( int a, int b );
int mod ( int a, int b );

//score is global so it can be incremented/decremented across all methods
int score = 0;

//Main method to define the time and loop over the actual question handler
int main (){
	time_t start = 0,current = 0;
	int questions = 0;

	srand(time(NULL));

	printf("You will have 60 seconds to answer as many questions as possible with random combinations of digits from 1-99 and operations like addition, subtraction, multiplication, division (assume integer division), and modulus.\n");

	time(&start);
	time(&current);

	while( 60 >= difftime( current, start ))
	{	
		int random = (rand() % 5) + 1;
		int r1 = (rand() % 99) + 1;
		int r2 = (rand() % 99) + 1;

		printf("Evaluate the following expression: \n");

		questions = questionHandler( r1, r2, random );

		time(&current);
	}

	printf("You answered %d questions correctly out of %d in 60 seconds.\n", score, questions);

	return 0;
}

//response is global so it can be used across the operation functions
int response = 0;

//handles questions from random inputs from main
int questionHandler( int a, int b, int q ){
	//question count is static so it isnt redefined every time the handler is called
	static int qCount = 0;
	qCount++;

	if( q == 1 )
	{
		if( add( a, b ) == response)
		{
			printf("Correct! Current score, question count: %d, %d\n", score, qCount); 
			score++;
			return qCount;
		}
		else
		{
			printf("Not quite. Current score, question count: %d, %d\n", score, qCount);
			return qCount;
		}	
	}
	else if( q == 2 )
	{
		if( sub( a, b ) == response)
		{
			printf("Correct! Current score, question count: %d, %d\n", score, qCount);
			score++;
			return qCount;
		}
		else
		{
			printf("Not quite. Current score, question count: %d, %d\n", score, qCount);
			return qCount;
		}
	}
	else if( q == 3 )
	{
		if( mul( a, b ) == response)
		{
			printf("Correct! Current score, question count: %d, %d\n", score, qCount);
			score++;
			return qCount;
		}
		else
		{
			printf("Not quite. Current score, question count: %d, %d\n", score, qCount);
			return qCount;
		}
	}
	else if( q == 4 )
	{
		if( divi( a, b ) == response)
		{
			printf("Correct! Current score, question count: %d, %d\n", score, qCount);
			score++;
			return qCount;
		}
		else
		{
			printf("Not quite. Current score, question count: %d, %d\n", score, qCount);
			return qCount;
		}
	}
	else if( q == 5 )
	{
		if( mod( a, b ) == response)
		{
			printf("Correct! Current score, question count: %d, %d\n", score, qCount);
			score++;
			return qCount;
		}
		else
		{
			printf("Not quite. Current score, question count: %d, %d\n", score, qCount);
			return qCount;
		}
	}
	else
	{
		return 0;
	}

}

//performs addition
int add ( int a, int b){
	printf("%d + %d = ", a, b);
	scanf("%d", &response);
	return a + b;
}

//performs subtraction
int sub ( int a, int b){
	printf("%d - %d = ", a, b);
	scanf("%d", &response);
	return a - b;
}

//performs multiplication
int mul ( int a, int b){
	printf("%d * %d = ", a, b);
	scanf("%d", &response);
	return a * b;
}

//performs division
int divi (int a, int b){
	printf("%d / %d = ", a, b);
	scanf("%d", &response);
	return a / b;
}

//computes the remainder
int mod (int a, int b){
	printf("%d %% %d = ", a, b);
	scanf("%d", &response);
	return a % b;
}
