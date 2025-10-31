#include <stdio.h>

int findGCD( int a, int b, int denom );

int main ()
{
	int num1, num2, max;

	printf("Enter the first positive integer: ");
	scanf("%d", &num1);
	printf("Enter the second positive integer: ");
	scanf("%d", &num2);
	
	if( num1 > num2 )
	{
		max = num1;
	}
	else
	{
		max = num2;
	}

	printf("The greatest common denominator of %d and %d is %d\n", num1, num2, findGCD( num1, num2, max ));

	return 0;
}

int findGCD( int a, int b, int denom )
{
	if( a % denom == 0 && b % denom == 0 )
	{
		return denom;		
	}
	else
	{
		return findGCD( a, b, denom - 1 );
	}
}
