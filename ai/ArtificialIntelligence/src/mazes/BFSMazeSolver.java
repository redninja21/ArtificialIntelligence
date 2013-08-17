package mazes;

import java.util.ArrayList;

public class BFSMazeSolver implements MazeSolver {
	private Maze maze;

	public BFSMazeSolver(Maze m) {
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
		ArrayList<MazeCell> bag = new ArrayList<MazeCell>();
		boolean found = false;

		bag.add(maze.getBegin());
		MazeCell current = null;
		maze.unmark();
		
		while (!found) {
			if(bag.size() == 0)break;
			current = bag.remove(0);
			current.setVisited(true);
			
			//Check if it's the target
			found = (current == maze.getTarget());
			MazeCell [] neighbors = maze.getNeighbors(current);
			for(MazeCell cell : neighbors){
				if(!cell.isVisited()){
				bag.add(cell);
				cell.setParent(current);
				cell.setVisited(true);
				}
			}
			
		}
		
		maze.unmark();
		while(current.getParent() != null){
			current.setVisited(true);
			current = current.getParent();
		}
		return maze;
	}

	@Override
	public MazeSolverData getData() {
		
		return null;
	}

}
