#include <stdio.h>

int main(){
	int day, month, year, bYear, age;

	printf("Enter the current day: ");
	scanf("%d", &day);
	printf("Enter the current month: ");
        scanf("%d", &month);
	printf("Enter the current year: ");
        scanf("%d", &year);
	printf("Enter your birth year: ");
        scanf("%d", &bYear);

	age = year - bYear;

	printf("Today is %d/%d/%d, and you are %d years old \n", day, month, year, age);

	return 0;

}
