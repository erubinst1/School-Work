#include <stdio.h>

void printUnique(int a[], int n){
	 if(n <= 0){
                printf("\n");
                return;
        }

        int write = 0;

        for(int i = 1; i < n; i++){
                if(a[i] != a[write]){
                        write++;
                        a[write] = a[i];
                }
        }

        printf("Output: ");

        for(int i = 0; i <= write; i++){
                printf("%d", a[i]);
        }

        printf("\n");
}

int main(){
	int a[] = {1,2,2,3};
	printUnique(a, 4);

	int b[] = {1,1,2,2,3,3};
	printUnique(b, 6);

	return 1;
}
