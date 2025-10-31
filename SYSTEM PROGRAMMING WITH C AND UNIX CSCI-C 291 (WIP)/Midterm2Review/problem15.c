#include <stdio.h>

int main(){
	int in1, in2;

	printf("Enter the first integer: ");
	scanf("%d", &in1);
	printf("Enter the second integer: ");
        scanf("%d", &in2);

	float total;
	total = (float) in1 / (float) in2;
	
	printf("Floating point integer result: %.2f.\n", total);

	return 1;
}
