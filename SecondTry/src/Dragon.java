import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Stack;

public class Dragon extends Unit {
	private int id;
	private int x = 0;
	private int y = 0;
	private int tx = 0;
	private int ty = 0;

	private boolean selected = false;

	Trend trend = Trend.NONE;
	
	private Stack<Point> path;

	public Dragon(int id, int x, int y) {
		super(id, x, y);
		this.x = x;
		this.y = y;
		tx = x;
		ty = y;
		this.id = id;
	}

	public void paint(Graphics g) {
		int px = Field.left + x * Field.xSize;
		int py = Field.top + y * Field.ySize;
		
		g.setColor(Color.red);
		g.fillRect(px + 1, py  + 1, Field.xSize - 1, Field.ySize - 1);
		g.setColor(Color.YELLOW);
		if (selected) {
			g.fillRect(px + 3, py + 3, Field.xSize - 6, Field.ySize - 6);
		} else {
			g.fillRect(px + 1, py + 1, Field.xSize - 1, Field.ySize - 1);
		}
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", 1, Field.xSize * 3 / 5));
		g.drawString("" + id, px + Field.ySize * 1 / 3,
				py + Field.ySize * 2 / 3);
		g.setColor(Color.red);
		switch (trend) {
		case NORTH:
			g.fillArc(px, py, Field.xSize, Field.ySize, 68, 45);
			break;
		case EAST:
			g.fillArc(px, py, Field.xSize, Field.ySize, -22, 45);
			break;
		case WEST:
			g.fillArc(px, py, Field.xSize, Field.ySize, 158, 45);
			break;
		case SOUTH:
			g.fillArc(px, py, Field.xSize, Field.ySize, 248, 45);
			break;
		}
	}
	
	public void move() {
		if (x > tx) 
			x--;
		if (x < tx)
			x++;
		if (y > ty)
			y--;
		if (y < ty)
			y++;
	}

	public void setSelectedState(int qx, int qy) {
		if (qx == x && qy == y) {
			selected = !selected;
		}
	}

	public void setTarget(int qx, int qy) {
		if (selected) {
			tx = qx;
			ty = qy;
		}
	}
}
