#include <stdio.h>

// returns length of string minus the null character
int my_strlen(char *str) {
	int len = 0;
	
	while(str[len] != '\0'){
		len++;
	}

	return len;
}

int main(int argc, char **argv) {
	int len = 0;
	
	printf("Length of \"");
		
	for(int i = 1; i < argc; i++){
		len += my_strlen(argv[i]);
		printf("%s", argv[i]);
		
		//adds a space between words
		if(i < argc - 1){
			len += 1;
			printf(" ");
		}
	}

	printf("\": %d\n", len);

 	return 0;
}
