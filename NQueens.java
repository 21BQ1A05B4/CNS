import java.util.Scanner;

public class NQueens {
    static int N; // Size of the chessboard

    // Function to check if a queen can be placed at board[row][col]
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive function to solve N Queens problem
    static boolean solveNQueensUtil(int board[][], int col) {
        // All queens are placed
        if (col >= N)
            return true;

        // Consider this column and try placing a queen in all rows one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                // Place this queen in board[i][col]
                board[i][col] = 1;

                // Recur to place rest of the queens
                if (solveNQueensUtil(board, col + 1))
                    return true;

                // If placing queen in board[i][col] doesn't lead to a solution, then remove queen from board[i][col]
                board[i][col] = 0;
            }
        }

        // If queen can not be placed in any row in this column col, then return false
        return false;
    }

    // Prints the solution
    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    // Wrapper function to solve N Queens problem
    static void solveNQueens() {
        int board[][] = new int[N][N];

        if (!solveNQueensUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return;
        }

        printSolution(board);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (N): ");
        N = input.nextInt();
        solveNQueens();
    }
}
