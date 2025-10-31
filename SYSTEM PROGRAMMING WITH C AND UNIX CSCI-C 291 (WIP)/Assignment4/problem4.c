#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int rollDice();
int getSum( int a, int b);
int firstRoll();
int checkCraps(int score);

int roll = 0, score = 0, point = 0, stop = 1;

int main ()
{	
	srand(time(NULL));

	stop = firstRoll();

	while ( stop )
	{
		printf("\nCurrent roll\n");
		stop = checkCraps(getSum( rollDice(), rollDice() ));
	}	

	return 0;
}

int rollDice()
{
	char rolled = 'r';
	printf("Press R/r to roll one die\n");
	scanf(" %c", &rolled);

	if( rolled == 'r' || rolled == 'R' )
	{
		roll = (rand() % 6) + 1;
		printf("roll: %d\n", roll);

		return roll;
	}
	else
	{
		rollDice();
		return 0;
	}
}

int getSum( int a, int b )
{
	printf("\n");
	score = a + b;
	return score;
}

int firstRoll()
{
	getSum( rollDice(), rollDice() );

	printf("Turn sum: %d\n", score);

	if( score == 7 || score == 11 )
	{
		printf("Player wins. Score: %d\n", score);
		return 0;
	}
	if( score == 2 || score == 3 || score == 12 )
	{
		printf("Craps! The house wins. Score: %d\n", score);
		return 0;
	}
	if( score == 4 || score == 5 || score == 6 || score == 8 || score == 9 || score == 10)
	{
		point = score;
		printf("Players point. Score: %d\n", score);
		return 1;
	}
	else
	{
		printf("Keep rolling");
		return 1;
	}

}

int checkCraps( int givenScore )
{
	score = givenScore;
	
	printf("Point: %d\n", point);
	
	printf("Score: %d\n", score);

	if( score == point ){
		printf("Player wins.\n");
		return 0;
	}
	if( score == 7 || score == 11 )
	{
		printf("House wins.\n");
		return 0;
	}
	return 1;
}
