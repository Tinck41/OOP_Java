import java.util.ArrayDeque;
import java.util.Stack;

public class WaveAlg {
	
	private int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
	private int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
	
	private int[][] map;
	
	public Stack<Point> moveOrthogonal(int x, int y, int tx, int ty, int[][] fieldMap) {
		cloneMap(fieldMap);
		waveSpread(x, y, tx, ty, 4);
		Print(fieldMap);
		return findPath(x, y, tx, ty, 4);
	}
	
	public Stack<Point> moveDiagonal(int x, int y, int tx, int ty, int[][] fieldMap) {
		cloneMap(fieldMap);
		waveSpread(x, y, tx, ty, 8);
		Print(fieldMap);
		return findPath(x, y, tx, ty, 8);
	}
	
	private void waveSpread(int x, int y, int tx, int ty, int neighborsNum) {
		ArrayDeque<Point> checkedCell = new ArrayDeque<Point>();
		int mark = 1;
		map[x][y] = mark;
		checkedCell.add(new Point(x, y));
		while (map[ty][tx] == 0) {
			int size = checkedCell.size();
			for (int i = 0; i < size; i++) {
				Point p = checkedCell.poll();
				for (int j = 0; j < neighborsNum; j++) {
					int tempx = p.getX() + dx[j];
					int tempy = p.getY() + dy[j];
					if (tempx >= 0 && tempx < map[0].length && tempy >= 0 && tempy < map.length)
						if (map[tempy][tempx] == 0) {
							map[tempy][tempx] = mark;
							checkedCell.add(new Point(tempx, tempy));
						}
				}
			}
			mark++;
		}
		map[y][x] = 0;
		Print(map);
	}
	
	private Stack<Point> findPath(int x, int y, int tx, int ty, int neighborsNum) {
		Stack<Point> path = new Stack<Point>();
		path.add(new Point(tx, ty));
		while (x != tx || y != ty) {
				for (int j = 0; j < neighborsNum; j++) {
					int tempx = path.peek().getX() + dx[j];
					int tempy = path.peek().getY() + dy[j];
					if (tempx >= 0 && tempx < map[0].length && tempy >= 0 && tempy < map.length)
						if (map[ty][tx] - 1 == map[tempy][tempx]) {
							tx = tempx;
							ty = tempy;
							path.add(new Point(tempx, tempy));
							break;
						}
				}
		}
		return path;
	}
	
	private void cloneMap(int[][] arr) {
		map = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				map[i][j] = arr[i][j];
			}
		}
	}
	
	private void Print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
