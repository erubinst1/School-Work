#include <stdio.h>

void countVowelsConsonants(char *str, int *vowels, int *consonants){
	for(int i = 0; str[i] != '\0'; i++){
		if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u' || str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U'){
			(*vowels)++;
		}
		else if((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z')){
			(*consonants)++;
		}
	}
}

int main(){
	char in[101];
	int vowels = 0, consonants = 0;

	printf("Enter a string of 100 max chars: ");
	scanf("%100s", in);

	countVowelsConsonants(in, &vowels, &consonants);

	printf("The input string has %d vowel(s) and %d consonant(s).\n", vowels, consonants);

	return 1;
}
