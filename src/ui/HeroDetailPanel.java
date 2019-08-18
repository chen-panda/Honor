package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entity.Hero;
import util.App;

public class HeroDetailPanel extends JPanel{
	WZRYFrame frame;
	Hero hero;	
	BufferedImage img ;
	BufferedImage header;
	public HeroDetailPanel(WZRYFrame frame ,Hero hero){
		
		this.frame = frame;
		this.hero = hero;
		img = App.getImg("/img/mainbg.jpg");
		header = App.getImg("/img/header.png");
		initPanel();
	}
	
	private void initPanel() {
		frame.setLayout(null);
		TitlePanel titlePanel = new TitlePanel();
		titlePanel.addMouse();
		titlePanel.setBounds(0, 0, frame.getWidth(), hero.getImg().getHeight());
		frame.add(titlePanel);
		JPanel panel = new ContentPanel();
		panel.setBackground(new Color(50,52,64));
		panel.setPreferredSize(new Dimension(510, 1000));
		JScrollPane pane = new JScrollPane(panel);
		pane.setBounds(0,hero.getImg().getHeight(),frame.getWidth(),frame.getHeight());
		frame.add(pane);
		frame.setVisible(true);
	}

	
	class TitlePanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, null);
			BufferedImage img = hero.getImg();
			g.drawImage(header,0, 0,frame.getWidth(),img.getHeight(), null);
			g.drawImage(hero.getImg(), 0, 0, null);
			g.setColor(Color.white);
			Font font = new Font(App.TITLE_FONT,Font.BOLD,30);
			g.setFont(font);
			g.drawString(hero.getName(), (frame.getWidth()-hero.getName().length()*30)/2, 50);
			Font f = new Font(App.KAITI_FONT,Font.BOLD,20);
			g.setFont(f);
			g.drawString("∑µªÿ", frame.getWidth()-65, 50);
		}

		public void addMouse() {
			MouseAdapter adapter = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					frame = null;
					frame = new WZRYFrame(449,600);
					HeroPanel panel = new HeroPanel(frame);
					panel.initPanel();
					frame.add(panel);
					frame.setTitle("Õı’ﬂ»Ÿ“´÷˙ ÷~”¢–€‰Ø¿¿");
					frame.setVisible(true);
				}
			};
			this.addMouseListener(adapter);
			this.addMouseMotionListener(adapter);
		}
	}
	class ContentPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage himg = hero.getHimg();
				BufferedImage skimg = hero.getSkimg();
				g.drawImage(himg, 0, 0,frame.getWidth(), himg.getHeight(),null);
				g.drawImage(skimg, 0, himg.getHeight(),frame.getWidth(), skimg.getHeight(),null);
		}
	}
}
