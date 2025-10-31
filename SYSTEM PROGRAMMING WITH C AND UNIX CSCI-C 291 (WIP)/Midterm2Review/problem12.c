#include <stdio.h>

int main(){
	int a[10] = {0,0,0,0,0,0,0,0,0,0};

	int index, number, isntFull = 1;

	while(isntFull){
		int foundZero = 0;

		printf("Enter an index: ");
		scanf("%d", &index);
		printf("Enter a number: ");
                scanf("%d", &number);

		a[index] = number;

		for(int i = 0; i < 10; i++){
			if(a[i] == 0){
				foundZero = 1;
				break;
			}
		}

		if(!foundZero){
			isntFull = 0;	
		}
	}

	for(int i = 0; i < 10; i++){
		printf("%d ", a[i]);
	}

	printf("\n");

	return 1;
}
