import javax.swing.ImageIcon;

public class Cwiercnuta extends Nuta {

	public Cwiercnuta(int wysokosc,int dlugosci){
		dlugosc = dlugosci;
		dlugosc = dlugosc+45;
		miejsce = wysokosc;
		if(wysokosc<209){
			img = new ImageIcon("Cwiercnuta.png").getImage();
		}
		else{
			img = new ImageIcon("CwiercnutaC.png").getImage();
		}
	}	
}
