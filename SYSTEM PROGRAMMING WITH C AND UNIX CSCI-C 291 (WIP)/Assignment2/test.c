#include <stdio.h>

int main(){
	int a = 10, b = 4, c = 13;
	
	int z = (a++) * (--c) + (b++ * ++b);

	printf("%d", z);
	
	return 0;
}
