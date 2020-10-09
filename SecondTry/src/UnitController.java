import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class UnitController{
	Unit[] units = new Unit[7];
	
	public void paint(Graphics g) {
		for(Unit u:units) {	
			u.paint(g);
		}
	}
	public UnitController() {
		Unit unit0 = new Hoplit(1,0,0);
		Unit unit1 = new Hoplit(2,3,6);
		Unit unit2 = new Hoplit(3,1,8);
		Unit unit3 = new Archer(4,4,9);
		Unit unit4 = new Archer(5,2,0);
		Unit unit5 = new Archer(6,4,0);
		Unit unit6 = new Dragon(7,6,5);
		units[0]= unit0;
		units[1]= unit1;
		units[2]= unit2;
		units[3]= unit3;
		units[4]= unit4;
		units[5]= unit5;
		units[6]= unit6;

	}
	public void mouseClicked(MouseEvent e) {
		int qx = (e.getX() - Field.left) / Field.xSize;
		int qy = (e.getY()-Field.top)/Field.ySize;
		if(e.getButton()==1) {
			for(Unit u: units) {
				u.setSelectedState(qx, qy);
			}
		}else if(e.getButton()==3){
			for(Unit u: units) {
				u.setTarget(qx, qy);
			}
		}
	}
	
	public void refresh() {
		for(Unit u: units) {
			u.move();
		}		
	}
}