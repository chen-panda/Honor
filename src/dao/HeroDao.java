package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Hero;
import util.App;
import util.DBUtil;

public class HeroDao {
	public List<Hero> findAllHeros(){
		List<Hero> heros = new ArrayList<Hero>();
		Connection con = DBUtil.getCon();
		String sql = "select * from w_hero";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			Hero hero = null;
			while(rs.next()){
				hero = new Hero();
				hero.setId(rs.getInt("id"));
				hero.setName(rs.getString("name"));
				hero.setAnalyze(rs.getString("analyze"));
				hero.setDesc(rs.getString("desc"));
				hero.setHimg(App.getImg(rs.getString("himg")));
				hero.setSkimg(App.getImg(rs.getString("skimg")));
				hero.setImg(App.getImg(rs.getString("path")));
				heros.add(hero);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heros;
		
	}
}
