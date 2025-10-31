#include <stdio.h>

void perfectNumber( int n, int fact);

int sumFactors = 0;

int main ()
{
	int in;

	printf("Enter a number: ");
	scanf("%d", &in);
	
	perfectNumber( in, in - 1);

	if( sumFactors == in )
	{
		printf("%d is a perfect number\n", in);
	}
	else
	{
		printf("%d is not a perfect number\n", in);
	}

	return 0;
}

void perfectNumber( int n, int fact)
{
	while( fact > 0 )
	{
		if( n % fact == 0 )
		{
			sumFactors += fact;
		}

		fact--;
	}
}
