package mazes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostMazeSolver implements MazeSolver {
	private Maze maze;

	public UniformCostMazeSolver(Maze m) {
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
		PriorityQueue <MazeCell> bag = new PriorityQueue <MazeCell> (10,new MazeCellComparator());
		boolean found = false;

		bag.add(maze.getBegin());
		MazeCell current = null;
		maze.unmark();
		
		while (!found) {
			if(bag.size() == 0)break;
			current = bag.poll();
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



	class MazeCellComparator implements Comparator <MazeCell>{

		@Override
		public int compare(MazeCell arg0, MazeCell arg1) {
			int d0;
			int d1;
			d0 = arg0.getCost();
			d1 = arg1.getCost();
		
			
			return d0 - d1;
		}
		
	}
}