#include <stdio.h>

int main(){
	int a[10] = {0,1,2,3,4,5,6,7,8,9};
	int idx1;
	int idx2;
	int * p1;
	int * p2;

	printf("Enter the first pointer index: ");
	scanf("%d", &idx1);
	printf("Enter the second pointer index: ");
        scanf("%d", &idx2);

	p1 = &a[idx1];
	p2 = &a[idx2];

	int prod = 1;

	while(p1 != p2+1){
		prod *= *p1;
		p1 += 1;
	}

	printf("Array product: %d\n", prod);

	return 1;
}
