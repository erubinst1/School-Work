#include <stdio.h>

#define NROWS 5
#define NCOLS 4

void filterStudents(int students[NROWS][NCOLS], int minAge, int minYear, int minGrade);

int main(){
	int students[NROWS][NCOLS];

	//student ids, 1-5
	for(int i = 0; i < NROWS; i++){
		students[i][0] = i+1;
	}

	//student age, 14-18
	for(int i = 0; i < NROWS; i++){
		students[i][1] = i+14;
	}

	//student year, 9-12
	for(int i = 0; i < NROWS-1; i++){
		students[i][2] = i+9;
	}
	students[4][2] = 12;

	//student grade, 60-100
	for(int i = 0; i < NROWS; i++){
		students[i][3] = i*10+60;
	}

	int filterAge, filterYear, filterGrade;

	printf("Enter the minimum age of students to filter (-1 to ignore): ");
	scanf("%d", &filterAge);
	printf("Enter the minimum year of students to filter (-1 to ignore): ");
	scanf("%d", &filterYear);
	printf("Enter the minimum grade of students to filter (-1 to ignore): ");
	scanf("%d", &filterGrade);

	filterStudents(students, filterAge, filterYear, filterGrade);

	return 0;
}

void filterStudents(int students[NROWS][NCOLS], int minAge, int minYear, int minGrade){
	int booleanFlag[NROWS][NCOLS];

	//using booleanFlag to keep track of matches when filtering
	for(int i = 0; i < NROWS; i++){
		booleanFlag[i][0] = students[i][0];
	}

	//fill with 0 to indicate all false to begin with
	for(int i = 0; i < NROWS; i++){
		for(int j = 1; j < NCOLS; j++){
			booleanFlag[i][j] = 0;
		}
	}
	
	//filtering
	//if filter is not ignored, compare and set booleanFlag to 1 if true
	//if filter is ignored, set all corresponding boolean flags to 1;
	if(minAge != -1){
		for(int i = 0; i < NROWS; i++){
			if(students[i][1] >= minAge){
				booleanFlag[i][1] = 1;
			}
		}
	}
	else{
		for(int i = 0; i < NROWS; i++){
			booleanFlag[i][1] = 1;
		}
	}

	if(minYear != -1){
		for(int i = 0; i < NROWS; i++){
			if(students[i][2] >= minYear){
				booleanFlag[i][2] = 1;
			}
		}
	}
	else{
		for(int i = 0; i < NROWS; i++){
			booleanFlag[i][2] = 1;
		}
	}

	if(minGrade != -1){
		for(int i = 0; i < NROWS; i++){
			if(students[i][3] >= minAge){
				booleanFlag[i][3] = 1;
			}
		}
	}
	else{
		for(int i = 0; i < NROWS; i++){
			booleanFlag[i][3] = 1;
		}
	}
	
	printf("Students that match the given criteria: \n");
	for(int i = 0; i < NROWS; i++){
		int studentBoolean = 1;
		for(int j = 1; j < NCOLS; j++){
			if(!booleanFlag[i][j]){
				studentBoolean = 0;
			}
		}
		if(studentBoolean){
			printf("%d\n", booleanFlag[i][0]);
		}
	}
}
