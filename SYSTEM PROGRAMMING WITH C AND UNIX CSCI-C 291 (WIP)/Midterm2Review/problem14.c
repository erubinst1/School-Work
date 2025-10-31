#include <stdio.h>

int main(){
	int a[3][3] = {{5,6,3},{3,4,5},{8,7,4}};
	
	for(int i = 0; i < 3; i++){
		int rowSum = 0, colSum = 0;

		for(int j = 0; j < 3; j++){
			rowSum += a[i][j];
			colSum += a[j][i];
		}

		printf("Row total: %d. Column total: %d.\n", rowSum, colSum);
	}

	return 1;
}
