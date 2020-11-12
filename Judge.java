public class Judge{

	public int findJudge(int n, int [][] trust){
		Graph g = new Graph(n);
		addEdges(g, n, trust);
		g.incident(n);
		for(int i = 0; i < n; i ++){
			if(g.hasMaxIncidents(i) && g.checkEdges(i))
				return i + 1;
		} 
		return -1;
	}

	public void addEdges(Graph g, int n, int [][] trust){
		if(trust[0].length != 0){
			for(int i = 0; i < trust.length; i ++){
			//System.out.println("Person: " + trust[i][0] + " trusts Person: " + trust[i][1]);
			g.addEdge(trust[i][0], trust[i][1]);
			}	
		}
	}

	public static void main(String []args){
		Judge j = new Judge();
		System.out.println("Test Cases \n\n");
		System.out.println("Test: N = 1, Trust = [[]], Judge: " + j.findJudge(1, new int[][]{{}}));
		System.out.println("Test: N = 2, Trust = [[]], Judge: " + j.findJudge(2, new int[][]{{}}));
		System.out.println("Test: N = 2, Trust = [[1,2]], Judge: " + j.findJudge(2, new int[][]{{1,2}}));
		System.out.println("Test: N = 3, Trust = [[1,3],[2,3]], Judge: " + j.findJudge(3, new int[][]{{1,3},{2,3}}));
		System.out.println("Test: N = 3, Trust = [[1,3],[2,3],[3,1]], Judge: " + j.findJudge(3, new int[][]{{1,2},{2,3},{3,1}}));
		System.out.println("Test: N = 3, Trust = [[1,2],[2,3]], Judge: " + j.findJudge(3, new int[][]{{1,2},{2,3}}));
		System.out.println("Test: N = 4, Trust = [[1,3],[1,4],[2,3],[2,4],[4,3]], Judge: " + j.findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
	}
}