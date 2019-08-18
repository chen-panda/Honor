package service;

import java.util.List;

import dao.HeroDao;
import entity.Hero;

public class HeroService {
	HeroDao dao = new HeroDao();
	public List<Hero> getHeros(){
		return dao.findAllHeros();
	}
}
