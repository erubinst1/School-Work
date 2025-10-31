#include <stdio.h>

int compareNumbers(int num1, int num2, int num3){
	if(num1 == num2 && num2 == num3){
		return 20;
	}
	if(num1 == num2 || num1 == num3 || num2 == num3){
		return 10;
	}
	return 0;
}

int main(){
	printf("%d\n", compareNumbers(10,20,30));
	printf("%d\n",compareNumbers(20,20,30));
	printf("%d\n",compareNumbers(10,10,10));

	return 1;
}
