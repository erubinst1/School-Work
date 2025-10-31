#include <stdio.h>

int Tax1(int income);
int Tax2(int income);
int Tax3(int income);

int main(){
	int in;
	

	printf("Enter your income: ");
	scanf("%d", &in);

	int (*t1)(int) = Tax1;
        int (*t2)(int) = Tax2;
        int (*t3)(int) = Tax3;

	int rate1 = 0, rate2 = 0, rate3 = 0, total = 0;
	
	if(in > 80000){
                rate3 = in - 80000;
		total += t3(rate3);
        }
	if(in > 20000){
		rate1 = 20000;
		rate2 = in - rate1 - rate3;
		total += t1(rate1);
		total += t2(rate2);
	}
	else{
		rate1 = in;
		total += t1(rate1);
	}
	
	printf("Total taxes owed: %d\n", total);

	return 1;
}

int Tax1(int income){
	return 0.1 * income;
}

int Tax2(int income){
	return 0.25 * income;
}

int Tax3(int income){
	return 0.4 * income;
}


