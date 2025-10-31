#include <stdio.h>

int main (){
	//loops over a + whole alphabet and prints them concatenated, then increments to b + whole aphabet, etc.	
	for(int i = 'a'; i < 'a' + 26; i++){
		for(int j = 'a'; j < 'a' + 26; j++){
			printf("www.%c%c.com\n", i, j);
		}
	}

	return 0;
}
