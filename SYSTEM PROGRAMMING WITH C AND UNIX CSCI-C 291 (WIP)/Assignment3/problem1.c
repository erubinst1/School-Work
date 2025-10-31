#include <stdio.h>

int main () {
	char in, vacation, married;
	//default days, weeks, months for calculations. Defaulting variables to -1 to check validity
	int days = 240, weeks = 48, month = 12, salary = -1, ot = -1, sold = -1;
	float gross = -1, taxed = -1;
	
	//check invalid input in switch case
	printf("Input employee type: \n");
	in = getchar();

	//Switch case to check all possible employee types and following calculations
	switch(in){
		case 'A':
			printf("Input monthly salary: \n");
			scanf("%d", &salary);
			if( salary < 0 ){
				printf("Invalid salary");
			}
			
			gross = salary * month;	

			printf("Enter y if you are married, n otherwise: ");
			scanf(" %c", &married);
			if( married != 'y' && married != 'n'){
				printf("Invalid marrige input");
			}

			break;
		case 'S':
			printf("Input monthly salary: \n");
			scanf("%d", &salary);
			if( salary < 0 ){
				printf("Invalid salary");
			}

			printf("Input overtime hours: \n");
			scanf("%d", &ot);
			if( ot < 0 ){
				printf("Invalid overtime input");
			}

			gross = salary * month;

			if(ot > 10){
				gross = gross + month * 10 * 1.5 * salary/20/8;
			}
			else{
				gross = gross + month * ot * 1.5 * salary/20/8;
			}

			printf("Enter y if you are married, n otherwise: \n");
			getchar();
			scanf("%c", &married);
			if( married != 'y' && married != 'n'){
				printf("Invalid marrige input");
			}

			break;
		case 'E':
			printf("Input monthly salary: \n");
			scanf("%d", &salary);
			if( salary < 0 ){
				printf("Invalid salary");
			}

			printf("Input overtime hours per day: \n");
			scanf("%d", &ot);
			if( ot < 0 ){
				printf("Invalid overtime hours");
			}

			printf("Enter y if you took a vacation this year, n otherwise: \n");
			scanf(" %c", &vacation);
			if( vacation != 'y' && vacation != 'n'){
				printf("Invalid vacation input");
			}

			printf("Input products sold: \n");
			scanf("%d", &sold);
			if( sold < 0 ){
				printf("Invalid products sold input");
			}

			gross = salary * month;

			if(ot > days){
				gross = gross + days * 1.35 * salary/20;
			}
			else{
				gross = gross + ot * 1.35 * salary/20;
			}

			if(vacation == 121){
				gross -= salary / 2;
			}

			if(sold > 0){
				gross += sold * 600;
			}

			printf("Enter y if you are married, n otherwise: \n");
			scanf(" %c", &married);
			if( married != 'y' && married != 'n'){
				printf("Invalid married input");	
			}

			break;
		case 'P':
			printf("Input weekly salary: \n");
			scanf("%d", &salary);
			if( salary < 0 ){
				printf("Invalid salary input");
			}

			printf("Input overtime hours each week: \n");
			scanf("%d", &ot);
			if( ot < 0 ){
				printf("Invalid overtime input");
			}

			printf("Input products sold: \n");
			scanf("%d", &sold);
			if( sold < 0 ){
				printf("Invalid products sold input");
			}

			gross = salary * weeks;

			if(ot > 10 ){
				gross = gross + weeks * 10 * (salary/40.0);
			}
			else{
				gross = gross + weeks * ot * (salary/40.0);
			}

			if(sold > 0){
				gross = gross + sold * 600;
			}

			printf("Enter y if you are married, n otherwise: \n");
			scanf(" %c", &married);
			if( married != 'y' && married != 'n' ){
				printf("Invalid married input");
			}

			break;
		case 'H':
			printf("Input hourly salary: \n");
			scanf("%d", &salary);
			if( salary < 0 ){
				printf("Invalid salary input");
			}

			printf("Input total hours each week: \n");
			scanf("%d", &ot);
			if( ot < 0 ){
				printf("Invalid overtime input");
			}

			if(ot > 20){
				gross = (salary * 10 * weeks) + (salary * 10 * 1.25 * weeks); 
			}
			else if (ot > 10) {
				gross = (salary * 10 * weeks) + (salary * (ot - 10) * 1.25 * weeks);
			}
			else{
				gross = salary * ot * weeks;
			}

			printf("Enter y if you are married, n otherwise: \n");
			scanf(" %c", &married);
			if( married != 'y' && married != 'n' ){
				printf("Invalid marrige inpu");
			}

			break;
			//default case for invalid inputs
		default:
			printf("Invalid input");
	}

	//Married calculation
	if(married == 121){
		if(gross > 32000){
			taxed = gross * 0.75;
		}
		else{
			taxed = gross * 0.9;
		}
	}
	else{
		if(gross > 64000){
			taxed = gross * 0.75;
		}
		else{
			taxed = gross * 0.9;
		}
	}
	
	//Final Print
	printf("This employee's annual income is %.2f before tax and %.2f after tax.\n", gross, taxed);

	return 0;
}
