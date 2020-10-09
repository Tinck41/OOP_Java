import java.util.ArrayList;
import java.util.List;

public class MassiveDemo {
	
	private static int uX = 0;
	private static int uY = 1;
	
	private static int[][] nodeMap = new int [7][];
	
	public static void main(String[] args) {
		nodeMap = MapLoader.load("map.txt");
		paint(nodeMap);
		while (uY < 8) {
			uY++;
			paint(nodeMap);
			nodeMap[uY - 1][uX] = 0;
		}
		goTo(7, 8);
	}

	private static void goTo(int i, int j) {
		//int []
		
	}

	private static void paint(int[][] nodeMap2) {
		
		nodeMap2[uY][uX] = 2;
		
		for (int i = 0; i < nodeMap2.length; i++) {
			int ln = nodeMap2[i].length;
			for (int j = 0; j < ln; j++) {
				System.out.print(nodeMap2[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	

}
