#include <stdio.h>

void fib(int n){
	int count = 1, prev = 0, curr = 1;

	while(count <= n){
		if(count == 1){
			printf("0 ");
			count++;
		}
		else if(count == 2){
			printf("1 ");
			count++;
		}
		else{
			printf("%d ", prev + curr);
			int temp = curr;
			curr = prev+curr;
			prev = temp;
			count++;
		}
	}

	printf("\n");
}

int main(){
	int in;

	printf("Enter a number: ");
	scanf("%d", &in);

	fib(in);

	return 1;
}
