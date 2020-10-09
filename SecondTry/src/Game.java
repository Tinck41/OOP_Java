import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {
	UnitController controller = new UnitController();

	public static void main(String[] args) {
		
		Game game = new Game();
		game.setBounds(100, 100, 900, 700);
		//JButton button = new JButton("Press me");
		//frame.add(button);
		//frame.setBackground(Color.black);
		game.addMouseListener(new MouseAdapter() {	
			@Override
			public void mouseClicked(MouseEvent e) {
				game.controller.mouseClicked(e);
				
				game.repaint();
			}
		});
		game.setVisible(true);
		new Thread(game).start();
	}
	
	@Override
	public void paint(Graphics g) {
		this.createBufferStrategy(3);
		BufferStrategy bs = this.getBufferStrategy();
		g = bs.getDrawGraphics();
		
		super.paint(g);
		new Field().paint(g);
		controller.paint(g);
		
		
		bs.show();
	}

	@Override
	public void run() {
		while (true) {
			
			controller.refresh();
			
			repaint();
			
			try {
				Thread.sleep(125);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				System.out.println("ошибочка поотока" + e.toString());
			}
			
		}
	}

}
