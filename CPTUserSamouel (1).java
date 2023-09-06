import java.awt.*;
import javax.swing.*;

public class CPTUserSamouel extends CPTSamouel{

	public static void main(String[] args) {
		
	//making an object of the base class, setting the layout and background of the panel, adding the panel to the frame
		CPTSamouel cpt = new CPTSamouel();
         JPanel panel = new JPanel();
         panel.setLayout(null);
        panel.setBackground(Color.white);
         frame.setContentPane(panel);
         cpt.addButton(panel);
         
         //frame properties
         frame.setResizable(false);
         frame.setSize(580,640);
         frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         frame.setVisible(true);
        
         

	}

}
