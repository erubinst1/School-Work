#include <stdio.h>
#include <math.h>

int isPrime(int n) {
	if (n <= 1) return 0;
	if (n == 2) return 1;
	if (n % 2 == 0) return 0;

	for (int i = 3; i <= sqrt(n); i += 2) {
		if (n % i == 0) return 0;
	}

	return 1;
}

int main() {
	int num;

	printf("Enter a number: ");
	scanf("%d", &num);

	if (isPrime(num)){
		printf("%d is prime.\n", num);
	}
	else{
		printf("%d is not prime.\n", num);
	}
	return 1;
}

