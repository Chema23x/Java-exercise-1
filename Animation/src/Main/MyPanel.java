package Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {
	
	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	ImageIcon prevMario;
	ImageIcon prevBg;
	Image mario;
	Image backgroundImage;
	Timer timer;
	int xVelocity = 1;
	int yVelocity = 1;
	int x = 0;
	int y = 350;
	
	MyPanel (){
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		prevMario = new ImageIcon("C:\\Users\\Jose\\eclipse-workspace\\Animation\\src\\Main\\mario.png");
		prevBg = new ImageIcon("C:\\Users\\Jose\\eclipse-workspace\\Animation\\src\\Main\\background2.jpg");
		Image scaledBg = prevBg.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		Image scaledImage = prevMario.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		mario = new ImageIcon(scaledImage).getImage();
		backgroundImage = new ImageIcon(scaledBg).getImage();
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(mario, x, y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(x>= PANEL_WIDTH - mario.getWidth(null) || x < 0) {
			xVelocity = xVelocity * -1;
		}
		x = x + xVelocity;
		
		/*
		if(y>= PANEL_HEIGHT - mario.getHeight(null) || y < 0) {
			yVelocity = yVelocity * -1;
		}
		y = y + yVelocity;
		*/
		repaint();
	}
}
