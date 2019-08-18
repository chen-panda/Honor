package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import util.App;

public class WelcomePanel extends JPanel{
	WZRYFrame frame;
	//����ͼƬ����
	List<BufferedImage> bgs = new ArrayList<BufferedImage>();
	List<Color> cs = new ArrayList<Color>();
	//����ͼƬ
	BufferedImage img;
	//��ʱ��
	Timer timer;
	int index = 0;
	public WelcomePanel(){
		timer = new Timer();
		//��ʼ����������ͼƬ
		for(int i=1;i<=3;i++){
			bgs.add(App.getImg("/img/LoadingNotice"+i+".png"));
			cs.add(Color.WHITE);
		}
		img = bgs.get(0);
		initMouseListener();
		
	}
	
	private void initMouseListener() {
		MouseAdapter adapter = new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame = null;
				frame = new WZRYFrame(449,600);
				MenuPanel panel = new MenuPanel(frame);
				panel.initMenu();
				frame.setTitle("������ҫ����~�˵�");
				frame.add(panel);
				frame.setVisible(true);
				timer.cancel();
			}
		};
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
	}

	public void action(){
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				img = bgs.get(index%bgs.size());
				for(int i=0;i<cs.size();i++){
					cs.set(i, Color.WHITE);
					if(i==index){
						cs.set(index, Color.GREEN);
					}
				}
				index ++;
				if(index>=cs.size()){
					index =0;
				}
				repaint();
				
			}
		}, 0,3000);
	}
	public WelcomePanel(WZRYFrame frame){
		this();
		this.frame = frame;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0,frame.getWidth(),frame.getHeight(), null);
		g.setColor(Color.yellow);
		Font font = new Font("����",Font.BOLD,20);
		g.setFont(font);
		g.drawString("�����Ļ����", (frame.getWidth()-120)/2, frame.getHeight()-35);
		
	}
}
