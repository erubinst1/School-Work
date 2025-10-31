#include <stdio.h>

int main(){
	int year;

	printf("Enter the year: ");
	scanf("%d", &year);

	if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
		printf("The year %d is a leap year\n", year);
	}
	else{
		printf("The year %d is not a leap year\n", year);
	}

	return 0;
}
	
