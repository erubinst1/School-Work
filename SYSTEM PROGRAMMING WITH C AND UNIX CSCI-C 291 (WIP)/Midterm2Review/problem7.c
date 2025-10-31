#include <stdio.h>

int only1or2(int a[], int n){
	for(int i = 0; i < n; i++){
		if(a[i] != 1 && a[i] != 2){
			return 0;
		}
	}
	return 1;
}

int main(){
	int a[] = {1,2,1,2};
	printf("%d\n", only1or2(a,4));

	int b[] = {2,3,4,5,6};
        printf("%d\n", only1or2(b,5));

	int c[] = {1,1};
        printf("%d\n", only1or2(c,2));

	return 1;
}
