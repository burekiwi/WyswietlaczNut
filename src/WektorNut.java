import java.awt.Image;
import java.util.Vector;

public class WektorNut {
	
	protected Vector<Nuta> vec;
	public WektorNut(){
		vec = new Vector<Nuta>();		
	}	
	public void dodajNute(Nuta nuta){
		vec.add(nuta);
	}	
	public Image pokazObraz(int i){
		return vec.get(i).pokazObraz();
	}	
	public int rozmiar(){
		return vec.size();
	}	
	public int dlugosc(){
		int rozmiar = vec.size();
		if (rozmiar>0){			
			return vec.lastElement().dlugosc();
		}
		else{
			return 50;
		}
	}	
	public int dlugoscPoprzedniej(int i){
		if (i>0){
			return vec.get(i-1).dlugosc();
		}
		else{
			return 50;
		}
	}	
	public int wysokosc(int i){
		return vec.get(i).gdzie();
	}	
	public void usunOstatni(){
		int rozmiar = vec.size();
		if (rozmiar>0){
			vec.remove(rozmiar-1);
		}
	}
}
