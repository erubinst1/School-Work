#include <stdio.h>

int main(){
	int temp;

	printf("Enter the temperature in Celsius: ");
	scanf("%d", &temp);

	if(temp < -10){
		printf("Freezing\n");
	}
	else if(temp < 10){
		printf("Cold\n");
	}
	else if(temp < 25){
		printf("Moderate\n");
	}
	else{
		printf("Hot\n");
	}
	
	return 0;
}
