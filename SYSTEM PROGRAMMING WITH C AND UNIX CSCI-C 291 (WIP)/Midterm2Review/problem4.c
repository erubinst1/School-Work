#include <stdio.h>


void transpose(int row, int col, int a[row][col]){
	for(int i = 0; i < row; i++){
		for(int j = 0; j < col; j++){
			printf("%d ", a[j][i]);
		}
		printf("\n");
	}
}

int main(){
	int a[2][2] = {{1,2},{3,4}};
	transpose(2,2,a);

	int b[3][3] = {{5,6,3},{3,4,5},{8,7,4}};
	transpose(3,3,b);

	return 1;
}
