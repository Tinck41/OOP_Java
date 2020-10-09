import java.util.*;

public class WaveAlgorithms {
	private int[] Expansion(int x, int y, int tx, int ty) {
		int[] markedCell = new int[Field.yNum * Field.xNum];
		int mark = 1;
		markedCell[y * Field.yNum + x] = mark;
		while(markedCell[tx + ty * Field.yNum] == 0) {
			for (int i = 0; i < markedCell.length; i++) {
				if (markedCell[i] == mark) {
					x = i % Field.xNum;
					y = i / Field.yNum;
					if (x < Field.xNum - 1 && markedCell[(x + 1) + y * Field.yNum] == 0 && Field.map1[y][x + 1] != 1) {
						markedCell[(x + 1) + y * Field.yNum] = mark + 1;
					}
					if (x > 0 && markedCell[(x - 1) + y * Field.yNum] == 0 && Field.map1[y][x - 1] != 1) {
						markedCell[(x - 1) + y * Field.yNum] = mark + 1;
					}
					if (y < Field.yNum - 1 && markedCell[x + (y + 1) * Field.yNum] == 0 && Field.map1[y + 1][x] != 1) {
						markedCell[x + (y + 1) * Field.yNum] = mark + 1;
					}
					if (y > 0 && markedCell[x + (y - 1) * Field.yNum] == 0 && Field.map1[y - 1][x] != 1) {
						markedCell[x + (y - 1) * Field.yNum] = mark + 1;
					}
				}
			}
			mark++;
			//Print(markedCell);
		}
		return markedCell;
	}
	
	private void Print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % Field.yNum == 0 && i != 0)
				System.out.println();
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("================================");
		System.out.println();
	}
	
	public Vector<Integer> Path(int x, int y, int tx, int ty) {
		int[] markedCell = Expansion(x, y, tx, ty);
		//ArrayList<Integer> path = new ArrayList<>();
		Vector<Integer> path = new Vector<>();
		
		path.addElement(tx + ty * Field.yNum);
		while ((tx + ty * Field.yNum) != (x + y * Field.yNum)) {
			if (tx < Field.xNum - 1 && markedCell[(tx + 1) + ty * Field.yNum] == (markedCell[tx + ty * Field.yNum] - 1)) {
				tx++;
				path.addElement(tx + ty * Field.yNum);
				continue;
			}
			if (tx > 0 && markedCell[(tx - 1) + ty * Field.yNum] == (markedCell[tx + ty * Field.yNum] - 1)) {
				tx--;
				path.addElement(tx + ty * Field.yNum);
				continue;
			}
			if (ty < Field.yNum - 1 && markedCell[tx + (ty + 1) * Field.yNum] == (markedCell[tx + ty * Field.yNum] - 1)) {
				ty++;
				path.addElement(tx + ty * Field.yNum);
				continue;
			}
			if (ty > 0 && markedCell[tx + ((ty - 1) * Field.yNum)] == (markedCell[tx + ty * Field.yNum] - 1)) {
				ty--;
				path.addElement(tx + ty * Field.yNum);
				continue;
			}
		}
		return path;
	}
}

