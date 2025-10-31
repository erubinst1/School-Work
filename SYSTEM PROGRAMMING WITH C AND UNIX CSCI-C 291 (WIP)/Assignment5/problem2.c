#include <stdio.h>
#include <limits.h>
#define ARRAY_SIZE 10

int main(){
	int inArr[ARRAY_SIZE];
	int ascArr[ARRAY_SIZE];

	printf("Enter 10 integers: \n");

	for(size_t i = 0; i < ARRAY_SIZE; i++){
		int input;
		if(scanf(" %d", &input) != 1){
			char c;
			while((c = getchar()) != '\n'){}
			printf("Invalid input, restarting input sequence.\n");
			printf("Enter 10 integers: \n");
			i = -1;
		}
		else{
			inArr[i] = input;
		}
	}

	int curr = 0;

	while(curr < ARRAY_SIZE){
		int min = INT_MAX;
		for(size_t i = curr; i < ARRAY_SIZE; i++){			
			if(min > inArr[i]){
				min = inArr[i];	
			}

			if(i == ARRAY_SIZE-1){
				ascArr[curr] = min;
				curr++;
			}	
		}
	}

	printf("The numbers in ascending order are: %d", ascArr[0]);
	for(size_t i = 1; i < ARRAY_SIZE; i++){
		printf(" %d", ascArr[i]);
	}
	printf("\n");

	printf("The numbers in descending order are: %d", ascArr[9]);
	for(size_t i = 8; i != 0; i--){
		printf(" %d", ascArr[i]);
	}
	printf(" %d", ascArr[0]);
	printf("\n");

	return 1;
}	
