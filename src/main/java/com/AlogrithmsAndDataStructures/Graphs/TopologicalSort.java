package com.AlogrithmsAndDataStructures.Graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static int updatePosition;
    public static void main(String[] args) {
        int[][] edgeListGraph1 = GetGraphUtil.getEdgeListGraph1();
        Map<Integer, List<Integer>> adjacencyListGraph1 = GetGraphUtil.convertEdgeListToAdjacencyList(edgeListGraph1, true);
        int nodeCountGraph1 = GetGraphUtil.getNodeCountGraph1();
        boolean[] isVisited  = new boolean[nodeCountGraph1];
        int[] path = new int[nodeCountGraph1];
        updatePosition = nodeCountGraph1 - 1;
        getTopologicalSort(adjacencyListGraph1, isVisited, path);
        Arrays.stream(path).forEach(System.out::println);


    }

    private static void getTopologicalSort(Map<Integer, List<Integer>> adjacencyListGraph1, boolean[] isVisited, int[] path) {
        for(Integer node :  adjacencyListGraph1.keySet()) {
            updatePath(node, adjacencyListGraph1, isVisited, path);
        }
    }

    private static void updatePath(Integer node, Map<Integer, List<Integer>> adjacencyListGraph1, boolean[] isVisited, int[] path) {
        if(!isVisited[node]) {
            if(adjacencyListGraph1.get(node) != null) {
                for (Integer neighbour : adjacencyListGraph1.get(node)) {
                    updatePath(neighbour, adjacencyListGraph1, isVisited, path);
                }
            }
             isVisited[node] = true;
             path[updatePosition] = node;
             updatePosition--;
        }
    }
}
