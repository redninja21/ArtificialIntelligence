package mazes;

public class TestSolver {
	public static void main(String[] args) {
		String[] mazes = {"bigmaze.txt","smallmaze.txt", "mediummaze.txt", "bigmaze.txt", "openmaze.txt", "astarmaze.txt"};
		long time = 0;
		for (String maze : mazes) {
			time = System.currentTimeMillis();
			MazeSolver solver = new GreedyBFS(new Maze(maze));
			new MazeView(solver.getSolution());
			System.out.println("Maze " + maze);
			System.out.println(System.currentTimeMillis() - time);
		}
	}
}
