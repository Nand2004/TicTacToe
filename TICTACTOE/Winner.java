package FinalProject;

public class Winner
{
    public static char won(char[][] board) {
        for (int r = 0; r < 3; r++) {
            //Checking for winning of rows.
            if (board[r][0] == board[r][1] && board[r][1] == board[r][2] && board[r][0] != '-') {
                return board[r][0];
            }

            for (int c = 0; c < 3; c++) {
                //columns
                if (board[0][c] == board[1][c] && board[1][c] == board[2][c] && board[0][c] != '-') {
                    return board[0][c];
                }
            }

            //Diagonal wins
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
                return board[1][1];
            }

            //Diagonal wins
            if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
                return board[1][1];
            }
            //NOBODY Won.
        }
        return '-';
    }

    public static boolean tie(char[][] board)
    {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '-') {
                   return false;
                }
            }
        }
        return true;
    }
}


