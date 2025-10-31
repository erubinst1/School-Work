#include <stdio.h>

void printUniqueElements(int elements[], int lenArray);

int main(){
	int size;

	printf("Input Size of Array: ");
	scanf("%d", &size);

	int arr[size];
	for(int i = 0; i < size; i++){
		printf("Input: ");
		scanf("%d", &arr[i]);
	}

	printUniqueElements(arr, size);

	return 0;
}

void printUniqueElements(int elements[], int lenArray){
	int count = 1;

	if(lenArray > 0){
		int currUniqueElem = elements[0];

		//finds number of unique elements, size of result array
		for(int i = 1; i < lenArray; i++){
			if(elements[i] != currUniqueElem){
				count++;
				currUniqueElem = elements[i];
			}
		}

		int result[count];
		currUniqueElem = elements[0];
		int resultIdx = 0;

		//populates result array
		for(int i = 0; i < lenArray; i++){
			if(elements[i] != currUniqueElem){
				result[resultIdx] = currUniqueElem;
				resultIdx++;
				currUniqueElem = elements[i];
			}
		}
		result[resultIdx++] = currUniqueElem;


		//prints output
		printf("Output: \n");
		for(int i = 0; i < count; i++){
			printf("%d\n", result[i]);
		}
	}
	else{
		printf("Output: \n");
	}
}
