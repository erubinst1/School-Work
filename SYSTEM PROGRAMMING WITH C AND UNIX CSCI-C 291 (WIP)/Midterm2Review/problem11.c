#include <stdio.h>

void sort(int a[], int n){
	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j < n; j++) {
			if (a[i] > a[j]) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}
}

int main(){
	int size = 6;
	int a[6];

	printf("Enter 6 numbers\n");

	for(int i = 0; i < size; i++){
		printf("Enter a number: ");
		scanf("%d", &a[i]);
	}

	sort(a, size);

	printf("The second smallest number in the array is %d.\n", a[1]);

	return 1;
}
