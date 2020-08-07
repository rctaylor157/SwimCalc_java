import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import javax.swing.text.MaskFormatter;

public class swimMeetForm
{
	JFrame swimMeetFormFrame = new JFrame();
		JMenuBar swimMeetFormMenuBar = new JMenuBar();
			JMenu swimMeetFormFileMenu = new JMenu("File");
				JMenuItem openSwimMeetForm = new JMenuItem("Open"),
						  saveSwimMeetForm = new JMenuItem("Save"),
						  printSwimMeetForm = new JMenuItem("Print"),
						  closeSwimMeetForm = new JMenuItem("Close");
	JFileChooser swimMeetFormFileChooser = new JFileChooser();
	JScrollPane swimMeetFormPane = new JScrollPane();
    JPanel swimMeetFormPanel = new JPanel();
    	GridLayout layout6 = new GridLayout(70, 3);
    	JLabel swimMeetNameL = new JLabel("Swim Meet"),
    	       eventsL = new JLabel("Events"),
    	   	   swimmersL = new JLabel("Swimmers"),
    	       timeL = new JLabel("Time"),
    	       medleyRelayL = new JLabel("200 Medley Relay"),
                   medleyRelayAL = new JLabel('"' + "A" + '"' + " Relay", JLabel.RIGHT),
                   medleyRelayBL = new JLabel('"' + "B" + '"' + " Relay", JLabel.RIGHT),
                   medleyRelayCL = new JLabel('"' + "C" + '"' + " Relay", JLabel.RIGHT),
    	       twoHundredFreeL = new JLabel("200 Freestyle"),
    	   	   twoHundredIndividualMedleyL = new JLabel("200 IM"),
    	       fiftyFreeL = new JLabel("50 Freestyle"),
        	   oneHundredFreeL = new JLabel("100 Freestyle"),
    	       fiveHundredFreeL = new JLabel("500 Freestyle"),
    	       twoHundredFreeRelayL = new JLabel("200 Freestyle Relay"),
    	           twoHundredFreeRelayAL = new JLabel('"' + "A" + '"' + " Relay", JLabel.RIGHT),
                   twoHundredFreeRelayBL = new JLabel('"' + "B" + '"' + " Relay", JLabel.RIGHT),
                   twoHundredFreeRelayCL = new JLabel('"' + "C" + '"' + " Relay", JLabel.RIGHT),
    	       oneHundredBackL = new JLabel("100 Backstroke"),
    	       oneHundredBreastL = new JLabel("100 Breaststroke"),
    	       fourHundredFreeRelayL = new JLabel("400 Freestyle Relay"),
    	           fourHundredFreeRelayAL = new JLabel('"' + "A" + '"' + " Relay", JLabel.RIGHT),
                   fourHundredFreeRelayBL = new JLabel('"' + "B" + '"' + " Relay", JLabel.RIGHT),
                   fourHundredFreeRelayCL = new JLabel('"' + "C" + '"' + " Relay", JLabel.RIGHT);
    	JTextField swimMeetNameF = new JTextField();
    	JTextField[] medleyRelaySwimmerAF = new JTextField[6],
  			         medleyRelaySwimmerBF = new JTextField[6],
    	             medleyRelaySwimmerCF = new JTextField[6],
   		             twoHundredFreeSwimmerF = new JTextField[5],
    	             twoHundredIndividualMedleySwimmerF = new JTextField[5],
   	    	         fiftyFreeSwimmerF = new JTextField[5],
    	             oneHundredFreeSwimmerF = new JTextField[5],
    	             fiveHundredFreeSwimmerF = new JTextField[5],
    	             twoHundredFreeRelaySwimmerAF = new JTextField[6],
    	             twoHundredFreeRelaySwimmerBF = new JTextField[6],
    	             twoHundredFreeRelaySwimmerCF = new JTextField[6],
    	             oneHundredBackSwimmerF = new JTextField[5],
		             oneHundredBreastSwimmerF = new JTextField[5],
		             fourHundredFreeRelaySwimmerAF = new JTextField[6],
    	             fourHundredFreeRelaySwimmerBF = new JTextField[6],
    	             fourHundredFreeRelaySwimmerCF = new JTextField[6];
		JFormattedTextField[] medleyRelayTimeF = new JFormattedTextField[4],
    	   			          twoHundredFreeTimeF = new JFormattedTextField[4],
    	   			          twoHundredIndividualMedleyTimeF = new JFormattedTextField[4],
    	   			          fiftyFreeTimeF = new JFormattedTextField[4],
    	   			          oneHundredFreeTimeF = new JFormattedTextField[4],
    	   			          fiveHundredFreeTimeF = new JFormattedTextField[4],
    	   			          twoHundredFreeRelayTimeF = new JFormattedTextField[4],
    	   			          oneHundredBackTimeF = new JFormattedTextField[4],
    	   			          oneHundredBreastTimeF = new JFormattedTextField[4],
    	   			          fourHundredFreeRelayTimeF = new JFormattedTextField[4];
    ActionListener listener5 = new swimMeetFormMenuListener();

    public swimMeetForm()
    {
		for(int i = 1; i < 5; i++)
    	{
			initializeMedleyRelaySwimmerAF(i);
			initializeMedleyRelaySwimmerBF(i);
			initializeMedleyRelaySwimmerCF(i);
			initializeTwoHundredFreeSwimmerF(i);
			initializeTwoHundredIndividualMedleySwimmerF(i);
			initializeFiftyFreeSwimmerF(i);
			initializeOneHundredFreeSwimmerF(i);
			initializeFiveHundredFreeSwimmerF(i);
			initializeTwoHundredFreeRelaySwimmerAF(i);
			initializeTwoHundredFreeRelaySwimmerBF(i);
			initializeTwoHundredFreeRelaySwimmerCF(i);
			initializeOneHundredBackSwimmerF(i);
			initializeOneHundredBreastSwimmerF(i);
			initializeFourHundredFreeRelaySwimmerAF(i);
			initializeFourHundredFreeRelaySwimmerBF(i);
			initializeFourHundredFreeRelaySwimmerCF(i);
    	}
		createSwimMeetFormPanel();
		swimMeetFormMenuBar.add(createSwimMeetFormMenuBar());
		swimMeetFormPane.setViewportView(swimMeetFormPanel);
		swimMeetFormFrame.setTitle("Swim Meet Form");
		swimMeetFormFrame.setSize(500, 500);
		swimMeetFormFrame.setJMenuBar(swimMeetFormMenuBar);
		swimMeetFormFrame.add(swimMeetFormPane);
		swimMeetFormFrame.setVisible(true);
    }
    public JTextField initializeMedleyRelaySwimmerAF(int i)
    {
    	medleyRelaySwimmerAF[i] = new JTextField("");
    	return medleyRelaySwimmerAF[i];
    }
    public JTextField initializeMedleyRelaySwimmerBF(int i)
    {
    	medleyRelaySwimmerBF[i] = new JTextField("");
    	return medleyRelaySwimmerBF[i];
    }
    public JTextField initializeMedleyRelaySwimmerCF(int i)
    {
    	medleyRelaySwimmerCF[i] = new JTextField("");
    	return medleyRelaySwimmerCF[i];
    }
    public JTextField initializeTwoHundredFreeSwimmerF(int i)
    {
    	twoHundredFreeSwimmerF[i] = new JTextField("");
    	return twoHundredFreeSwimmerF[i];
    }
    public JTextField initializeTwoHundredIndividualMedleySwimmerF(int i)
    {
    	twoHundredIndividualMedleySwimmerF[i] = new JTextField("");
		return twoHundredIndividualMedleySwimmerF[i];
    }
    public JTextField initializeFiftyFreeSwimmerF(int i)
    {
    	fiftyFreeSwimmerF[i] = new JTextField("");
    	return fiftyFreeSwimmerF[i];
    }
    public JTextField initializeOneHundredFreeSwimmerF(int i)
    {
    	oneHundredFreeSwimmerF[i] = new JTextField("");
    	return oneHundredFreeSwimmerF[i];
    }
    public JTextField initializeFiveHundredFreeSwimmerF(int i)
    {
    	fiveHundredFreeSwimmerF[i] = new JTextField("");
    	return fiveHundredFreeSwimmerF[i];
    }
    public JTextField initializeTwoHundredFreeRelaySwimmerAF(int i)
    {
    	twoHundredFreeRelaySwimmerAF[i] = new JTextField("");
    	return twoHundredFreeRelaySwimmerAF[i];
    }
    public JTextField initializeTwoHundredFreeRelaySwimmerBF(int i)
    {
    	twoHundredFreeRelaySwimmerBF[i] = new JTextField("");
    	return twoHundredFreeRelaySwimmerBF[i];
    }
    public JTextField initializeTwoHundredFreeRelaySwimmerCF(int i)
    {
    	twoHundredFreeRelaySwimmerCF[i] = new JTextField("");
    	return twoHundredFreeRelaySwimmerCF[i];
    }
    public JTextField initializeOneHundredBackSwimmerF(int i)
    {
    	oneHundredBackSwimmerF[i] = new JTextField("");
    	return oneHundredBackSwimmerF[i];
    }
    public JTextField initializeOneHundredBreastSwimmerF(int i)
    {
    	oneHundredBreastSwimmerF[i] = new JTextField("");
    	return oneHundredBreastSwimmerF[i];
    }
    public JTextField initializeFourHundredFreeRelaySwimmerAF(int i)
    {
    	fourHundredFreeRelaySwimmerAF[i] = new JTextField("");
    	return fourHundredFreeRelaySwimmerAF[i];
    }
    public JTextField initializeFourHundredFreeRelaySwimmerBF(int i)
    {
    	fourHundredFreeRelaySwimmerBF[i] = new JTextField("");
    	return fourHundredFreeRelaySwimmerBF[i];
    }
    public JTextField initializeFourHundredFreeRelaySwimmerCF(int i)
    {
    	fourHundredFreeRelaySwimmerCF[i] = new JTextField("");
    	return fourHundredFreeRelaySwimmerCF[i];
    }
    public JMenu createSwimMeetFormMenuBar()
    {
    	swimMeetFormFileMenu.add(openSwimMeetForm);
    		openSwimMeetForm.addActionListener(listener5);
    	swimMeetFormFileMenu.add(saveSwimMeetForm);
    		saveSwimMeetForm.addActionListener(listener5);
    	swimMeetFormFileMenu.add(printSwimMeetForm);
    		printSwimMeetForm.addActionListener(listener5);
    			swimMeetFormFileMenu.addSeparator();
    	swimMeetFormFileMenu.add(closeSwimMeetForm);
    		closeSwimMeetForm.addActionListener(listener5);
    	return swimMeetFormFileMenu;
    }
    public JPanel createSwimMeetFormPanel()
	{
		swimMeetFormPanel.setLayout(layout6);
		swimMeetFormPanel.add(swimMeetNameL);
			swimMeetFormPanel.add(new JLabel(""));
		swimMeetFormPanel.add(swimMeetNameF);
		swimMeetFormPanel.add(eventsL);
		swimMeetFormPanel.add(swimmersL);
		swimMeetFormPanel.add(timeL);
 		try
        {
        	swimMeetFormPanel.add(medleyRelayL);
				swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(new JLabel(""));
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	medleyRelayTimeF[1] = new JFormattedTextField(mask);
        		medleyRelayTimeF[1].setValue("00:00.00");
        	swimMeetFormPanel.add(medleyRelayAL);
				swimMeetFormPanel.add(medleyRelaySwimmerAF[1]);
					swimMeetFormPanel.add(medleyRelayTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerAF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerAF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerAF[4]);
					swimMeetFormPanel.add(new JLabel(""));
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	medleyRelayTimeF[2] = new JFormattedTextField(mask);
        		medleyRelayTimeF[2].setValue("00:00.00");
        	swimMeetFormPanel.add(medleyRelayBL);
				swimMeetFormPanel.add(medleyRelaySwimmerBF[1]);
					swimMeetFormPanel.add(medleyRelayTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerBF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerBF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerBF[4]);
					swimMeetFormPanel.add(new JLabel(""));
        }
        catch (ParseException e)
        {
        }
      	try
      	{
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	medleyRelayTimeF[3] = new JFormattedTextField(mask);
        		medleyRelayTimeF[3].setValue("00:00.00");
        	swimMeetFormPanel.add(medleyRelayCL);
				swimMeetFormPanel.add(medleyRelaySwimmerCF[1]);
					swimMeetFormPanel.add(medleyRelayTimeF[3]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerCF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerCF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(medleyRelaySwimmerCF[4]);
					swimMeetFormPanel.add(new JLabel(""));
		}
      	catch (ParseException e)
      	{
      	}
      	try
      	{
      		MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	twoHundredFreeTimeF[1] = new JFormattedTextField(mask);
        		twoHundredFreeTimeF[1].setValue("00:00.00");
        	twoHundredFreeTimeF[2] = new JFormattedTextField(mask);
        		twoHundredFreeTimeF[2].setValue("00:00.00");
        	twoHundredFreeTimeF[3] = new JFormattedTextField(mask);
        		twoHundredFreeTimeF[3].setValue("00:00.00");
        	swimMeetFormPanel.add(twoHundredFreeL);
        			swimMeetFormPanel.add(new JLabel(""));
        			swimMeetFormPanel.add(new JLabel(""));
        			swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeSwimmerF[1]);
					swimMeetFormPanel.add(twoHundredFreeTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeSwimmerF[2]);
					swimMeetFormPanel.add(twoHundredFreeTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeSwimmerF[3]);
					swimMeetFormPanel.add(twoHundredFreeTimeF[3]);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	twoHundredIndividualMedleyTimeF[1] = new JFormattedTextField(mask);
        		twoHundredIndividualMedleyTimeF[1].setValue("00:00.00");
        	twoHundredIndividualMedleyTimeF[2] = new JFormattedTextField(mask);
        		twoHundredIndividualMedleyTimeF[2].setValue("00:00.00");
        	twoHundredIndividualMedleyTimeF[3] = new JFormattedTextField(mask);
        		twoHundredIndividualMedleyTimeF[3].setValue("00:00.00");
        	swimMeetFormPanel.add(twoHundredIndividualMedleyL);
        			swimMeetFormPanel.add(new JLabel(""));
        			swimMeetFormPanel.add(new JLabel(""));
        			swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredIndividualMedleySwimmerF[1]);
					swimMeetFormPanel.add(twoHundredIndividualMedleyTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredIndividualMedleySwimmerF[2]);
					swimMeetFormPanel.add(twoHundredIndividualMedleyTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredIndividualMedleySwimmerF[3]);
					swimMeetFormPanel.add(twoHundredIndividualMedleyTimeF[3]);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	fiftyFreeTimeF[1] = new JFormattedTextField(mask);
        		fiftyFreeTimeF[1].setValue("00:00.00");
        	fiftyFreeTimeF[2] = new JFormattedTextField(mask);
        		fiftyFreeTimeF[2].setValue("00:00.00");
        	fiftyFreeTimeF[3] = new JFormattedTextField(mask);
        		fiftyFreeTimeF[3].setValue("00:00.00");
        	swimMeetFormPanel.add(fiftyFreeL);
        			swimMeetFormPanel.add(new JLabel(""));
        			swimMeetFormPanel.add(new JLabel(""));
        			swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fiftyFreeSwimmerF[1]);
					swimMeetFormPanel.add(fiftyFreeTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fiftyFreeSwimmerF[2]);
					swimMeetFormPanel.add(fiftyFreeTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fiftyFreeSwimmerF[3]);
					swimMeetFormPanel.add(fiftyFreeTimeF[3]);

        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	oneHundredFreeTimeF[1] = new JFormattedTextField(mask);
        		oneHundredFreeTimeF[1].setValue("00:00.00");
        	oneHundredFreeTimeF[2] = new JFormattedTextField(mask);
        		oneHundredFreeTimeF[2].setValue("00:00.00");
        	oneHundredFreeTimeF[3] = new JFormattedTextField(mask);
        		oneHundredFreeTimeF[3].setValue("00:00.00");
			swimMeetFormPanel.add(oneHundredFreeL);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredFreeSwimmerF[1]);
					swimMeetFormPanel.add(oneHundredFreeTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredFreeSwimmerF[2]);
					swimMeetFormPanel.add(oneHundredFreeTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredFreeSwimmerF[3]);
					swimMeetFormPanel.add(oneHundredFreeTimeF[3]);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	fiveHundredFreeTimeF[1] = new JFormattedTextField(mask);
        		fiveHundredFreeTimeF[1].setValue("00:00.00");
        	fiveHundredFreeTimeF[2] = new JFormattedTextField(mask);
        		fiveHundredFreeTimeF[2].setValue("00:00.00");
        	fiveHundredFreeTimeF[3] = new JFormattedTextField(mask);
        		fiveHundredFreeTimeF[3].setValue("00:00.00");
			swimMeetFormPanel.add(fiveHundredFreeL);
						swimMeetFormPanel.add(new JLabel(""));
						swimMeetFormPanel.add(new JLabel(""));
						swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fiveHundredFreeSwimmerF[1]);
					swimMeetFormPanel.add(fiveHundredFreeTimeF[1]);
						swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fiveHundredFreeSwimmerF[2]);
					swimMeetFormPanel.add(fiveHundredFreeTimeF[2]);
						swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fiveHundredFreeSwimmerF[3]);
					swimMeetFormPanel.add(fiveHundredFreeTimeF[3]);
        }
        catch (ParseException e)
        {
        }
        try
        {
			swimMeetFormPanel.add(twoHundredFreeRelayL);
				swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(new JLabel(""));
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	twoHundredFreeRelayTimeF[1] = new JFormattedTextField(mask);
        		twoHundredFreeRelayTimeF[1].setValue("00:00.00");
        	swimMeetFormPanel.add(twoHundredFreeRelayAL);
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerAF[1]);
					swimMeetFormPanel.add(twoHundredFreeRelayTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerAF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerAF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerAF[4]);
					swimMeetFormPanel.add(new JLabel(""));
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	twoHundredFreeRelayTimeF[2] = new JFormattedTextField(mask);
        		twoHundredFreeRelayTimeF[2].setValue("00:00.00");
        	swimMeetFormPanel.add(twoHundredFreeRelayBL);
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerBF[1]);
					swimMeetFormPanel.add(twoHundredFreeRelayTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerBF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerBF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerBF[4]);
					swimMeetFormPanel.add(new JLabel(""));
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	twoHundredFreeRelayTimeF[3] = new JFormattedTextField(mask);
        		twoHundredFreeRelayTimeF[3].setValue("00:00.00");
        	swimMeetFormPanel.add(twoHundredFreeRelayCL);
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerCF[1]);
					swimMeetFormPanel.add(twoHundredFreeRelayTimeF[3]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerCF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerCF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(twoHundredFreeRelaySwimmerCF[4]);
					swimMeetFormPanel.add(new JLabel(""));
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	oneHundredBackTimeF[1] = new JFormattedTextField(mask);
        		oneHundredBackTimeF[1].setValue("00:00.00");
        	oneHundredBackTimeF[2] = new JFormattedTextField(mask);
        		oneHundredBackTimeF[2].setValue("00:00.00");
        	oneHundredBackTimeF[3] = new JFormattedTextField(mask);
        		oneHundredBackTimeF[3].setValue("00:00.00");
			swimMeetFormPanel.add(oneHundredBackL);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredBackSwimmerF[1]);
					swimMeetFormPanel.add(oneHundredBackTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredBackSwimmerF[2]);
					swimMeetFormPanel.add(oneHundredBackTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredBackSwimmerF[3]);
					swimMeetFormPanel.add(oneHundredBackTimeF[3]);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	oneHundredBreastTimeF[1] = new JFormattedTextField(mask);
        		oneHundredBreastTimeF[1].setValue("00:00.00");
        	oneHundredBreastTimeF[2] = new JFormattedTextField(mask);
        		oneHundredBreastTimeF[2].setValue("00:00.00");
        	oneHundredBreastTimeF[3] = new JFormattedTextField(mask);
        		oneHundredBreastTimeF[3].setValue("00:00.00");
			swimMeetFormPanel.add(oneHundredBreastL);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredBreastSwimmerF[1]);
					swimMeetFormPanel.add(oneHundredBreastTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredBreastSwimmerF[2]);
					swimMeetFormPanel.add(oneHundredBreastTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(oneHundredBreastSwimmerF[3]);
					swimMeetFormPanel.add(oneHundredBreastTimeF[3]);
        }
        catch (ParseException e)
        {
        }
		try
        {
        	swimMeetFormPanel.add(fourHundredFreeRelayL);
				swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(new JLabel(""));
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	fourHundredFreeRelayTimeF[1] = new JFormattedTextField(mask);
        		fourHundredFreeRelayTimeF[1].setValue("00:00.00");
        	swimMeetFormPanel.add(fourHundredFreeRelayAL);
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerAF[1]);
					swimMeetFormPanel.add(fourHundredFreeRelayTimeF[1]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerAF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerAF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerAF[4]);
					swimMeetFormPanel.add(new JLabel(""));
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	fourHundredFreeRelayTimeF[2] = new JFormattedTextField(mask);
        		fourHundredFreeRelayTimeF[2].setValue("00:00.00");
        	swimMeetFormPanel.add(fourHundredFreeRelayBL);
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerBF[1]);
					swimMeetFormPanel.add(fourHundredFreeRelayTimeF[2]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerBF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerBF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerBF[4]);
					swimMeetFormPanel.add(new JLabel(""));
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
        		mask.setPlaceholderCharacter('0');
        	fourHundredFreeRelayTimeF[3] = new JFormattedTextField(mask);
        		fourHundredFreeRelayTimeF[3].setValue("00:00.00");
        	swimMeetFormPanel.add(fourHundredFreeRelayCL);
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerCF[1]);
					swimMeetFormPanel.add(fourHundredFreeRelayTimeF[3]);
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerCF[2]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerCF[3]);
					swimMeetFormPanel.add(new JLabel(""));
					swimMeetFormPanel.add(new JLabel(""));
				swimMeetFormPanel.add(fourHundredFreeRelaySwimmerCF[4]);
					swimMeetFormPanel.add(new JLabel(""));
        }
        catch (ParseException e)
        {
        }
		return swimMeetFormPanel;
	}

	class swimMeetFormMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent click)
    	{
    		Object source = click.getSource();

			if (source == openSwimMeetForm)
            {
                try
				{
					int openSwimMeetFormValue = swimMeetFormFileChooser.showOpenDialog(openSwimMeetForm);
					String[] fileRead = new String[112];
						for (int i = 0; i < 112; i++)
						{
							fileRead[i] = "";
						}
					int i = 0;
					int j = 1;
					File selFile = swimMeetFormFileChooser.getSelectedFile();
					BufferedReader bufferedReader = new BufferedReader(new FileReader(selFile));
						fileRead[j] = bufferedReader.readLine();
						swimMeetNameF.setText(fileRead[j]);
						for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							medleyRelaySwimmerAF[i].setText(fileRead[j]);
						}
                        for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							medleyRelaySwimmerBF[i].setText(fileRead[j]);
						}
						for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							medleyRelaySwimmerCF[i].setText(fileRead[j]);
						}
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            medleyRelayTimeF[i].setValue(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            twoHundredFreeSwimmerF[i].setText(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            twoHundredFreeTimeF[i].setValue(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            twoHundredIndividualMedleySwimmerF[i].setText(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            twoHundredIndividualMedleyTimeF[i].setValue(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            fiftyFreeSwimmerF[i].setText(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            fiftyFreeTimeF[i].setValue(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            oneHundredFreeSwimmerF[i].setText(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            oneHundredFreeTimeF[i].setValue(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            fiveHundredFreeSwimmerF[i].setText(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            fiveHundredFreeTimeF[i].setValue(fileRead[j]);
                        }
                        for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							twoHundredFreeRelaySwimmerAF[i].setText(fileRead[j]);
						}
                        for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							twoHundredFreeRelaySwimmerBF[i].setText(fileRead[j]);
						}
						for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							twoHundredFreeRelaySwimmerCF[i].setText(fileRead[j]);
						}
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            twoHundredFreeRelayTimeF[i].setValue(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            oneHundredBackSwimmerF[i].setText(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            oneHundredBackTimeF[i].setValue(fileRead[j]);
                        }

                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            oneHundredBreastSwimmerF[i].setText(fileRead[j]);
                        }
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            oneHundredBreastTimeF[i].setValue(fileRead[j]);
                        }
                        for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							fourHundredFreeRelaySwimmerAF[i].setText(fileRead[j]);
						}
                        for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							fourHundredFreeRelaySwimmerBF[i].setText(fileRead[j]);
						}
						for (i = 1; i < 5; i++)
						{
							j++;
							fileRead[j] = bufferedReader.readLine();
							fourHundredFreeRelaySwimmerCF[i].setText(fileRead[j]);
						}
                        for (i = 1; i < 4; i++)
                        {
                            j++;
                            fileRead[j] = bufferedReader.readLine();
                            fourHundredFreeRelayTimeF[i].setValue(fileRead[j]);
                        }
                    	bufferedReader.close();
				}
				catch (IOException e)
                {
                	JOptionPane.showMessageDialog(null, "Error opening file");
                }
			}
			if (source == saveSwimMeetForm)
			{
                try
                {
                	int saveSwimMeetFormValue = swimMeetFormFileChooser.showSaveDialog(saveSwimMeetForm);
                    File selFile = swimMeetFormFileChooser.getSelectedFile();
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selFile));
                    swimMeetNameF.write(bufferedWriter);
                    	bufferedWriter.newLine();

                    medleyRelaySwimmerAF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerAF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerAF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerAF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerBF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerBF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerBF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerBF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                   	medleyRelaySwimmerCF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerCF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerCF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelaySwimmerCF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelayTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    medleyRelayTimeF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    medleyRelayTimeF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();

                    twoHundredFreeSwimmerF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredFreeSwimmerF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredFreeSwimmerF[3].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredFreeTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredFreeTimeF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredFreeTimeF[3].write(bufferedWriter);
                        bufferedWriter.newLine();

                    twoHundredIndividualMedleySwimmerF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredIndividualMedleySwimmerF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredIndividualMedleySwimmerF[3].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredIndividualMedleyTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredIndividualMedleyTimeF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredIndividualMedleyTimeF[3].write(bufferedWriter);
                        bufferedWriter.newLine();

                    fiftyFreeSwimmerF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiftyFreeSwimmerF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiftyFreeSwimmerF[3].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiftyFreeTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiftyFreeTimeF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiftyFreeTimeF[3].write(bufferedWriter);
                        bufferedWriter.newLine();

                    oneHundredFreeSwimmerF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredFreeSwimmerF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredFreeSwimmerF[3].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredFreeTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredFreeTimeF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredFreeTimeF[3].write(bufferedWriter);
                        bufferedWriter.newLine();

                    fiveHundredFreeSwimmerF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiveHundredFreeSwimmerF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiveHundredFreeSwimmerF[3].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiveHundredFreeTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiveHundredFreeTimeF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fiveHundredFreeTimeF[3].write(bufferedWriter);
                        bufferedWriter.newLine();

                    twoHundredFreeRelaySwimmerAF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerAF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerAF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerAF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerBF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerBF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerBF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerBF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                   	twoHundredFreeRelaySwimmerCF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerCF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerCF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelaySwimmerCF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelayTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    twoHundredFreeRelayTimeF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    twoHundredFreeRelayTimeF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();

                    oneHundredBackSwimmerF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBackSwimmerF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBackSwimmerF[3].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBackTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBackTimeF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBackTimeF[3].write(bufferedWriter);
                        bufferedWriter.newLine();

                    oneHundredBreastSwimmerF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBreastSwimmerF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBreastSwimmerF[3].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBreastTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBreastTimeF[2].write(bufferedWriter);
                        bufferedWriter.newLine();
                    oneHundredBreastTimeF[3].write(bufferedWriter);
                        bufferedWriter.newLine();

                    fourHundredFreeRelaySwimmerAF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerAF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerAF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerAF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerBF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerBF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerBF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerBF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                   	fourHundredFreeRelaySwimmerCF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerCF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerCF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelaySwimmerCF[4].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelayTimeF[1].write(bufferedWriter);
                        bufferedWriter.newLine();
                    fourHundredFreeRelayTimeF[2].write(bufferedWriter);
                    	bufferedWriter.newLine();
                    fourHundredFreeRelayTimeF[3].write(bufferedWriter);
                    	bufferedWriter.newLine();

                    bufferedWriter.close();
                    if (bufferedWriter != null)
                	{
                		JOptionPane.showMessageDialog(null, "Form Saved");
                	}
                }
                catch (IOException e)
                {
                	JOptionPane.showMessageDialog(null, "Error saving file");
                }
            }
            if (source == printSwimMeetForm)
            {
            	swimMeetNameF.setEditable(false);
		    	for (int i = 1; i < 5; i++)
		    	{
    				medleyRelaySwimmerAF[i].setEditable(false);
  			        medleyRelaySwimmerBF[i].setEditable(false);
    	            medleyRelaySwimmerCF[i].setEditable(false);
    	            twoHundredFreeRelaySwimmerAF[i].setEditable(false);
    	            twoHundredFreeRelaySwimmerBF[i].setEditable(false);
    	            twoHundredFreeRelaySwimmerCF[i].setEditable(false);
		            fourHundredFreeRelaySwimmerAF[i].setEditable(false);
    	            fourHundredFreeRelaySwimmerBF[i].setEditable(false);
    	            fourHundredFreeRelaySwimmerCF[i].setEditable(false);
		    	}
		    	for (int i = 1; i < 5; i++)
		    	{
					twoHundredFreeSwimmerF[i].setEditable(false);
		            twoHundredIndividualMedleySwimmerF[i].setEditable(false);
			        fiftyFreeSwimmerF[i].setEditable(false);
		            oneHundredFreeSwimmerF[i].setEditable(false);
		            fiveHundredFreeSwimmerF[i].setEditable(false);
		            oneHundredBackSwimmerF[i].setEditable(false);
		            oneHundredBreastSwimmerF[i].setEditable(false);
		    	}
		    	for (int i = 1; i < 4; i++)
		    	{
					medleyRelayTimeF[i].setEditable(false);
					twoHundredFreeTimeF[i].setEditable(false);
					twoHundredIndividualMedleyTimeF[i].setEditable(false);
					fiftyFreeTimeF[i].setEditable(false);
					oneHundredFreeTimeF[i].setEditable(false);
					fiveHundredFreeTimeF[i].setEditable(false);
					twoHundredFreeRelayTimeF[i].setEditable(false);
					oneHundredBackTimeF[i].setEditable(false);
					oneHundredBreastTimeF[i].setEditable(false);
					fourHundredFreeRelayTimeF[i].setEditable(false);
		    	}
		    	PrintUtilities.printComponent(swimMeetFormPanel);
		    	swimMeetNameF.setEditable(true);
		    	for (int i = 1; i < 5; i++)
		    	{
    				medleyRelaySwimmerAF[i].setEditable(true);
  			        medleyRelaySwimmerBF[i].setEditable(true);
    	            medleyRelaySwimmerCF[i].setEditable(true);
    	            twoHundredFreeRelaySwimmerAF[i].setEditable(true);
    	            twoHundredFreeRelaySwimmerBF[i].setEditable(true);
    	            twoHundredFreeRelaySwimmerCF[i].setEditable(true);
		            fourHundredFreeRelaySwimmerAF[i].setEditable(true);
    	            fourHundredFreeRelaySwimmerBF[i].setEditable(true);
    	            fourHundredFreeRelaySwimmerCF[i].setEditable(true);
		    	}
		    	for (int i = 1; i < 5; i++)
		    	{
					twoHundredFreeSwimmerF[i].setEditable(true);
		            twoHundredIndividualMedleySwimmerF[i].setEditable(true);
			        fiftyFreeSwimmerF[i].setEditable(true);
		            oneHundredFreeSwimmerF[i].setEditable(true);
		            fiveHundredFreeSwimmerF[i].setEditable(true);
		            oneHundredBackSwimmerF[i].setEditable(true);
		            oneHundredBreastSwimmerF[i].setEditable(true);
		    	}
		    	for (int i = 1; i < 4; i++)
		    	{
					medleyRelayTimeF[i].setEditable(true);
					twoHundredFreeTimeF[i].setEditable(true);
					twoHundredIndividualMedleyTimeF[i].setEditable(true);
					fiftyFreeTimeF[i].setEditable(true);
					oneHundredFreeTimeF[i].setEditable(true);
					fiveHundredFreeTimeF[i].setEditable(true);
					twoHundredFreeRelayTimeF[i].setEditable(true);
					oneHundredBackTimeF[i].setEditable(true);
					oneHundredBreastTimeF[i].setEditable(true);
					fourHundredFreeRelayTimeF[i].setEditable(true);
		    	}
            }
			if (source == closeSwimMeetForm)
			{
				swimMeetFormFrame.dispose();
			}
    	}
	}
}