package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entity.MenuObject;
import util.App;

public class MenuPanel extends JPanel{
	WZRYFrame frame;
	BufferedImage img;
	BufferedImage header;
	String[] menus = {"英雄浏览","装备浏览","技能介绍","成就说明","职业战队","符文浏览"};
	String[] imgs = {"Hero","Bag","kill","Achieve","Guild","Rune"};
	MenuObject[] obs = new MenuObject[imgs.length]; 
	
	JLabel label;
	
	public MenuPanel(WZRYFrame frame){
		this.frame  = frame;
		img = App.getImg("/img/mainbg.jpg");
		header = App.getImg("/img/header.png");
		for(int i=0;i<menus.length;i++){
			obs[i] = new MenuObject("/img/"+imgs[i]+".png", menus[i]);
		}
	}
	
	public void initMenu() {
		JList<MenuObject> list = new JList<>(obs);
		list.setForeground(Color.white);
		list.setBackground(new Color(0,0,0,0));
		list.setBounds(0, 70, frame.getWidth(), frame.getHeight()-100);
		list.setCellRenderer(new FontCellRenderer());
		list.setOpaque(false);
		list.addListSelectionListener(new MyListListenter());
		frame.add(list);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		g.drawImage(header, 0, 0,frame.getWidth(),70, null);
		g.setColor(Color.white);
		Font font = new Font(App.TITLE_FONT,Font.BOLD,30);
		g.setFont(font);
		g.drawString("菜单", frame.getWidth()/2-25, 50);
		
		
	}
	
	class MyListListenter implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent e) {
			MenuObject ob =(MenuObject) ((JList) e.getSource()).getSelectedValue();
			String value = ob.getName();
			if(value.equals("英雄浏览")){
				frame.setVisible(false);
				frame = null;
				frame = new WZRYFrame(449,600);
				HeroPanel panel = new HeroPanel(frame);
				panel.initPanel();
				frame.add(panel);
				frame.setTitle("王者荣耀助手~"+value);
				frame.setVisible(true);
			}
		}
		
	}
	
	class FontCellRenderer extends JPanel implements ListCellRenderer
	 {
	    public Component getListCellRendererComponent(JList list, Object value, int index,
	       boolean isSelected, boolean cellHasFocus)
	    {
	       MenuObject ob = (MenuObject)value;
	       text = ob.getName();
	       img = ob.getImg();
	       background = isSelected ? list.getSelectionBackground() : list.getBackground();
	       foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
	       return this;
	    }

	    public void paintComponent(Graphics g)
	    {
	       g.setColor(background);
	       g.fillRect(0, 0, getWidth(), getHeight());  //设置背景色
	       g.drawImage(img, 100, 15, null);
	       Font font = new Font("楷体",Font.BOLD,20);
	       g.setFont(font);
	       g.setColor(foreground);
	       g.drawString(text, 200, 40);   //在制定位置绘制文本
	       g.drawLine(20,69,frame.getWidth()-20,69);
	    }

	    public Dimension getPreferredSize()
	    {
	       return new Dimension(frame.getWidth(), 70);   //Cell的尺寸
	    }

	    private String text;
	    private Color background;
	    private Color foreground;
	    private BufferedImage img;
	 }
}
