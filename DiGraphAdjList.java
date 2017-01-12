package src;

import java.util.List;
import java.util.ArrayList;

public class DiGraphAdjList implements DiGraphADT {
	
	private List<Integer>[] edges;  // edge list
	private int numNodes;  // number of nodes
	
	public DiGraphAdjList(int number){
		numNodes = number;
		edges = new List[numNodes];
		for (int i = 0; i < numNodes; i++){ //each element of the list is in itself a list
			edges[i] = new ArrayList<Integer>();
		}
	}
	
	public int nNodes() {
		return numNodes;
	}

	public int nEdges() {
		int count = 0;
		for(int i = 0; i < numNodes; i++){
			count = count + edges[i].size();
		}
		return count;
	}

	public boolean addEdge(int node1, int node2) {
		if (isEdge(node1,node2)){
	          return false;
	          }
		else{ 
			edges[node1].add(node2);
			return true;
		}
	}

	public boolean isEdge(int node1, int node2) {
		// reutrn true if the edge list for node one contains node 2
		return edges[node1].contains(node2);
	}

	public ArrayList<Integer> successors(int node) {
		ArrayList<Integer> successorNodes = new ArrayList<Integer>();
		for(int i = 0; i < edges[node].size(); i++){
			successorNodes.add(edges[node].get(i));
		}
		return successorNodes;
	}

	public ArrayList<Integer> predecessors(int node) {
		ArrayList<Integer> predecessorNodes = new ArrayList<Integer>();
		for(int i = 0; i < numNodes; i++){
			if(edges[i].contains(node)){
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
