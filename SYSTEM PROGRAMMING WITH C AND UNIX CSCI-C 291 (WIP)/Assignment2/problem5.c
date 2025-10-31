//importing standard input output library
#include <stdio.h>
//define the PI constant
#define PI 3.14

//main method
int main(){
	//Define radius
	double radius;
	
	//Printing the radius message
	printf("Enter the radius: ");
	//scanning radius from the input
	scanf("%lf", &radius);
	
	//calculating and printing the diameter
	printf("The diameter of a circle with a radius of %lf is %lf.\n", radius, 2 * radius);
	//calculating and printing the area
	printf("The area of a circle with a radius of %lf is %lf.\n", radius, 2 * PI * radius);
	//calculating and printing the circumference
	printf("The circumference of a circle with a radius of %lf is %lf.\n", radius, PI * radius * radius);
	
	//returning 0 to end the function
	return 0;
}
