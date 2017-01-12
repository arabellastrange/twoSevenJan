package src;

import java.util.*;

public class DiGraphAdj implements DiGraphADT {
	
	private int numNodes;
	private boolean[][] edges;
    
    public DiGraphAdj(int number){
    	numNodes = number;
    	edges = new boolean[numNodes][numNodes];
    }
	
	public int nNodes() {
		// return number of nodes
		return numNodes;
	}

	public int nEdges() {
		// return number of edges
		int count = 0;
		for(int i = 0; i < numNodes; i++){
			for(int m = 0; m < numNodes; m++){
				if (isEdge(i,m)){
					count = count + 1;
				}
			}
		}
		return count;
	}

	public boolean addEdge(int node1, int node2) {
		//if edge already exists then return false else add new edge
		if (isEdge(node1,node2)){
	          return false;
	          }
		else{ 
			edges[node1][node2] = true;
			return true;
		}
	}

	public boolean isEdge(int node1, int node2) {
		// if edge exists the return true
		return edges[node1][node2];
	}

	public ArrayList<Integer> successors(int node) {
		ArrayList<Integer> successorNodes = new ArrayList<Integer>();
		for(int i = 0; i < numNodes; i++){
			if(edges[node][i]){
				successorNodes.add(i);
			}
		}
		return successorNodes;
	}

	public ArrayList<Integer> predecessors(int node) {
		ArrayList<Integer> predecessorNodes = new ArrayList<Integer>();
		for(int i = 0; i < numNodes; i++){
			if(edges[i][node]){
				predecessorNodes.add(i);
			}
		}
		return predecessorNodes;
	}

	public int outDegree(int node) {
		return successors(node).size();
	}

	public int inDegree(int node) {
		return predecessors(node).size();
	}

}
