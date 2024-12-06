package MazeProblems;

//this is one of the major example of backtracking on how the function call changes as if it never visited the path

import java.util.Arrays;

public class AllPath {
    public static void main(String[] args) {
        boolean[][] board={{true,true,true},
                {true,true,true},
                {true,true,true}};
//        allpath("",board,0,0);
        int[][] path=new int[board.length][board[0].length];
        allpathstep("",board,0,0,path,1);
    }
    static void allpath(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        // I am considering this block in my path

        maze[r][c]=false;

        if(r<maze.length-1) {
            allpath(p + "D",maze, r + 1, c);
        }
        if(c<maze[0].length-1) {
            allpath(p + "R",maze, r, c + 1);
        }
        if(r>0){
            allpath(p+"U",maze,r-1,c);
        }
        if (c > 0) {
            allpath(p+"L",maze,r,c-1);
        }

        //this is the line where the function will be over
        // so before the function gets removed, we need to remove the changes made by that function

        maze[r][c]=true;
    }
    static void allpathstep(String p,boolean[][] maze,int r,int c,int[][] path,int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c]=step;
            for(int[] arr: path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }

        // I am considering this block in my path

        maze[r][c]=false;
        path[r][c]=step;
        if(r<maze.length-1) {
            allpathstep(p + "D",maze, r + 1, c,path,step+1);
        }
        if(c<maze[0].length-1) {
            allpathstep(p + "R",maze, r, c + 1,path,step+1);
        }
        if(r>0){
            allpathstep(p+"U",maze,r-1,c,path,step+1);
        }
        if (c > 0) {
            allpathstep(p+"L",maze,r,c-1,path,step+1);
        }

        //this is the line where the function will be over
        // so before the function gets removed, we need to remove the changes made by that function

        maze[r][c]=true;
        path[r][c]=0;
    }
}
