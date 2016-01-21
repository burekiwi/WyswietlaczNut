import javax.swing.ImageIcon;

public class Polnuta extends Nuta {

	public Polnuta(int wysokosc,int dlugosci){
		dlugosc = dlugosci;
		dlugosc = dlugosc+60;
		miejsce = wysokosc;
		if(wysokosc<209){
			img = new ImageIcon("Polnuta.png").getImage();
		}
		else{
			img = new ImageIcon("PolnutaC.png").getImage();
		}
	}	
}
