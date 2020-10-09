import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageStore {
	
	private static BufferedImage img;
	private static ImageStore instance;
	
	int[][] unit = new int[][] {{0, 0, 58, 70}, {59, 0, 116, 70}, {0, 71, 58, 140}, {59, 70, 116, 140}};
	
	private ImageStore() {
		try {
			img = ImageIO.read(new File("./tiles/Archer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getImage(int id) {
		BufferedImage unitImg;
		unitImg = img.getSubimage(unit[id][0], unit[id][1], unit[id][2], unit[id][3]);
		return unitImg;
	}
	
	public static synchronized ImageStore getInstance() {
		if (instance == null) {
			instance = new ImageStore();
		}
		return instance;
	}

}
