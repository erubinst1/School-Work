#include <stdio.h>

void swap_grades(int* a, int* b);

int main(){
	int a, b;

	printf("Enter grade 1: ");
	scanf("%d", &a);

	printf("Enter grade 2: ");
        scanf("%d", &b);

	printf("Before swap: grade 1 = %d, grade 2 = %d\n", a, b);
	swap_grades(&a, &b);
	printf("After swap: grade 1 = %d, grade 2 = %d\n", a, b);

	return 0;
}

void swap_grades(int* a, int* b){
	*a = *a + *b;
	*b = *a - *b;
	*a = *a - *b;

	//this function requires pointers rather than ints due to how pointers vs ints are passed
	//ints are passed by value, so a copy of the value would be passed to the function. Since the value is a copy, we would not be able to affect the value of the int itself
	//Pointers, however, pass by referece, so they point to the same value in memory even when called in a function. This allows us to change the value of the variables themselves and have it persist outside of the function.	
}
