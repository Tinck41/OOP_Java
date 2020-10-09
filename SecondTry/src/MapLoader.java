import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapLoader {

	public static void main(String[] args) {
		MapLoader.load("map.txt");
	}

	public static int[][] load(String string) {
		Scanner sc;
		int[][] arr = new int[Field.yNum][];
		try {
			sc = new Scanner(new File(string));
			int count = 0;
			
 			while (sc.hasNextLine() && count < Field.yNum) {
 				String str = sc.nextLine();
 				String[] strArr = str.split(" ");
 				int[] iArr = new int[strArr.length];
 				for (int i = 0; i < Field.xNum; i++) {
 					iArr[i] = Integer.parseInt(strArr[i]);
 				}
 				arr[count] = iArr;
 				count++;
			}
 			//print(arr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1)
					arr[i][j] = -2;
			}
		}
		
		return arr;
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int[] tArr = arr[i];
			for (int j = 0; j < tArr.length; j++) {
				System.out.print(tArr[i] + " ");
			}
			System.out.println();
		}
		
	}

}
