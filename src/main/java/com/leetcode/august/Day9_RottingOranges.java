package com.leetcode.august;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Day9_RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new Day9_RottingOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int timer = 0;
        Queue<Location> rottenFruitsLocations =  new LinkedList<>();
        Queue<Location> freshFruitsLocations =  new LinkedList<>();

        for(int i = 0; i < grid.length;  i++) {
            for(int j = 0;  j < grid[i].length; j++) {
                if(grid[i][j] == 1) freshFruitsLocations.add(new Location(i, j));
                if(grid[i][j] == 2) rottenFruitsLocations.add(new Location(i,j));
            }
        }

        if(freshFruitsLocations.size() == 0) return 0;
        if(rottenFruitsLocations.size() == 0) return -1;

        while(rottenFruitsLocations.size() > 0) {
            int numOfRottenFruits = rottenFruitsLocations.size();
            for(int i = 0; i < numOfRottenFruits; i++) {
                Location curRottenFruit = rottenFruitsLocations.poll();
                getFreshNeighboursAndAddToRottenList(curRottenFruit, freshFruitsLocations, rottenFruitsLocations);

            }
            timer++;
        }


        return freshFruitsLocations.size() == 0 ? timer -1 :  -1;
    }

    private void getFreshNeighboursAndAddToRottenList(Location curRottenFruit, Queue<Location> freshFruitsLocations, Queue<Location> rottenFruitsLocations) {
        int[][] neighbours = { {-1,0}, {1,0}, {0,-1}, {0,1}};

        int xCoordinate = curRottenFruit.x;
        int yCoordinate = curRottenFruit.y;

        for(int i = 0; i< neighbours.length; i++) {
                Location neighbour = new Location( xCoordinate + neighbours[i][0] , yCoordinate + neighbours[i][1]);
                if(freshFruitsLocations.contains(neighbour)) {
                    freshFruitsLocations.remove(neighbour);
                    rottenFruitsLocations.add(neighbour);
                }

        }
    }


    class Location{
        int x, y;

        Location(int x,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x &&
                    y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
