package com.AlogrithmsAndDataStructures.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GetGraphUtil {

    public static int[][] getEdgeListGraph1() {
        int[][] edgeList = new int[8][2];
        edgeList[0] = new int[] {1,2};
        edgeList[1] =  new int[]{2,3};
        edgeList[2] = new int[] {3,4};
        edgeList[3] =  new int[] {2,6};
        edgeList[4] = new int[] {3,6};
        edgeList[5] =  new int[] {6,5};
        edgeList[6] =  new int[] {6,7};
        edgeList[7] =  new int[] {5,7};
        return edgeList;
    }

    public static int getNodeCountGraph1() {
        return 7;
    }

    public static Map<Integer, List<Integer>> convertEdgeListToAdjacencyList(int[][] edgeList, boolean isGraphDirectional) {
        Map<Integer,List<Integer>> adjacencyList =  new HashMap<>();
        for(int i = 0; i < edgeList.length; i++) {
            int node = edgeList[i][0];
            int neighbour = edgeList[i][1];
            addNeighbourNodes(node, neighbour, adjacencyList);
            if(!isGraphDirectional) {
                 node = edgeList[i][1];
                 neighbour = edgeList[i][0];
                addNeighbourNodes(node, neighbour, adjacencyList);
            }
        }
        return adjacencyList;
    }

    public static void addNeighbourNodes(int node, int neighbour, Map<Integer,List<Integer>> adjacencyList) {
        List<Integer> nodeNeighbourList = adjacencyList.getOrDefault(node, new LinkedList<>());
        nodeNeighbourList.add(neighbour);
        adjacencyList.put(node,nodeNeighbourList);
    }
}
