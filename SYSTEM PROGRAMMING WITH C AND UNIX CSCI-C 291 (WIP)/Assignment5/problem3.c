#include <stdio.h>
#include <ctype.h>

#define ARRAY_SIZE 101

int charFreq(char arr[], char check);

int main(){
	char inArr[ARRAY_SIZE];

	printf("Enter a string no longer than 100 characters: \n");
	while (scanf("%100[^\n]", inArr) != 1) {
		int c;
		while ((c = getchar()) != '\n') {}
		printf("Invalid input: Enter a string no longer than 100 characters: \n");
	}

	char checked[256] = {'\0'};
	int checkedIdx = 0;

	for (size_t i = 0; i < ARRAY_SIZE && inArr[i] != '\0'; i++) {
		int inFlag = 0;

		for (size_t j = 0; j < (size_t)checkedIdx; j++) {
			if (tolower((unsigned char)inArr[i]) == tolower((unsigned char)checked[j])) {
				inFlag = 1;
				break;
			}
		}

		if (!inFlag) {
			checked[checkedIdx++] = inArr[i];
			checked[checkedIdx] = '\0';
		}
	}

	for (char c = 'A'; c <= 'Z'; c++) {
		int count = charFreq(inArr, c);
		if (count > 0) {
			printf("%c: %d\n", c, count);
		}
	}

	int spaceCount = charFreq(inArr, ' ');
	if (spaceCount > 0) {
		printf("(space): %d\n", spaceCount);
	}

	return 1;
}

int charFreq(char arr[], char check){
	int counter = 0;

	for (size_t i = 0; i < ARRAY_SIZE && arr[i] != '\0'; i++) {
		if (tolower((unsigned char)arr[i]) == tolower((unsigned char)check)) {
			counter++;
		}                                                                                                                                                                                                            }                                                                                                                                                                                                                return counter;                                                                                                                                                                                              }
