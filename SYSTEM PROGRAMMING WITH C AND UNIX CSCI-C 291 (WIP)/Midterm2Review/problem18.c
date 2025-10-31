#include <stdio.h>

int isPrime(int n){
	for(int i = 2; i < n; i++){
		if(n % i == 0){
			return 0;
		}
	}
	
	return 1;
}

int main(){
	int size;

	printf("Enter an array size: ");
	scanf("%d", &size);

	int a[size];

	for(int i = 0; i < size; i++){
		printf("Enter an array value: ");
        	scanf("%d", &a[i]);
	}

	int sum = 0;

	for(int i = 1; i < size; i++){
		if(isPrime(i)){
			sum += a[i];
		}
	}

	printf("Sum of prime indices: %d\n", sum);

	return 1;
}
