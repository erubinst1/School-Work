#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Minesweeper!
// Uses a 5x5 board. A char array stores the player's visible grid, and an int array tracks mine locations.
// The player enters a row and column to reveal a cell. If it contains a mine, they lose. If not, the cell
// shows how many mines are adjacent to it (up to 8 possible surrounding cells).
// The player continues revealing cells until they hit a mine or successfully uncover all safe spaces.
// Mines are randomly placed at the start of each game, so each round is different.

#define SIZE 5
#define MINES 5

int checkCell(int mines[SIZE][SIZE], int row, int col);

int main() {
	int mines[SIZE][SIZE] = {0};
	char board[SIZE][SIZE];
	int revealedSafe = 0;
	int totalSafe = SIZE * SIZE - MINES;
	int gameOver = 0;

	srand(time(NULL));

	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			board[i][j] = '#';
		}
	}

	int placed = 0;
	while (placed < MINES) {
		int r = rand() % SIZE;
		int c = rand() % SIZE;
		if (mines[r][c] == 0) {
			mines[r][c] = 1;
			placed++;
		}
	}

	printf("Welcome to Minesweeper!\n");
	printf("Enter coordinates on a 5x5 grid (row and column from 0–4) to reveal a cell.\n\n");

	while (!gameOver) {
		printf("\nCurrent Board:\n");
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				printf("%c ", board[i][j]);
			}
			printf("\n");
		}

		int r, c;
		printf("\nEnter row and column: ");
		scanf("%d %d", &r, &c);

		if (r < 0 || r >= SIZE || c < 0 || c >= SIZE) {
			printf("Invalid coordinates. Try again.\n");
			continue;
		}

		if (board[r][c] != '#') {
			printf("Already revealed.\n");
			continue;
		}

		if (mines[r][c] == 1) {
			printf("\nYou hit a mine! Game over.\n");
			gameOver = 1;
			break;
		} 
		else{
			int count = checkCell(mines, r, c);
			board[r][c] = '0' + count;
			revealedSafe++;
			if (revealedSafe == totalSafe) {
				printf("\nCongratulations! You cleared all safe spots!\n");
				gameOver = 1;
				break;
			}
		}
	}

	printf("\nFinal Mine Map:\n");
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			if (mines[i][j])
				printf("M ");
			else
				printf(". ");
		}
		printf("\n");
	}

	return 0;
}

int checkCell(int mines[SIZE][SIZE], int row, int col) {
	int count = 0;
	for (int i = row - 1; i <= row + 1; i++) {
		for (int j = col - 1; j <= col + 1; j++) {
			if (i >= 0 && i < SIZE && j >= 0 && j < SIZE) {
				if (mines[i][j] == 1)
					count++;
			}
		}
	}
	return count;
}
