package bildspeich;


import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EventListener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;




public class bildspeich extends JFrame implements ActionListener, WindowListener, EventListener
{
	
	JTextArea mTextfeld = new JTextArea("URL");
	JTextArea mTextfeld2 = new JTextArea("Speichername");
	String mURL = "";
	String mURLcounted = "";
	String mDateiname = "Bild";
	BufferedImage mImage;

	
	public bildspeich () throws MalformedURLException, IOException
	{
				
		JPanel panelSued = new JPanel();
		
		JButton mButtonText = new JButton("Speichern");
		mButtonText.addActionListener(this);
		mButtonText.setActionCommand("kommandoSpeichern");
		panelSued.add(mButtonText);
		
		JButton mButtonEnde = new JButton("Ende");
		mButtonEnde.addActionListener(this);
		mButtonEnde.setActionCommand("kommandoEnde");
		panelSued.add(mButtonEnde);
		
		this.add(mTextfeld, BorderLayout.NORTH);
		this.add(mTextfeld2, BorderLayout.CENTER);
		this.add(panelSued, BorderLayout.SOUTH);
		this.setBounds(100,100,400,300);
		this.setVisible(true);
		this.addWindowListener (this);
		//this.addFocusListener (this);
	}
	
	private void mSpeichern() 
	{
		
		mURL = mTextfeld.getText();
		mDateiname = mTextfeld2.getText();
		String fileSep= System.getProperty("file.separator");
		
		for (int i=0; i<10; i++) //für 00.jpg, 01 usw
			{
			mURLcounted = mURL + "0" + String.valueOf(i)+".jpg";
			
			try 
			{
				try
				{
				mImage = ImageIO.read(new URL(mURLcounted));
				ImageIO.write(mImage, "jpeg", new File("HQ Pics" + fileSep, mDateiname+" "+String.valueOf(i)+".jpg"));
				}
			catch (MalformedURLException e) {e.printStackTrace();}
			}
			catch (IOException e)  {e.printStackTrace();}
			}
		http://content.topgear.com/Wallpaper/big/15big%20copy.jpg
		
		for (int i=0; i<=70; i++) //für 0.jpg, 1.jpg usw (bis 50)
			{
			mURLcounted = mURL + String.valueOf(i)+".jpg";
			
			try 
			{
				try
				{
				mImage = ImageIO.read(new URL(mURLcounted));
				ImageIO.write(mImage, "jpeg", new File("HQ Pics" + fileSep,mDateiname+" "+String.valueOf(i)+".jpg"));
				}
			catch (MalformedURLException e) {e.printStackTrace();}
			}
			catch (IOException e)  {e.printStackTrace();}
			}
		
	}

	/*	
		
	}
	public void oeffnen()
	{
		InputStreamReader mISR = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(mISR);
		
		try
		{
			String eingabe = in.readLine();
			
			if (eingabe.equals("test"))				//== funktioniert nicht...
				System.out.println("erfolgreich!");
			else System.out.println("gescheitert! \nEingegeben: "+eingabe);
		}
		catch (IOException ioe)
		{System.out.println("Fehler");}
		}
	 
	/*public void doCopy(String Name)
	{
	      try
	      {
	           //copyFile(path.getText() , "E:/.... (Ordner wo die Daten hin sollen)/" + name)
	      }
	     catch(IOException e)
	      {
	           System.out.println(e.getMessage());
	      }
	}*/

	
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		new bildspeich();
		
	}

	//BUTTON EVENTS
	@Override
	public void actionPerformed(ActionEvent e1) 
	{
		String aktKommando = e1.getActionCommand();
		
		if (aktKommando.equals("kommandoSpeichern"))	mSpeichern();
		else if (aktKommando.equals("kommandoEnde"))	System.exit(0);
	}
	

	//WINDOW EVENTS
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent we) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent we) {
		// TODO Auto-generated method stub
		dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
