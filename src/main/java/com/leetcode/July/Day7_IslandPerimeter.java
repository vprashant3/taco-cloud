package com.leetcode.July;

public class Day7_IslandPerimeter {


    // first brute force solution
    public int islandPerimeter(int[][] grid) {
        //assuming square grid
        int rows = grid.length;
        int columns =  grid[0].length;
        int perimeter = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 1) {
                    if(i-1 < 0) perimeter++;
                    else if (grid[i-1][j] == 0) perimeter++;
                    if(i+1 > rows) perimeter++;
                    else if (grid[i+1][j] == 0) perimeter++;
                    if(j-1 < 0) perimeter++;
                    else if (grid[i][j-1] == 0) perimeter++;
                    if(j+1 > columns) perimeter++;
                    else if (grid[i][j+1] == 0) perimeter++;


                }
            }
        }
        return perimeter;
    }



}
