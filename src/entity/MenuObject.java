package entity;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import util.App;

public class MenuObject {
	private String path;
	private String name;
	private BufferedImage img;
	
	public MenuObject(String path,String name){
		img = App.getImg(path);
		this.name = name;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
