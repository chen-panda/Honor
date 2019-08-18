package util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import entity.Hero;

public class App {
	public static final String TITLE_FONT = "叶根友毛笔行书2.0版";
	public static final String KAITI_FONT = "楷体";
	
	/**
	 * 加载指定路径下面的图片
	 * @param path 图片路径
	 * @return
	 */
	public static BufferedImage getImg(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(App.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public static List<Hero> getHeros(){
		List<Hero> heros = new ArrayList<Hero>();
		BufferedReader in = 
				new BufferedReader(
					new InputStreamReader(App.class.getResourceAsStream("/util/hero.txt")));
		String line = null;
		try {
			while((line=in.readLine())!=null){
				String [] strs = line.split("\\|");
				Hero hero = new Hero();
				hero.setId(Integer.parseInt(strs[0]));
				hero.setName(strs[1]);
				hero.setImg(getImg(strs[2]));
				hero.setHimg(getImg(strs[3]));
				hero.setSkimg(getImg(strs[4]));
				heros.add(hero);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return heros;
		
	}

}
