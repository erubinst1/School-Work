#include <stdio.h>

int shareDigit(int num1, int num2){
	int sum = 0;
	if(num1%10 == num2%10){
		sum += 1;
	}
	if(num1/10 == num2/10){
                sum += 1;
        }
	if(num1%10 == num2/10){
		sum += 1;
	}
	if(num1/10 == num2%10){
                sum += 1;
        }

	return sum;
}

int main(){
	printf("%d\n", shareDigit(24, 56));
	printf("%d\n", shareDigit(24, 46));
	printf("%d\n", shareDigit(24, 64));
	printf("%d\n", shareDigit(24, 24));

	return 1;
}
