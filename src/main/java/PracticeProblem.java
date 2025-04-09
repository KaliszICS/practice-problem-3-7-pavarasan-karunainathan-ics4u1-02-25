public class PracticeProblem{
        static String[][] maze;
        static int search(int row, int col){
                if(maze[row][col].equals("F")){
                        return 0;
                }

                int min = 999999999;
                maze[row][col] = "*";
                for(int i = -1; i < 2; ++i)
                        for(int j = -1; j < 2; ++j)
                                if(i == 0 ^ j == 0)
                                        if(row+i > -1 && row+i < maze.length && col+j > -1 && col+j < maze[row].length && !maze[row+i][col+j].equals("*")){
                                                int candidate = search(row+i, col+j);
                                                min = candidate < min ? candidate : min;
                                        }
                maze[row][col] = "";
                return min+1;
        }

        static int searchMazeMoves(String[][] arr){
                maze = arr;
                int min = search(arr.length-1, 0);
                if(min > 999999999) return -1;
                else return min;
        }

        public static void main(String args[]){}
}
