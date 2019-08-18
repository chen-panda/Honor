package ui;

import javax.swing.JFrame;

public class WZRYFrame extends JFrame{
	public WZRYFrame(){
		setTitle("Õı’ﬂ»Ÿ“´÷˙ ÷");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public WZRYFrame(int w,int h){
		this();
		setSize(w,h);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		WZRYFrame frame = new WZRYFrame(550,309);
		WelcomePanel panel = new WelcomePanel(frame);
		panel.action();
		frame.add(panel);
		frame.setVisible(true);
	}
}
