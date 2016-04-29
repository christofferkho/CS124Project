package app.component;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import app.entity.Promo;

@Component
public class GetPromoCommand extends Command {

	@Override
	public String undo(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(HashMap map) {
		// TODO Auto-generated method stub
		Promo promo = getPromo();
		return promo.getUrl();
	}
	
	public Promo getPromo(){
		return promoDao.findById(1);
	}
	
}
