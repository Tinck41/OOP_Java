import java.awt.Color;
import java.awt.Graphics;

public class Field {
	
	static final int left = 100;
	static final int top = 100;
	static final int xSize = 50;
	static final int ySize = 50;
	static final int xNum = 10;
	static final int yNum = 10;
	
	int[][] map0 = new int[xNum][yNum];
	static  int[][] map1;

	static {
		map1 = MapLoader.load("./map/map.txt");
	}
	
	public void paint(Graphics g) {
		
		for (int i = 0; i <= yNum; i++) {
			g.drawLine(left, i * ySize + top, left + xNum * xSize, i * ySize + top);
		}
		
		for (int i = 0; i <= xNum; i++) {
			g.drawLine(i * xSize + left, top, i * xSize + left, top + yNum * ySize);
		}
		g.setColor(Color.orange);
		for (int i = 0; i <map1.length; i++) {
			int[] tArr = map1[i];
			for (int j = 0; j < tArr.length; j++) {
				if (tArr[j] == -2)
					g.fillRect(left + 1 + j * xSize, top + 1 + i * ySize, xSize - 1, ySize - 1);
			}
			//System.out.println();
		}
	}

}
