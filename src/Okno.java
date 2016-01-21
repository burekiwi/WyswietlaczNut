import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class Okno extends JFrame implements ActionListener{
	
	protected Cwiercnuta cwiercnuta;
	protected Polnuta polnuta;
	protected Osemka osemka;
	protected JButton pDodajC, pDodajD, pDodajE, pDodajF, pDodajG, pDodajA, pDodajH, pUsun;
	protected ButtonGroup radioPanel;
	protected JRadioButton rOsemka, rCwiercnuta, rPolnuta;
	protected Image img;
	protected Map<JButton,Integer> zrodla;
	protected WektorNut nuty;
	public Okno(){
		setTitle("WYSWIETLACZ NUT");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1000, 650);
		
		radioPanel = new ButtonGroup();
		rOsemka = new JRadioButton("Osemka");
		rOsemka.setBounds(350, 520, 100, 30);
		rOsemka.setSelected(true);
		rCwiercnuta = new JRadioButton("Cwiercnuta");
		rCwiercnuta.setBounds(450, 520, 100, 30);
		rPolnuta = new JRadioButton("Polnuta");
		rPolnuta.setBounds(550, 520, 100, 30);
		
		radioPanel.add(rOsemka);
		radioPanel.add(rCwiercnuta);
		radioPanel.add(rPolnuta);
		add(rOsemka);
		add(rPolnuta);
		add(rCwiercnuta);
		
		rOsemka.addActionListener(this);
		rCwiercnuta.addActionListener(this);
		rPolnuta.addActionListener(this);
				
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
        container.add(UtworzPrzyciski(), BorderLayout.SOUTH);
        
        nuty = new WektorNut();
        
        img = new ImageIcon("Klucz wiolinowy1.jpg").getImage();
        
        zrodla = new HashMap<JButton,Integer>();
        zrodla.put(pDodajC,209);
        zrodla.put(pDodajD,203);
        zrodla.put(pDodajE,199);
        zrodla.put(pDodajF,193);
        zrodla.put(pDodajG,189);
        zrodla.put(pDodajA,183);
        zrodla.put(pDodajH,179);
	}
	
	private JPanel UtworzPrzyciski(){		
		pDodajC = new JButton("C");
		pDodajC.addActionListener(this);
		pDodajD = new JButton("D");
		pDodajD.addActionListener(this);
		pDodajE = new JButton("E");
		pDodajE.addActionListener(this);
		pDodajF = new JButton("F");
		pDodajF.addActionListener(this);
		pDodajG = new JButton("G");
		pDodajG.addActionListener(this);
		pDodajA = new JButton("A");
		pDodajA.addActionListener(this);
		pDodajH = new JButton("H");
		pDodajH.addActionListener(this);
		pUsun = new JButton("Usun");
		pUsun.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));		
		panel.add(pDodajC);
		panel.add(pDodajD);
		panel.add(pDodajE);
		panel.add(pDodajF);
		panel.add(pDodajG);
		panel.add(pDodajA);
		panel.add(pDodajH);
		panel.add(pUsun);
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object zrodlo = e.getSource();				
		if(zrodlo==pUsun){
			nuty.usunOstatni();
			repaint();
		}		
		for(Map.Entry<JButton,Integer> entry : zrodla.entrySet()){
			if (zrodlo == entry.getKey()){
				if(rCwiercnuta.isSelected()){
					cwiercnuta = new Cwiercnuta(entry.getValue(),nuty.dlugosc());
					nuty.dodajNute(cwiercnuta);
				}
				if(rOsemka.isSelected()){
					osemka = new Osemka(entry.getValue(),nuty.dlugosc());
					nuty.dodajNute(osemka);
				}
				if(rPolnuta.isSelected()){
					polnuta = new Polnuta(entry.getValue(),nuty.dlugosc());
					nuty.dodajNute(polnuta);
				}
			}
			repaint();
		}
	}

	public void paint(Graphics g){		
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Color bialy = new Color(255,255,255);
		Color czarny = new Color(0,0,0);
		g2.setColor(bialy);
		g2.fillRect(0, 0, 1000, 500);
		for(int i = 0; i < nuty.rozmiar(); i++){			
			g2.drawImage(nuty.pokazObraz(i), nuty.dlugoscPoprzedniej(i), nuty.wysokosc(i), null);
		}
		g2.setColor(czarny);
		g2.drawImage(img,10,175,null);
		g2.drawLine(0, 200, 1000, 200);
		g2.drawLine(0, 210, 1000, 210);
		g2.drawLine(0, 220, 1000, 220);
		g2.drawLine(0, 230, 1000, 230);
		g2.drawLine(0, 240, 1000, 240);			
	}	
}
