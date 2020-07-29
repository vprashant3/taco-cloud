package com.AlogrithmsAndDataStructures.Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DFS {

    public static void main(String[] args) {
        int[][] edgeList =  GetGraphUtil.getEdgeListGraph1();
        int numOfNodes = GetGraphUtil.getNodeCountGraph1();
        boolean[] isNodeVisited =  new boolean[numOfNodes];

        Map<Integer, List<Integer>> adjacencyList = GetGraphUtil.convertEdgeListToAdjacencyList(edgeList, false);

        dfsTraversalGraphs(adjacencyList, isNodeVisited);

    }

    public static void dfsTraversalGraphs(Map<Integer, List<Integer>> adjacencyList, boolean[] isNodeVisited) {
        for(Integer node :  adjacencyList.keySet()) {
            dfs(node,isNodeVisited, adjacencyList);
        }
    }
    private static void dfs(Integer node, boolean[] isNodeVisited, Map<Integer, List<Integer>> adjacencyList) {
        if(isNodeVisited[node]) return;
        System.out.println("at Node : "+node);
        isNodeVisited[node] = true;
        List<Integer> list = adjacencyList.get(node) != null ? adjacencyList.get(node) : new LinkedList<>();
        for (Integer neighbour : list) {
            dfs(neighbour, isNodeVisited, adjacencyList);
        }
    }
}
