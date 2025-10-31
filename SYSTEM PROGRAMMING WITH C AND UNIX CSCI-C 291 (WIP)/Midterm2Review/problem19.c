#include <stdio.h>

int isPalindrome(char a[]){
	int lastIdx = 0;

	while(a[lastIdx] != '\0'){
		lastIdx++;
	}

	char reverse[lastIdx+1];
	reverse[lastIdx] = '\0';
	
	int write = 0;
	for(int i = lastIdx-1; i >= 0; i--){
		reverse[write++] = a[i];
	}

	for(int i = 0; a[i] != '\0'; i++){
		if(a[i] != reverse[i]){
			return 0;
		}
	}
	
	return 1;
}

int main(){
	char a[101];

	printf("Enter a string of at most 100 characters: ");
	scanf("%100s", a);

	if(isPalindrome(a)){
		printf("The input is a palindrome.\n");
	}
	else{
		 printf("The input isnt a palindrome.\n");
	}

	return 1;
}
