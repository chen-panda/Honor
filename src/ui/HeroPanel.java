package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entity.Hero;
import service.HeroService;
import util.App;

public class HeroPanel extends JPanel{
	WZRYFrame frame;
	HeroService service;
	List<Hero> heros ;
	BufferedImage img;
	BufferedImage header;
	
	public HeroPanel(WZRYFrame frame){
		this.frame = frame;
		service = new HeroService();
		//heros = service.getHeros();
		heros = App.getHeros();
		img = App.getImg("/img/mainbg.jpg");
		header = App.getImg("/img/header.png");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		g.drawImage(header, 0, 0,frame.getWidth(),70, null);
		g.setColor(Color.white);
		Font font = new Font("Ò¶¸ùÓÑÃ«±ÊÐÐÊé2.0°æ",Font.BOLD,30);
		g.setFont(font);
		g.drawString("Ó¢ÐÛä¯ÀÀ", frame.getWidth()/2-60, 50);
	}

	public void initPanel() {
		JPanel panel = null;
		GridLayout layout = null;
		
		for(int i=0;i<heros.size();i++){
			if(i%4==0){
				panel = new JPanel();
				layout = new GridLayout(1, 4);
				panel.setLayout(layout);
			}
			Hero h = heros.get(i);
			ItemPanel pa = new ItemPanel(h);
			pa.addMouseListener();
			panel.setBounds(10, (i/4)*(h.getImg().getHeight()+40)+80, frame.getWidth(),h.getImg().getHeight()+40 );
			panel.add(pa);
			frame.add(panel);
		}
		
	}

	class ItemPanel extends JPanel{
		Hero hero;
		public ItemPanel(Hero hero){
			this.hero = hero;
		}
		public void addMouseListener() {
			MouseAdapter adapter = new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.setVisible(false);
					frame = null;
					frame = new WZRYFrame(510,600);
					//frame.setLayout(null);
					HeroDetailPanel panel = new HeroDetailPanel(frame, hero);
				}
			};
			this.addMouseListener(adapter);
			this.addMouseMotionListener(adapter);
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
				g.drawImage(img, 0, 0, null);
				g.setColor(Color.red);
				BufferedImage img = hero.getImg();
			    g.fillRect(0, 0, img.getWidth(), img.getHeight()+30);
			    g.drawImage(img, 0, 0, null);
				g.setColor(Color.white);
				Font font = new Font("¿¬Ìå",Font.BOLD,20);
				g.setFont(font);
				int y = (img.getWidth()-20*hero.getName().length())/2;
				g.drawString(hero.getName(),y , img.getHeight()+20);
		}
	}
	
}
