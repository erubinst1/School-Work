#include <stdio.h>

int main(){
	int a, b;

	printf("Enter the first number: ");
	scanf("%d", &a);
	printf("Enter the second number: ");
	scanf("%d", &b);

	printf("\n\n");
	
	printf("The sum of the %d and %d is %d\n", a,b, a+b);
	printf("The difference of %d and %d is %d\n", a,b, a-b);
	printf("The product of the %d and %d is %d\n", a,b, a*b);
	printf("The divisor of the %d and %d is %.2f\n", a,b, (float)a/b);
	printf("The remainder of the %d and %d is %d\n", a,b, a%b);

	return 0;
}
