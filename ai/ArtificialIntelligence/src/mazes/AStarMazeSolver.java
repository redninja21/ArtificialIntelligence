package mazes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStarMazeSolver implements MazeSolver {
	private Maze maze;

	public AStarMazeSolver(Maze m) {
		maze = m;
	}

	@Override
	public String getName() {

		return null;
	}

	@Override
	public void setMaze(Maze m) {
		maze = m;
	}

	@Override
	public Maze getMaze() {

		return maze;
	}

	@Override
	public Maze getSolution() {
		PriorityQueue<MazeCell> openbag = new PriorityQueue<MazeCell>(10,
				new MazeCellComparator());
		ArrayList<MazeCell> closebag = new ArrayList<MazeCell>();
		boolean found = false;

		openbag.add(maze.getBegin());
		MazeCell current = null;
		maze.unmark();

		while (!found) {
			if (openbag.size() == 0) break;
			current = openbag.poll();
			closebag.add(current);
			current.setVisited(true);

			// Check if it's the target
			found = (current == maze.getTarget());
			MazeCell[] neighbors = maze.getNeighbors(current);
			for (MazeCell cell : neighbors) {
				if (!cell.isVisited()) {
					cell.setCost(current.getCost() + 1);
					cell.setScore(maze);
					openbag.add(cell);
					cell.setParent(current);
					cell.setVisited(true);
					
				}
			}

		}

		maze.unmark();
		while (current.getParent() != null) {
			current.setVisited(true);
			current = current.getParent();
		}
		return maze;
	}

	@Override
	public MazeSolverData getData() {

		return null;
	}

	class MazeCellComparator implements Comparator<MazeCell> {

		@Override
		public int compare(MazeCell arg0, MazeCell arg1) {
			return arg0.getF() - arg1.getF();
		}

	}
}