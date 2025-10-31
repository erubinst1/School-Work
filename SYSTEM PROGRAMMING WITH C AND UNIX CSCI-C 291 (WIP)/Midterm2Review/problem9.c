#include <stdio.h>

int main(){
	int a, b, c;

	printf("Enter the first angle: ");
	scanf("%d", &a);
	printf("Enter the second angle: ");
        scanf("%d", &b);
	printf("Enter the third angle: ");
        scanf("%d", &c);

	if(a+b+c != 180){
		printf("The numbers do not form a valid triangle.\n");
	}
	else{
		printf("The numbers form a valid triangle.\n");
	}

	return 1;
}
