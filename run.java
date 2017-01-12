package src;

import java.util.Scanner;

public class run {
	public static void main(String [ ] args)
	{
		DiGraphAdj matrix =  new DiGraphAdj(5);
		DiGraphAdjList list = new DiGraphAdjList(5);
		
		String type;
		System.out.println("Please select the type of graph you wish to use \n"
							+ "Enter 'M' to use an adjacency matrix \n"
							+ "Enter 'L' to use an adjacency list \n"
							+ "Your command:  ");
		
		Scanner s = new Scanner(System.in);
		type = s.next().trim().toLowerCase();
		String option;
		
		System.out.println("Hello! Please choose from the following options \n"
				+ " - Press A to add an edge to your tree \n"
				+ " - Press E to return the number of edges in your grpah \n"
				+ " - Press T to search for an edge in you graph \n"
				+ " - Press S to get a list of a given nodes successors \n"
				+ " - Press P to get a list of a given nodes predecessors \n"
				+ " - Press Q to Quit \n");
		
		if(type.equals("m")){
			do{
				System.out.println("Your command: ");
		   		option = s.next().trim().toUpperCase(); 
		   		switch(option){
		   		case "A": System.out.println("Please enter a value for the source node:");
		   				  int source = s.nextInt();
		   				  System.out.println("Next enter a value for the destination node: ");
		   				  int dest = s.nextInt();
		   				  matrix.addEdge(source, dest);
		   				  break;
		   		case "E": System.out.println("This graph has: " + matrix.nEdges() + " edges");
		   				  break;
		   		case "T": System.out.println("Please enter a value for the source node:");
 				  		  source = s.nextInt();
 				  		  System.out.println("Next enter a value for the destination node: ");
 				  		  dest = s.nextInt();
 				  		  if(matrix.isEdge(source, dest)){
 				  			System.out.println("This edge exists!");
 				  		  }
 				  		  else{
 				  			  System.out.println("This edges does not exist.");
 				  		  }
 				  		  break;
		   		case "S": System.out.println("Please enter a value for the source node:");
		  		  		  source = s.nextInt();
		  		  		  System.out.println("This node has: " + matrix.successors(source) + " as successors" );
		  		  		  break;
		   		case "P": System.out.println("Please enter a value for the source node:");
		  		  		  source = s.nextInt();
		  		  		  System.out.println("This node has: " +  matrix.predecessors(source) + " as predecessors" );
		  		  		  break;
		   		case "Q": System.out.println("Goodbye!"); 
		   			      break;
		   		default:  System.out.println("Please enter a valid command");
		   				  break;
		   		}
			}
			while(!option.equals("Q"));
			
		}
		else if(type.equals("l")){		
			do{
				System.out.println("Your command: ");
		   		option = s.next().trim().toUpperCase(); 
		   		switch(option){
		   		case "A": System.out.println("Please enter a value for the source node:");
		 				  int source = s.nextInt();
		 				  System.out.println("Next enter a value for the destination node: ");
		 				  int dest = s.nextInt();
		 				  list.addEdge(source, dest);
		 				  break;
		 		case "E": System.out.println("This graph has: " + list.nEdges() + " edges");
		 				  break;
		 		case "T": System.out.println("Please enter a value for the source node:");
				  		  source = s.nextInt();
				  		  System.out.println("Next enter a value for the destination node: ");
				  		  dest = s.nextInt();
				  		  if(list.isEdge(source, dest)){
 				  			System.out.println("This edge exists!");
 				  		  }
 				  		  else{
 				  			  System.out.println("This edges does not exist.");
 				  		  }
				  		  break;
		 		case "S": System.out.println("Please enter a value for the source node:");
				  		  source = s.nextInt();
				  		  System.out.println("This node has: " + list.successors(source) + " as successors" );
				  		  break;
		 		case "P": System.out.println("Please enter a value for the source node:");
				  		  source = s.nextInt();
				  		  System.out.println("This node has: " +  list.predecessors(source) + " as predecessors" );
				  		  break;
		 		case "Q": System.out.println("Goodbye!"); 
		 			      break;
		 		default:  System.out.println("Please enter a valid command");
		 				  break;
		   		}
			}
			while(!option.equals("Q"));	
		}
		else{
			System.out.println("Please enter a valid option");
		}
		
	}
}
