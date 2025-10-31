#include <stdio.h>
#define ARRAY_SIZE 10

int subArrCalc( int arr[], int idx1, int idx2, char operator);

int main(){
	int arr[ARRAY_SIZE];
	int idxArray[] = {99,99};

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
			arr[i] = input;
		}
	}

	printf("Enter 2 indicies in the array: \n");
	for(size_t i = 0; i < 2; i++){
		int input;
		if(scanf(" %d", &input) != 1 || (input > 9 || input < 0)){
			char c;
                        while((c = getchar()) != '\n'){}
			printf("Invalid input, restarting input sequence.\n");
			printf("Enter 2 indicies in the array: \n");	
			i = -1;
			continue;
		}
		idxArray[i] = input;

		if(idxArray[0] > idxArray[1]){
			char c;
                        while((c = getchar()) != '\n'){}
			printf("Invalid input, restarting input sequence.\n");
			printf("Enter 2 indicies in the array: \n");
			i = -1;
		}
	}

	char operator;

	while(1){
		printf("Enter an operator: \n");
		if(scanf(" %c", &operator) != 1 || (operator != '+' && operator != '-' && operator != '/' && operator != '*')){
			char c;
                        while((c = getchar()) != '\n'){}
			printf("Invalid input, please input a valid operator.\n");
		}
		else{
			break;
		}
	}

	int result = subArrCalc(arr, idxArray[0], idxArray[1], operator);

	printf("%d\n", result);
	return 1;
}

int subArrCalc( int arr[], int idx1, int idx2, char operator){
	int subArrSize = idx2-idx1 + 1;
	int subArr[subArrSize];
	int subArrIdx = 0;

	for(int i = idx1; i <= idx2; i++){
		subArr[subArrIdx++] = arr[i];
	}

	int result = subArr[0];

	printf("Subarray: {%d", subArr[0]);
	for(int i = 1; i < subArrSize; i++){
		printf(",%d", subArr[i]);
	}
	printf("}\n");

	switch (operator){
		case '+':
			for(int i = 1; i < subArrSize; i++){
				result += subArr[i];
			}
			printf("Sum is ");
			break;
		case '-':
			for(int i = 1; i < subArrSize; i++){
				result -= subArr[i];
			}
			printf("Difference is ");
			break;
		case '/':
			for(int i = 1; i < subArrSize; i++){
				result /= subArr[i];
			}
			printf("Dividend is ");
			break;
		case '*':
			for(int i = 1; i < subArrSize; i++){
				result *= subArr[i];
			}
			printf("Product is ");
			break;
		default:
			//should never be hit
			return -1;
	}
	return result;
}
