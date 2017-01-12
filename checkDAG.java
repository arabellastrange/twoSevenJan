package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class checkDAG {

	// instance variables - do not alter
    private DiGraphADT g;
    private int n;
    
    /**
     * Constructor for objects of class Topological - do not alter except
     * that you may wish to replace the instance of DiGraphEdgeList with an 
     * instance of a different implementation of DiGraphADT
     */
    public checkDAG()
    {
        // initialise instance variables
        n = 10;   // example graph used here has 10 nodes
        g = new DiGraphEdgeList(n);
        try {
            readGraph();
        }
        catch (Exception e){
            System.out.println("Invalid file content");
        }
    }

    /**
    * populates the graph taking data from file Edges.txt - do not alter
    */
    private void readGraph() throws Exception 
    {
        int firstNode, secNode;
        Reader r = new BufferedReader(new FileReader("edges2"));
        StreamTokenizer st = new StreamTokenizer(r);
        st.parseNumbers();
        st.nextToken();
        while (st.ttype != StreamTokenizer.TT_EOF) {
          firstNode = (int) st.nval;
          st.nextToken();
          secNode = (int) st.nval;
          System.out.println(firstNode + " " + secNode);
          g.addEdge(firstNode,secNode);
          st.nextToken();
        }
    }

    public void topologicalOrder(){
    	ArrayList<Integer> nodeInDeg = new ArrayList<Integer>();
    	Queue<Integer> zeroDeg = new LinkedList<Integer>();
    	ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
    	
    	for(int i = 0; i < g.nNodes(); i++){
    		nodeInDeg.add(g.inDegree(i));
    		if(nodeInDeg.get(i) == 0){
    			zeroDeg.add(i);
    			visitedNodes.add(i);
    		}
    	}
    	while(!zeroDeg.isEmpty()){
    		int current = zeroDeg.poll();
    		ArrayList<Integer> su = g.successors(current);
    		for(int m = 0; m < su.size(); m++){
    			nodeInDeg.set(su.get(m), nodeInDeg.get(su.get(m)) - 1); 
    			if(nodeInDeg.get(su.get(m)) == 0){
    				zeroDeg.add(su.get(m));
    				visitedNodes.add(su.get(m));
        		}
    		} 
    	}
    	
    	if(visitedNodes.size() <  nodeInDeg.size()){
    		System.out.println("This graph contains a cycle");
    	}
    	else{
    		System.out.println("This graph is acyclic");
    	}
    }
 
    public static void main(String[] args)
    {
    	checkDAG gr = new checkDAG();
        gr.topologicalOrder();
    }
}
