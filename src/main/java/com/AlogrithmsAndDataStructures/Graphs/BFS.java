package com.AlogrithmsAndDataStructures.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {


    public static void main(String[] args) {
        int[][] edgeList =  GetGraphUtil.getEdgeListGraph1();
        int numOfNodes = GetGraphUtil.getNodeCountGraph1();
        boolean[] isNodeVisited =  new boolean[numOfNodes+1];
        int[] path  =  new int[numOfNodes+1];

        Map<Integer, List<Integer>> adjacencyList = GetGraphUtil.convertEdgeListToAdjacencyList(edgeList, false);
        Integer startingNode = 5;
        bfsTraversalGraphs(adjacencyList, isNodeVisited,startingNode,path);
        //Arrays.stream(path).forEach(System.out::println);
        getShortestPath(5,4, path);


    }

    private static void getShortestPath(int start, int end, int[] path) {
        int cur = end;
        while(!(path[cur] == 0)) {
            System.out.println(cur);
            cur =  path[cur];
            if(cur == start) {
                System.out.println(cur);
                System.out.println("shortest path found");
            }

        }
    }

    private static void bfsTraversalGraphs(Map<Integer, List<Integer>> adjacencyList, boolean[] isNodeVisited, Integer startingNode, int[] path) {
        Queue<Integer> queue =  new LinkedList<>();
        queue.add(startingNode);
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            if(isNodeVisited[curNode] == false) {
                List<Integer> neighbours =  adjacencyList.get(curNode);
                for(Integer neighbour : neighbours) {
                    if(!isNodeVisited[neighbour]) {
                        if(path[neighbour] == 0) path[neighbour] = curNode;
                        queue.add(neighbour);
                    }
                }
                isNodeVisited[curNode] = true;
            }
        }
    }
}
