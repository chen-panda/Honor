package entity;

import java.awt.image.BufferedImage;

public class Hero {
	private int id;
	private String name;
	private String path;
	private String desc;
	private BufferedImage img;
	private BufferedImage himg;
	private BufferedImage skimg;
	private String analyze;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	public String getAnalyze() {
		return analyze;
	}
	public void setAnalyze(String analyze) {
		this.analyze = analyze;
	}
	public BufferedImage getHimg() {
		return himg;
	}
	public void setHimg(BufferedImage himg) {
		this.himg = himg;
	}
	public BufferedImage getSkimg() {
		return skimg;
	}
	public void setSkimg(BufferedImage skimg) {
		this.skimg = skimg;
	}
	
	
	
}
