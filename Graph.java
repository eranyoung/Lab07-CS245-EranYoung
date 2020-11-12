public class Graph{
	
	private int [][] adjacencyMatrix;
	private int [] incidents;
	private int vertices;

	public Graph(int vertices){
		this.vertices = vertices;
		adjacencyMatrix  = new int[vertices][vertices];
	}

	public void addEdge(int v1, int v2){
		adjacencyMatrix[v1-1][v2-1] = 1;
	}

	public int[] incident(int vertices){
		incidents = new int[vertices];
		for(int v = 0; v < vertices; v ++){
			for(int w = 0; w < vertices; w ++){
				incidents[v] = incidents[v] + adjacencyMatrix[w][v];
			}
		}
		//print3D(this.adjacencyMatrix);
		//print2D(this.incidents);
		return incidents;
	}

	public boolean hasMaxIncidents(int vertice){
		if(incidents[vertice] == this.vertices - 1){
			return true;
		}
		return false;
	}

	public boolean checkEdges(int vertice){
		for(int r = 0; r < vertices; r ++){
			if(adjacencyMatrix[r][vertice] == 0 && r != vertice){
				return false;
			}
		}
		return true;
	}

	public void print2D(int [] array){
		System.out.println("2D Array ");
		for(int i = 0; i < array.length ; i ++)
			System.out.print(array[i]);
		System.out.println();
	}

	public void print3D(int [][] array){
		System.out.println("3D Array ");
		for(int r = 0; r < array.length; r++){
			for(int c = 0; c < array[0].length; c++){
				System.out.print(array[r][c]);
			}
			System.out.println();
		}
	}
}