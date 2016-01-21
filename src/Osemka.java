import javax.swing.ImageIcon;

public class Osemka extends Nuta {

	public Osemka(int wysokosc,int dlugosci){
		dlugosc = dlugosci;
		dlugosc = dlugosc+30;
		miejsce = wysokosc;
		if(wysokosc<209){
			img = new ImageIcon("Osemka.png").getImage();
		}
		else{
			img = new ImageIcon("OsemkaC.png").getImage();
		}
	}	
}