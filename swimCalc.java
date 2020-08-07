import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.text.MaskFormatter;

public class swimCalc extends JFrame
{
    JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
        JLabel welcome = new JLabel("Welcome to the swimming calculator!", JLabel.CENTER);
        JMenuBar menuBar = new JMenuBar();
       	JMenu options = new JMenu ("Options"),
       		  newForm = new JMenu("New"),
        	  forms = new JMenu("Forms"),
        	  convert = new JMenu("Time Conversions"),
        	  record = new JMenu("Swimmer Files"),
        	  newFile = new JMenu("New");
        	JMenuItem newMeetForm = new JMenuItem("Swim Meet Form"),
        			  newSwimmerForm = new JMenuItem("Swimmer Form"),
        			  relays = new JMenuItem("Relays"),
            		  individual = new JMenuItem("Individual Events"),
                	  mensConversions = new JMenuItem("Men's"),
                	  womensConversions = new JMenuItem("Women's"),
                	  exit = new JMenuItem("Exit");
    BorderLayout layout = new BorderLayout();
    GridLayout layout1 = new GridLayout(12, 3),
               layout2 = new GridLayout(10, 3),
               layout3 = new GridLayout(17, 3),
               layout4 = new GridLayout(13, 3),
               layout5 = new GridLayout(3, 3);
    int a = 0;
    double time = 0,
           time1 = 0,
           time2 = 0,
           time3 = 0,
           time4 = 0,
           time5 = 0,
           time6 = 0,
           time7 = 0,
           time8 = 0,
           time9 = 0,
           time10 = 0,
           timeAverage = 0,
           timeConv = 0;
    int timeMin = 0,
        timeMin1 = 0,
        timeMin2 = 0,
        timeMin3 = 0,
        timeMin4 = 0,
        timeMin5 = 0,
        timeMin6 = 0,
        timeMin7 = 0,
        timeMin8 = 0,
        timeMin9 = 0,
        timeMin10 = 0,
        timeAverageMin = 0,
        timeMinConv = 0;
	DecimalFormat format = new DecimalFormat("00.00");
	DecimalFormat format2 = new DecimalFormat("00");

    JTabbedPane relayPanel = new JTabbedPane();
    	JPanel medRelayPanel = new JPanel(),
               twoFreeRelayPanel = new JPanel(),
               fourFreeRelayPanel = new JPanel();
            JLabel medTime1InputL = new JLabel("Backtroke"),
                   medTime2InputL = new JLabel("Breaststroke"),
                   medTime3InputL = new JLabel("Butterfly"),
                   medTime4InputL = new JLabel("Freestyle"),
                   twoTime1InputL = new JLabel("Lead-off"),
                   twoTime2InputL = new JLabel("Second Leg"),
                   twoTime3InputL = new JLabel("Third Leg"),
                   twoTime4InputL = new JLabel("Anchor"),
                   fourTime1InputL = new JLabel("Lead-off"),
                   fourTime2InputL = new JLabel("Second Leg"),
                   fourTime3InputL = new JLabel("Third Leg"),
                   fourTime4InputL = new JLabel("Anchor"),
                   relayTimeOutput1AverageL = new JLabel("Average Split", JLabel.CENTER),
                   relayTimeOutput2AverageL = new JLabel("Average Split", JLabel.CENTER),
                   relayTimeOutput3AverageL = new JLabel("Average Split", JLabel.CENTER);
            JFormattedTextField medTime1InputF,
                                medTime2InputF,
                                medTime3InputF,
                                medTime4InputF,
                                twoTime1InputF,
                                twoTime2InputF,
                                twoTime3InputF,
                                twoTime4InputF,
                                fourTime1InputF,
                                fourTime2InputF,
                                fourTime3InputF,
                                fourTime4InputF;
            JTextField relayTimeOutput1F = new JTextField("00:00.00"),
            		   relayTimeOutput2F = new JTextField("00:00.00"),
                       relayTimeOutput3F = new JTextField("00:00.00"),
                       relayTimeOutput1AverageF = new JTextField("00:00.00"),
                       relayTimeOutput2AverageF = new JTextField("00:00.00"),
                       relayTimeOutput3AverageF = new JTextField("00:00.00");
            String relayInputTime1 = new String(),
                   relayInputTime2 = new String(),
                   relayInputTime3 = new String(),
             	   relayInputTime4 = new String(),
                   relayInputTime1Min = new String(),
                   relayInputTime2Min = new String(),
                   relayInputTime3Min = new String(),
                   relayInputTime4Min = new String(),
                   relayOutputTime1 = new String();
            JButton relayCalculate1 = new JButton("Calculate"),
                    relayCalculate2 = new JButton("Calculate"),
                    relayCalculate3 = new JButton("Calculate"),
                    relayReset1 = new JButton("Reset"),
                    relayReset2 = new JButton("Reset"),
                    relayReset3 = new JButton("Reset");

	JTabbedPane individualPanel = new JTabbedPane();
    	JPanel fifty = new JPanel(),
               oneHundred = new JPanel();
        JTabbedPane twoHundred = new JTabbedPane();
        	JPanel twoHundredby50s = new JPanel(),
                   twoHundredby100s = new JPanel();
        JTabbedPane fiveHundred     = new JTabbedPane();
        	JPanel fiveHundredby50s = new JPanel(),
                   fiveHundredby100s = new JPanel();
        JLabel fiftyTime1InputL = new JLabel("First 25"),
               fiftyTime2InputL = new JLabel("Second 25"),
               oneHundredTime1InputL = new JLabel("First 50"),
               oneHundredTime2InputL = new JLabel("Second 50"),
               twoHundredby50sTime1InputL = new JLabel("First 50"),
               twoHundredby50sTime2InputL = new JLabel("Second 50"),
               twoHundredby50sTime3InputL = new JLabel("Third 50"),
               twoHundredby50sTime4InputL = new JLabel("Fourth 50"),
               twoHundredby100sTime1InputL = new JLabel("First 100"),
               twoHundredby100sTime2InputL = new JLabel("Second 100"),
               fiveHundredby50sTime1InputL = new JLabel("First 50"),
               fiveHundredby50sTime2InputL = new JLabel("Second 50"),
               fiveHundredby50sTime3InputL = new JLabel("Third 50"),
               fiveHundredby50sTime4InputL = new JLabel("Fourth 50"),
               fiveHundredby50sTime5InputL = new JLabel("Fifth 50"),
               fiveHundredby50sTime6InputL = new JLabel("Sixth 50"),
               fiveHundredby50sTime7InputL = new JLabel("Seventh 50"),
               fiveHundredby50sTime8InputL = new JLabel("Eighth 50"),
               fiveHundredby50sTime9InputL = new JLabel("Ninth 50"),
               fiveHundredby50sTime10InputL = new JLabel("Tenth 50"),
               fiveHundredby100sTime1InputL = new JLabel("First 100"),
               fiveHundredby100sTime2InputL = new JLabel("Second 100"),
               fiveHundredby100sTime3InputL = new JLabel("Third 100"),
               fiveHundredby100sTime4InputL = new JLabel("Fourth 100"),
               fiveHundredby100sTime5InputL = new JLabel("Fifth 100"),
               indTimeOutput1AverageL = new JLabel("Average Split", JLabel.CENTER),
               indTimeOutput2AverageL = new JLabel("Average Split", JLabel.CENTER),
               indTimeOutput3AverageL = new JLabel("Average Split", JLabel.CENTER),
               indTimeOutput4AverageL = new JLabel("Average Split", JLabel.CENTER),
               indTimeOutput5AverageL = new JLabel("Average Split", JLabel.CENTER),
               indTimeOutput6AverageL = new JLabel("Average Split", JLabel.CENTER);
        JFormattedTextField fiftyTime1InputF,
                            fiftyTime2InputF,
                            oneHundredTime1InputF,
                            oneHundredTime2InputF,
                            twoHundredby50sTime1InputF,
                            twoHundredby50sTime2InputF,
                            twoHundredby50sTime3InputF,
                            twoHundredby50sTime4InputF,
                            twoHundredby100sTime1InputF,
                            twoHundredby100sTime2InputF,
                            fiveHundredby50sTime1InputF,
                            fiveHundredby50sTime2InputF,
                            fiveHundredby50sTime3InputF,
                            fiveHundredby50sTime4InputF,
                            fiveHundredby50sTime5InputF,
                            fiveHundredby50sTime6InputF,
                            fiveHundredby50sTime7InputF,
                            fiveHundredby50sTime8InputF,
                            fiveHundredby50sTime9InputF,
                            fiveHundredby50sTime10InputF,
                            fiveHundredby100sTime1InputF,
                            fiveHundredby100sTime2InputF,
                            fiveHundredby100sTime3InputF,
                            fiveHundredby100sTime4InputF,
                            fiveHundredby100sTime5InputF;
        JTextField indTimeOutput1F = new JTextField("00:00.00"),
                   indTimeOutput2F = new JTextField("00:00.00"),
                   indTimeOutput3F = new JTextField("00:00.00"),
                   indTimeOutput4F = new JTextField("00:00.00"),
                   indTimeOutput5F = new JTextField("00:00.00"),
                   indTimeOutput6F = new JTextField("00:00.00"),
                   indTimeOutput1AverageF = new JTextField("00:00.00"),
                   indTimeOutput2AverageF = new JTextField("00:00.00"),
                   indTimeOutput3AverageF = new JTextField("00:00.00"),
                   indTimeOutput4AverageF = new JTextField("00:00.00"),
                   indTimeOutput5AverageF = new JTextField("00:00.00"),
                   indTimeOutput6AverageF = new JTextField("00:00.00");
        String indInputTime1 = new String(),
               indInputTime2 = new String(),
               indInputTime3 = new String(),
               indInputTime4 = new String(),
               indInputTime5 = new String(),
               indInputTime6 = new String(),
               indInputTime7 = new String(),
               indInputTime8 = new String(),
               indInputTime9 = new String(),
               indInputTime10 = new String(),
               indInputTime1Min = new String(),
               indInputTime2Min = new String(),
               indInputTime3Min = new String(),
               indInputTime4Min = new String(),
               indInputTime5Min = new String(),
               indInputTime6Min = new String(),
               indInputTime7Min = new String(),
               indInputTime8Min = new String(),
               indInputTime9Min = new String(),
               indInputTime10Min = new String(),
               indOutputTime1 = new String();
        JButton indCalculate1 = new JButton("Calculate"),
                indCalculate2 = new JButton("Calculate"),
                indCalculate3 = new JButton("Calculate"),
                indCalculate4 = new JButton("Calculate"),
                indCalculate5 = new JButton("Calculate"),
                indCalculate6 = new JButton("Calculate"),
                indReset1 = new JButton("Reset"),
                indReset2 = new JButton("Reset"),
                indReset3 = new JButton("Reset"),
                indReset4 = new JButton("Reset"),
                indReset5 = new JButton("Reset"),
                indReset6 = new JButton("Reset");

    JPanel mensTimeConversionsPanel = new JPanel(),
   		   womensTimeConversionsPanel = new JPanel();
    	JLabel mensConversion1L = new JLabel("Pool Types/Distances", JLabel.CENTER),
    		   mensConversion2L = new JLabel("Events", JLabel.CENTER),
    		   mensConversion3L = new JLabel("Men's Time Conversions", JLabel.CENTER),
    		   womensConversion1L = new JLabel("Pool Types/Distances", JLabel.CENTER),
    		   womensConversion2L = new JLabel("Events", JLabel.CENTER),
    		   womensConversion3L = new JLabel("Women's Time Conversions", JLabel.CENTER);
    	JFormattedTextField mensConversionInputF,
    						womensConversionInputF;
    	JTextField mensConversionOutputF = new JTextField("00:00.00"),
    			   womensConversionOutputF = new JTextField("00:00.00");
		String mensConversionsInputTime = new String(),
			   mensConversionsInputTimeMin = new String(),
			   womensConversionsInputTime = new String(),
			   womensConversionsInputTimeMin = new String(),
			   mensConversionsOutputTime = new String(),
			   mensConversionsOutputTimeMin = new String(),
			   womensConversionsOutputTime = new String(),
			   womensConversionsOutputTimeMin = new String(),
			   optionsCheck = new String(),
			   eventsCheck = new String();
		String[] conversionOptions =
			{"Yards >> Short Course Meters",
			 "Short Course Meters >> Yards",
			 "Yards >> Long Course Meters",
			 "Long Course Meters >> Yards",
			 "Short Course Meters >> Long Course Meters",
			 "Long Course Meters >> Short Course Meters"};
		String[] events =
			{"50 Freestyle",
			 "100 Freestyle",
			 "200 Freestyle",
			 "500/400 Freestyle",
			 "100 Backstroke",
			 "100 Breaststroke",
			 "100 Butterfly",
			 "200 Individual Medley"};
		JButton mensConvert = new JButton("Convert Time"),
				womensConvert = new JButton("Convert Time"),
				mensReset = new JButton("Reset"),
				womensReset = new JButton("Reset");
		JComboBox mensConversionOptions = new JComboBox(conversionOptions),
				  mensConversionEvents = new JComboBox(events),
				  womensConversionOptions = new JComboBox(conversionOptions),
				  womensConversionEvents = new JComboBox(events);

	ActionListener listener1 = new MenuItemListener();
    ActionListener listener2 = new TextFieldListener();
    ActionListener listener3 = new ResetListener();
	ActionListener listener4 = new ConvertFieldListener();

	public swimCalc()
	{
    	panel.setLayout(layout);
        panel.add(welcome, BorderLayout.CENTER);
        menuBar.add(createMenus());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Swimming Calculator");
        frame.setSize(550, 550);
        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.setVisible(true);
        createRelaysPanel();
        createIndividualsPanel();
        createMensTimeConversionsPanel();
        createWomensTimeConversionsPanel();
    }
    public JMenu createMenus()
    {
    	options.add(newForm);
    		newForm.add(newMeetForm);
    			newMeetForm.addActionListener(listener1);
    		newForm.add(newSwimmerForm);
                newSwimmerForm.addActionListener(listener1);
    	options.add(relays);
        	relays.addActionListener(listener1);
        options.add(individual);
        	individual.addActionListener(listener1);
        options.add(convert);
			convert.add(mensConversions);
				mensConversions.addActionListener(listener1);
			convert.add(womensConversions);
				womensConversions.addActionListener(listener1);
    	options.addSeparator();
    	options.add(exit);
    	return options;
    }

class MenuItemListener implements ActionListener
{
    public void actionPerformed(ActionEvent click)
    {
    	Object source = click.getSource();

        if (source == relays)
        {
       		if (a == 0)
        	{
                clearPanel();
                a = 1;
                addPanel();
        	}
        	if (a == 1)
        	{
                clearPanel();
        	    a = 1;
        	    addPanel();
        	}
        	if (a == 2)
        	{
                clearPanel();
        	    a = 1;
        	    addPanel();
        	}
        	if (a == 3)
        	{
                clearPanel();
        	    a = 1;
        	    addPanel();
        	}
        	if (a == 4)
        	{
                clearPanel();
        	    a = 1;
        	    addPanel();
        	}
        	if (a == 5)
        	{
                clearPanel();
        	    a = 1;
        	    addPanel();
        	}
		}
        if (source == individual)
        {
        	if (a == 0)
            {
            	clearPanel();
                a = 2;
                addPanel();
            }
            if (a == 1)
            {
            	clearPanel();
                a = 2;
                addPanel();
            }
            if (a == 2)
            {
            	clearPanel();
                a = 2;
                addPanel();
            }
            if (a == 3)
            {
            	clearPanel();
            	a = 2;
                addPanel();
            }
            if (a == 4)
            {
            	clearPanel();
            	a = 2;
                addPanel();
            }
            if (a == 5)
        	{
        		clearPanel();
        	    a = 2;
        	    addPanel();
        	}
		}
        if (source == mensConversions)
        {
			if (a == 0)
            {
            	clearPanel();
                a = 3;
                addPanel();
            }
            if (a == 1)
            {
            	clearPanel();
                a = 3;
                addPanel();
            }
            if (a == 2)
            {
            	clearPanel();
                a = 3;
                addPanel();
            }
            if (a == 3)
            {
            	clearPanel();
            	a = 3;
                addPanel();
            }
            if (a == 4)
            {
            	clearPanel();
            	a = 3;
                addPanel();
            }
            if (a == 5)
        	{
        		clearPanel();
        	    a = 3;
        	    addPanel();
        	}
        }
        if (source == womensConversions)
        {
        	if (a == 0)
            {
            	clearPanel();
                a = 4;
                addPanel();
            }
            if (a == 1)
            {
            	clearPanel();
                a = 4;
                addPanel();
            }
            if (a == 2)
            {
            	clearPanel();
                a = 4;
                addPanel();
            }
            if (a == 3)
            {
            	clearPanel();
            	a = 4;
                addPanel();
            }
            if (a == 4)
            {
               	clearPanel();
            	a = 4;
                addPanel();
            }
            if (a == 5)
        	{
        		clearPanel();
        	    a = 4;
        	    addPanel();
        	}
        }
       	if (source == newMeetForm)
		{
			new swimMeetForm();
		}
		if (source == newSwimmerForm)
		{
			new swimmerForm();
		}
        if (source == exit)
        {
        	System.exit(0);
        }
	}
}
	public JTabbedPane createRelaysPanel()
	{
    	medRelayPanel.setLayout(layout1);
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            medTime1InputF = new JFormattedTextField(mask);
            medTime1InputF.setValue("00:00.00");
            medRelayPanel.add(medTime1InputL);
            	medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(medTime1InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            medTime2InputF = new JFormattedTextField(mask);
            medTime2InputF.setValue("00:00.00");
            medRelayPanel.add(medTime2InputL);
            	medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(medTime2InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            medTime3InputF = new JFormattedTextField(mask);
            medTime3InputF.setValue("00:00.00");
            medRelayPanel.add(medTime3InputL);
            	medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(medTime3InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            medTime4InputF = new JFormattedTextField(mask);
            medTime4InputF.setValue("00:00.00");
            medRelayPanel.add(medTime4InputL);
            	medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(medTime4InputF);
        }
        catch (ParseException e)
        {
        }
        	medRelayPanel.add(new JLabel(""));
        	medRelayPanel.add(new JLabel(""));
        	medRelayPanel.add(new JLabel(""));
        	medRelayPanel.add(new JLabel(""));
        medRelayPanel.add(relayCalculate1);
        	relayCalculate1.addActionListener(listener2);
        	medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(new JLabel(""));
		medRelayPanel.add(relayTimeOutput1F);
            relayTimeOutput1F.setEditable(false);
            medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(new JLabel(""));
        medRelayPanel.add(relayTimeOutput1AverageL);
        	medRelayPanel.add(new JLabel(""));
        	medRelayPanel.add(new JLabel(""));
        medRelayPanel.add(relayTimeOutput1AverageF);
            relayTimeOutput1AverageF.setEditable(false);
            medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(new JLabel(""));
            medRelayPanel.add(new JLabel(""));
        medRelayPanel.add(relayReset1);
            relayReset1.addActionListener(listener3);
            medRelayPanel.add(new JLabel(""));

        twoFreeRelayPanel.setLayout(layout1);
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoTime1InputF = new JFormattedTextField(mask);
            twoTime1InputF.setValue("00:00.00");
            twoFreeRelayPanel.add(twoTime1InputL);
            	twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(twoTime1InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoTime2InputF = new JFormattedTextField(mask);
        	twoTime2InputF.setValue("00:00.00");
            twoFreeRelayPanel.add(twoTime2InputL);
            	twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(twoTime2InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoTime3InputF = new JFormattedTextField(mask);
            twoTime3InputF.setValue("00:00.00");
            twoFreeRelayPanel.add(twoTime3InputL);
                twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(twoTime3InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoTime4InputF = new JFormattedTextField(mask);
            twoTime4InputF.setValue("00:00.00");
            twoFreeRelayPanel.add(twoTime4InputL);
                twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(twoTime4InputF);
        }
        catch (ParseException e)
        {
        }
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
        twoFreeRelayPanel.add(relayCalculate2);
            relayCalculate2.addActionListener(listener2);
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
        twoFreeRelayPanel.add(relayTimeOutput2F);
            relayTimeOutput2F.setEditable(false);
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
        twoFreeRelayPanel.add(relayTimeOutput2AverageL);
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
        twoFreeRelayPanel.add(relayTimeOutput2AverageF);
            relayTimeOutput2AverageF.setEditable(false);
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
            twoFreeRelayPanel.add(new JLabel(""));
        twoFreeRelayPanel.add(relayReset2);
            relayReset2.addActionListener(listener3);
            twoFreeRelayPanel.add(new JLabel(""));

      	fourFreeRelayPanel.setLayout(layout1);
      	try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fourTime1InputF = new JFormattedTextField(mask);
            fourTime1InputF.setValue("00:00.00");
            fourFreeRelayPanel.add(fourTime1InputL);
                fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(fourTime1InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fourTime2InputF = new JFormattedTextField(mask);
            fourTime2InputF.setValue("00:00.00");
            fourFreeRelayPanel.add(fourTime2InputL);
                fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(fourTime2InputF);
        }
        catch (ParseException e)
        {
        }
		try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fourTime3InputF = new JFormattedTextField(mask);
            fourTime3InputF.setValue("00:00.00");
            fourFreeRelayPanel.add(fourTime3InputL);
            	fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(fourTime3InputF);
        }
        catch (ParseException e)
        {
        }
		try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fourTime4InputF = new JFormattedTextField(mask);
            fourTime4InputF.setValue("00:00.00");
            fourFreeRelayPanel.add(fourTime4InputL);
                fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(fourTime4InputF);
        }
        catch (ParseException e)
        {
        }
        	fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
        fourFreeRelayPanel.add(relayCalculate3);
        	relayCalculate3.addActionListener(listener2);
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
        fourFreeRelayPanel.add(relayTimeOutput3F);
            relayTimeOutput3F.setEditable(false);
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
        fourFreeRelayPanel.add(relayTimeOutput3AverageL);
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
        fourFreeRelayPanel.add(relayTimeOutput3AverageF);
            relayTimeOutput3AverageF.setEditable(false);
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
            fourFreeRelayPanel.add(new JLabel(""));
        fourFreeRelayPanel.add(relayReset3);
            relayReset3.addActionListener(listener3);
            fourFreeRelayPanel.add(new JLabel(""));

        relayPanel.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        relayPanel.addTab("200 Medley Relay", medRelayPanel);
        relayPanel.addTab("200 Freestyle Relay", twoFreeRelayPanel);
        relayPanel.addTab("400 Freestyle Relay", fourFreeRelayPanel);

        return relayPanel;
    }
    public JTabbedPane createIndividualsPanel()
    {
    	fifty.setLayout(layout2);
    	try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiftyTime1InputF = new JFormattedTextField(mask);
            fiftyTime1InputF.setValue("00:00.00");
            fifty.add(fiftyTime1InputL);
                fifty.add(new JLabel(""));
            fifty.add(fiftyTime1InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiftyTime2InputF = new JFormattedTextField(mask);
            fiftyTime2InputF.setValue("00:00.00");
            fifty.add(fiftyTime2InputL);
                fifty.add(new JLabel(""));
            fifty.add(fiftyTime2InputF);
        }
        catch (ParseException e)
        {
        }
        	fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
        fifty.add(indCalculate1);
            indCalculate1.addActionListener(listener2);
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
        fifty.add(indTimeOutput1F);
            indTimeOutput1F.setEditable(false);
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
        fifty.add(indTimeOutput1AverageL);
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
        fifty.add(indTimeOutput1AverageF);
            indTimeOutput1AverageF.setEditable(false);
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
            fifty.add(new JLabel(""));
        fifty.add(indReset1);
            indReset1.addActionListener(listener3);
            fifty.add(new JLabel(""));

        oneHundred.setLayout(layout2);
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            oneHundredTime1InputF = new JFormattedTextField(mask);
            oneHundredTime1InputF.setValue("00:00.00");
            oneHundred.add(oneHundredTime1InputL);
                oneHundred.add(new JLabel(""));
            oneHundred.add(oneHundredTime1InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            oneHundredTime2InputF = new JFormattedTextField(mask);
            oneHundredTime2InputF.setValue("00:00.00");
            oneHundred.add(oneHundredTime2InputL);
                oneHundred.add(new JLabel(""));
            oneHundred.add(oneHundredTime2InputF);
        }
        catch (ParseException e)
        {
        }
        	oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
        oneHundred.add(indCalculate2);
            indCalculate2.addActionListener(listener2);
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
        oneHundred.add(indTimeOutput2F);
            indTimeOutput2F.setEditable(false);
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
        oneHundred.add(indTimeOutput2AverageL);
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
        oneHundred.add(indTimeOutput2AverageF);
            indTimeOutput2AverageF.setEditable(false);
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
            oneHundred.add(new JLabel(""));
        oneHundred.add(indReset2);
            indReset2.addActionListener(listener3);
            oneHundred.add(new JLabel(""));

        twoHundredby50s.setLayout(layout1);
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoHundredby50sTime1InputF = new JFormattedTextField(mask);
            twoHundredby50sTime1InputF.setValue("00:00.00");
            twoHundredby50s.add(twoHundredby50sTime1InputL);
            	twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(twoHundredby50sTime1InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoHundredby50sTime2InputF = new JFormattedTextField(mask);
            twoHundredby50sTime2InputF.setValue("00:00.00");
            twoHundredby50s.add(twoHundredby50sTime2InputL);
                twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(twoHundredby50sTime2InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoHundredby50sTime3InputF = new JFormattedTextField(mask);
            twoHundredby50sTime3InputF.setValue("00:00.00");
            twoHundredby50s.add(twoHundredby50sTime3InputL);
                twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(twoHundredby50sTime3InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoHundredby50sTime4InputF = new JFormattedTextField(mask);
            twoHundredby50sTime4InputF.setValue("00:00.00");
            twoHundredby50s.add(twoHundredby50sTime4InputL);
                twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(twoHundredby50sTime4InputF);
        }
        catch (ParseException e)
        {
        }
        	twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
        twoHundredby50s.add(indCalculate3);
            indCalculate3.addActionListener(listener2);
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
        twoHundredby50s.add(indTimeOutput3F);
            indTimeOutput3F.setEditable(false);
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
        twoHundredby50s.add(indTimeOutput3AverageL);
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
        twoHundredby50s.add(indTimeOutput3AverageF);
            indTimeOutput3AverageF.setEditable(false);
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
            twoHundredby50s.add(new JLabel(""));
        twoHundredby50s.add(indReset3);
            indReset3.addActionListener(listener3);
            twoHundredby50s.add(new JLabel(""));

        twoHundredby100s.setLayout(layout2);
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoHundredby100sTime1InputF = new JFormattedTextField(mask);
            twoHundredby100sTime1InputF.setValue("00:00.00");
            twoHundredby100s.add(twoHundredby100sTime1InputL);
                twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(twoHundredby100sTime1InputF);
        }
/*        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoHundredby100sTime1InputF = new JFormattedTextField(mask);
            twoHundredby100sTime1InputF.setValue("00:00.00");
            twoHundredby100s.add(twoHundredby100sTime1InputL);
                twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(twoHundredby100sTime1InputF);
        }*/
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            twoHundredby100sTime2InputF = new JFormattedTextField(mask);
            twoHundredby100sTime2InputF.setValue("00:00.00");
            twoHundredby100s.add(twoHundredby100sTime2InputL);
                twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(twoHundredby100sTime2InputF);
        }
        catch (ParseException e)
        {
        }
        	twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
        twoHundredby100s.add(indCalculate4);
            indCalculate4.addActionListener(listener2);
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
        twoHundredby100s.add(indTimeOutput4F);
            indTimeOutput4F.setEditable(false);
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
        twoHundredby100s.add(indTimeOutput4AverageL);
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
        twoHundredby100s.add(indTimeOutput4AverageF);
            indTimeOutput4AverageF.setEditable(false);
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
            twoHundredby100s.add(new JLabel(""));
        twoHundredby100s.add(indReset4);
            indReset4.addActionListener(listener3);
            twoHundredby100s.add(new JLabel(""));

        fiveHundredby50s.setLayout(layout3);
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime1InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime1InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime1InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime1InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime2InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime2InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime2InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime2InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime3InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime3InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime3InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime3InputF);
        }
        catch (ParseException e)
        {
        }
		try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime4InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime4InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime4InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime4InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime5InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime5InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime5InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime5InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime6InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime6InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime6InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime6InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime7InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime7InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime7InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime7InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime8InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime8InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime8InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime8InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime9InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime9InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime9InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime9InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby50sTime10InputF = new JFormattedTextField(mask);
            fiveHundredby50sTime10InputF.setValue("00:00.00");
            fiveHundredby50s.add(fiveHundredby50sTime10InputL);
                fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(fiveHundredby50sTime10InputF);
        }
        catch (ParseException e)
        {
        }
        	fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
        fiveHundredby50s.add(indCalculate5);
            indCalculate5.addActionListener(listener2);
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
        fiveHundredby50s.add(indTimeOutput5F);
            indTimeOutput5F.setEditable(false);
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
        fiveHundredby50s.add(indTimeOutput5AverageL);
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
        fiveHundredby50s.add(indTimeOutput5AverageF);
            indTimeOutput5AverageF.setEditable(false);
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
            fiveHundredby50s.add(new JLabel(""));
        fiveHundredby50s.add(indReset5);
            indReset5.addActionListener(listener3);
            fiveHundredby50s.add(new JLabel(""));

        fiveHundredby100s.setLayout(layout4);
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby100sTime1InputF = new JFormattedTextField(mask);
            fiveHundredby100sTime1InputF.setValue("00:00.00");
            fiveHundredby100s.add(fiveHundredby100sTime1InputL);
                fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(fiveHundredby100sTime1InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby100sTime2InputF = new JFormattedTextField(mask);
            fiveHundredby100sTime2InputF.setValue("00:00.00");
            fiveHundredby100s.add(fiveHundredby100sTime2InputL);
                fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(fiveHundredby100sTime2InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby100sTime3InputF = new JFormattedTextField(mask);
            fiveHundredby100sTime3InputF.setValue("00:00.00");
            fiveHundredby100s.add(fiveHundredby100sTime3InputL);
                fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(fiveHundredby100sTime3InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby100sTime4InputF = new JFormattedTextField(mask);
            fiveHundredby100sTime4InputF.setValue("00:00.00");
            fiveHundredby100s.add(fiveHundredby100sTime4InputL);
                fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(fiveHundredby100sTime4InputF);
        }
        catch (ParseException e)
        {
        }
        try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            fiveHundredby100sTime5InputF = new JFormattedTextField(mask);
            fiveHundredby100sTime5InputF.setValue("00:00.00");
            fiveHundredby100s.add(fiveHundredby100sTime5InputL);
                fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(fiveHundredby100sTime5InputF);
        }
        catch (ParseException e)
        {
        }
        	fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
        fiveHundredby100s.add(indCalculate6);
            indCalculate6.addActionListener(listener2);
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
        fiveHundredby100s.add(indTimeOutput6F);
            indTimeOutput6F.setEditable(false);
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
        fiveHundredby100s.add(indTimeOutput6AverageL);
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
        fiveHundredby100s.add(indTimeOutput6AverageF);
            indTimeOutput6AverageF.setEditable(false);
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
            fiveHundredby100s.add(new JLabel(""));
        fiveHundredby100s.add(indReset6);
            indReset6.addActionListener(listener3);
            fiveHundredby100s.add(new JLabel(""));

        individualPanel.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        individualPanel.addTab("50 Yards/Meters", fifty);
        individualPanel.addTab("100 Yards/Meters", oneHundred);
        individualPanel.addTab("200 Yards/Meters", twoHundred);
        individualPanel.addTab("500 Yards/Meters", fiveHundred);
        twoHundred.addTab("Splits by 50's", twoHundredby50s);
        twoHundred.addTab("Splits by 100's", twoHundredby100s);
        fiveHundred.addTab("Splits by 50's", fiveHundredby50s);
        fiveHundred.addTab("Splits by 100's", fiveHundredby100s);

        return individualPanel;
	}
    public JPanel createMensTimeConversionsPanel()
    {
    	mensTimeConversionsPanel.setLayout(layout5);
    	try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            mensConversionInputF = new JFormattedTextField(mask);
            mensConversionInputF.setValue("00:00.00");
            mensTimeConversionsPanel.add(mensConversion1L);
            	mensTimeConversionsPanel.add(mensConversion3L);
            mensTimeConversionsPanel.add(mensConversion2L);
            mensTimeConversionsPanel.add(mensConversionOptions);
			mensTimeConversionsPanel.add(mensReset);
				mensReset.addActionListener(listener3);
            mensTimeConversionsPanel.add(mensConversionEvents);
           	mensTimeConversionsPanel.add(mensConversionInputF);
           	mensTimeConversionsPanel.add(mensConvert);
           		mensConvert.addActionListener(listener4);
           	mensTimeConversionsPanel.add(mensConversionOutputF);
        }
        catch (ParseException e)
        {
        }

    	return mensTimeConversionsPanel;
    }
    public JPanel createWomensTimeConversionsPanel()
    {
    	womensTimeConversionsPanel.setLayout(layout5);
    	try
        {
        	MaskFormatter mask = new MaskFormatter("##':##'.##");
            	mask.setPlaceholderCharacter('0');
            womensConversionInputF = new JFormattedTextField(mask);
            womensConversionInputF.setValue("00:00.00");
            womensTimeConversionsPanel.add(womensConversion1L);
				womensTimeConversionsPanel.add(womensConversion3L);
            womensTimeConversionsPanel.add(womensConversion2L);
            womensTimeConversionsPanel.add(womensConversionOptions);
			womensTimeConversionsPanel.add(womensReset);
				womensReset.addActionListener(listener3);
            womensTimeConversionsPanel.add(womensConversionEvents);
           	womensTimeConversionsPanel.add(womensConversionInputF);
           	womensTimeConversionsPanel.add(womensConvert);
           		womensConvert.addActionListener(listener4);
           	womensTimeConversionsPanel.add(womensConversionOutputF);
        }
        catch (ParseException e)
        {
        }

        return womensTimeConversionsPanel;
    }
	public void clearPanel()
    {
    	if (a == 0)
        {
        	frame.remove(panel);
            frame.setVisible(false);
        }
        if (a == 1)
        {
        	frame.remove(relayPanel);
            frame.setVisible(false);
        }
        if (a == 2)
        {
        	frame.remove(individualPanel);
        	frame.setVisible(false);
        }
        if (a == 3)
        {
        	frame.remove(mensTimeConversionsPanel);
        	frame.setVisible(false);
        }
        if (a == 4)
        {
        	frame.remove(womensTimeConversionsPanel);
        	frame.setVisible(false);
        }
	}
	public void addPanel()
    {
    	if (a == 1)
        {
        	frame.add(relayPanel);
        	frame.setSize(550, 550);
            frame.setVisible(true);
        }
        if (a == 2)
        {
        	frame.add(individualPanel);
        	frame.setSize(550, 550);
            frame.setVisible(true);
        }
        if (a == 3)
        {
        	frame.add(mensTimeConversionsPanel);
        	frame.setSize(800, 150);
            frame.setVisible(true);
        }
        if (a == 4)
        {
        	frame.add(womensTimeConversionsPanel);
        	frame.setSize(800, 150);
            frame.setVisible(true);
        }
	}
class ResetListener implements ActionListener
{
	public void actionPerformed(ActionEvent click)
    {
    	Object source = click.getSource();

    	if (source == relayReset1)
        {
        	relayInputTime1 = "";
            relayInputTime1Min = "";
            	medTime1InputF.setText("00:00.00");
            relayInputTime2 = "";
            relayInputTime2Min = "";
            	medTime2InputF.setText("00:00.00");
            relayInputTime3 = "";
            relayInputTime3Min = "";
            	medTime3InputF.setText("00:00.00");
            relayInputTime4 = "";
            relayInputTime4Min = "";
                medTime4InputF.setText("00:00.00");
            relayOutputTime1 = "";
            	relayTimeOutput1F.setText("00:00.00");
            	relayTimeOutput1AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
        if (source == relayReset2)
        {
        	relayInputTime1 = "";
            relayInputTime1Min = "";
            	twoTime1InputF.setText("00:00.00");
            relayInputTime2 = "";
            relayInputTime2Min = "";
                twoTime2InputF.setText("00:00.00");
            relayInputTime3 = "";
            relayInputTime3Min = "";
                twoTime3InputF.setText("00:00.00");
            relayInputTime4 = "";
            relayInputTime4Min = "";
                twoTime4InputF.setText("00:00.00");
            relayOutputTime1 = "";
            	relayTimeOutput2F.setText("00:00.00");
            	relayTimeOutput2AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
        if (source == relayReset3)
        {
        	relayInputTime1 = "";
            relayInputTime1Min = "";
            	fourTime1InputF.setText("00:00.00");
            relayInputTime2 = "";
            relayInputTime2Min = "";
                fourTime2InputF.setText("00:00.00");
            relayInputTime3 = "";
            relayInputTime3Min = "";
                fourTime3InputF.setText("00:00.00");
            relayInputTime4 = "";
            relayInputTime4Min = "";
                fourTime4InputF.setText("00:00.00");
            relayOutputTime1 = "";
            	relayTimeOutput3F.setText("00:00.00");
            	relayTimeOutput3AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
        if (source == indReset1)
        {
        	indInputTime1 = "";
            indInputTime1Min = "";
            	fiftyTime1InputF.setText("00:00.00");
            indInputTime2 = "";
            indInputTime2Min = "";
            	fiftyTime2InputF.setText("00:00.00");
            indOutputTime1 = "";
            	indTimeOutput1F.setText("00:00.00");
            	indTimeOutput1AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
        if (source == indReset2)
        {
        	indInputTime1 = "";
            indInputTime1Min = "";
            	oneHundredTime1InputF.setText("00:00.00");
            indInputTime2 = "";
            indInputTime2Min = "";
                oneHundredTime2InputF.setText("00:00.00");
            indOutputTime1 = "";
            	indTimeOutput2F.setText("00:00.00");
            	indTimeOutput2AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
        if (source == indReset3)
        {
        	indInputTime1 = "";
            indInputTime1Min = "";
            	twoHundredby50sTime1InputF.setText("00:00.00");
            indInputTime2 = "";
            indInputTime2Min = "";
                twoHundredby50sTime2InputF.setText("00:00.00");
            indInputTime3 = "";
            indInputTime3Min = "";
                twoHundredby50sTime3InputF.setText("00:00.00");
            indInputTime4 = "";
            indInputTime4Min = "";
            	twoHundredby50sTime4InputF.setText("00:00.00");
           	indOutputTime1 = "";
            	indTimeOutput3F.setText("00:00.00");
            	indTimeOutput3AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
        if (source == indReset4)
        {
	        indInputTime1 = "";
            indInputTime1Min = "";
            	twoHundredby100sTime1InputF.setText("00:00.00");
            indInputTime2 = "";
            indInputTime2Min = "";
                twoHundredby100sTime2InputF.setText("00:00.00");
            indOutputTime1 = "";
            	indTimeOutput4F.setText("00:00.00");
            	indTimeOutput4AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
        if (source == indReset5)
        {
        	indInputTime1 = "";
            indInputTime1Min = "";
            	fiveHundredby50sTime1InputF.setText("00:00.00");
            indInputTime2 = "";
           	indInputTime2Min = "";
            	fiveHundredby50sTime2InputF.setText("00:00.00");
            indInputTime3 = "";
            indInputTime3Min = "";
                fiveHundredby50sTime3InputF.setText("00:00.00");
            indInputTime4 = "";
            indInputTime4Min = "";
                fiveHundredby50sTime4InputF.setText("00:00.00");
            indInputTime5 = "";
            indInputTime5Min = "";
            	fiveHundredby50sTime5InputF.setText("00:00.00");
            indInputTime6 = "";
            indInputTime6Min = "";
                fiveHundredby50sTime6InputF.setText("00:00.00");
            indInputTime7 = "";
            indInputTime7Min = "";
                fiveHundredby50sTime7InputF.setText("00:00.00");
            indInputTime8 = "";
            indInputTime8Min = "";
                fiveHundredby50sTime8InputF.setText("00:00.00");
            indInputTime9 = "";
            indInputTime9Min = "";
                fiveHundredby50sTime9InputF.setText("00:00.00");
            indInputTime10 = "";
            indInputTime10Min = "";
                fiveHundredby50sTime10InputF.setText("00:00.00");
            indOutputTime1 = "";
            	indTimeOutput5F.setText("00:00.00");
            	indTimeOutput5AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
        if (source == indReset6)
        {
        	indInputTime1 = "";
            indInputTime1Min = "";
            	fiveHundredby100sTime1InputF.setText("00:00.00");
            indInputTime2 = "";
            indInputTime2Min = "";
                fiveHundredby100sTime2InputF.setText("00:00.00");
            indInputTime3 = "";
            indInputTime3Min = "";
                fiveHundredby100sTime3InputF.setText("00:00.00");
            indInputTime4 = "";
            indInputTime4Min = "";
                fiveHundredby100sTime4InputF.setText("00:00.00");
            indInputTime5 = "";
            indInputTime5Min = "";
                fiveHundredby100sTime5InputF.setText("00:00.00");
            indOutputTime1 = "";
            	indTimeOutput6F.setText("00:00.00");
            	indTimeOutput6AverageF.setText("00:00.00");
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;
		}
		if (source == mensReset)
		{
			mensConversionsInputTime = "";
			mensConversionsInputTimeMin = "";
				mensConversionInputF.setText("00:00.00");
				mensConversionOutputF.setText("00:00.00");
			timeConv = 0;
    		timeMinConv = 0;
    		time = 0;
    		timeMin = 0;
		}
		if (source == womensReset)
		{
			womensConversionsInputTime = "";
			womensConversionsInputTimeMin = "";
				womensConversionInputF.setText("00:00.00");
				womensConversionOutputF.setText("00:00.00");
			timeConv = 0;
    		timeMinConv = 0;
    		time = 0;
    		timeMin = 0;
		}
	}
}
class TextFieldListener implements ActionListener
{
	public void actionPerformed(ActionEvent click)
    {
    	Object source = click.getSource();

        if (source == relayCalculate1)
        {
        	time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            relayInputTime1 = medTime1InputF.getText();
            relayInputTime2 = medTime2InputF.getText();
            relayInputTime3 = medTime3InputF.getText();
            relayInputTime4 = medTime4InputF.getText();

            relayInputTime1Min = relayInputTime1.substring(0, (2));
            	relayInputTime1 = relayInputTime1.substring(3, 8);
          	relayInputTime2Min = relayInputTime2.substring(0, (2));
            	relayInputTime2 = relayInputTime2.substring(3, 8);
            relayInputTime3Min = relayInputTime3.substring(0, (2));
                relayInputTime3 = relayInputTime3.substring(3, 8);
            relayInputTime4Min = relayInputTime4.substring(0, (2));
                relayInputTime4 = relayInputTime4.substring(3, 8);

            time1 = Double.parseDouble(relayInputTime1);
            	timeMin1 = Integer.parseInt(relayInputTime1Min);
            time2 = Double.parseDouble(relayInputTime2);
                timeMin2 = Integer.parseInt(relayInputTime2Min);
            time3 = Double.parseDouble(relayInputTime3);
                timeMin3 = Integer.parseInt(relayInputTime3Min);
            time4 = Double.parseDouble(relayInputTime4);
                timeMin4 = Integer.parseInt(relayInputTime4Min);

            time = time1 + time2 + time3 + time4;
            timeMin = timeMin1 + timeMin2 + timeMin3 + timeMin4;
            timeAverage = ((time1 + time2 + time3 + time4) / 4);
            timeAverageMin = ((timeMin1 + timeMin2 + timeMin3 + timeMin4) / 4);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
                timeAverageMin += 1;
                timeAverage -= 60;
            }
            relayTimeOutput1F.setText(format2.format(timeMin) + ":" + format.format(time));
            relayTimeOutput1AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
		if (source == relayCalculate2)
    	{
        	time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            relayInputTime1 = twoTime1InputF.getText();
            relayInputTime2 = twoTime2InputF.getText();
            relayInputTime3 = twoTime3InputF.getText();
            relayInputTime4 = twoTime4InputF.getText();

            relayInputTime1Min = relayInputTime1.substring(0, (2));
            	relayInputTime1 = relayInputTime1.substring(3, 8);
            relayInputTime2Min = relayInputTime2.substring(0, (2));
                relayInputTime2 = relayInputTime2.substring(3, 8);
            relayInputTime3Min = relayInputTime3.substring(0, (2));
                relayInputTime3 = relayInputTime3.substring(3, 8);
            relayInputTime4Min = relayInputTime4.substring(0, (2));
                relayInputTime4 = relayInputTime4.substring(3, 8);

            time1 = Double.parseDouble(relayInputTime1);
                timeMin1 = Integer.parseInt(relayInputTime1Min);
            time2 = Double.parseDouble(relayInputTime2);
                timeMin2 = Integer.parseInt(relayInputTime2Min);
            time3 = Double.parseDouble(relayInputTime3);
                timeMin3 = Integer.parseInt(relayInputTime3Min);
            time4 = Double.parseDouble(relayInputTime4);
                timeMin4 = Integer.parseInt(relayInputTime4Min);

            time = time1 + time2 + time3 + time4;
            timeMin = timeMin1 + timeMin2 + timeMin3 + timeMin4;
            timeAverage = ((time1 + time2 + time3 + time4) / 4);
            timeAverageMin = ((timeMin1 + timeMin2 + timeMin3 + timeMin4) / 4);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
                timeAverageMin += 1;
                timeAverage -= 60;
            }
            relayTimeOutput2F.setText(format2.format(timeMin) + ":" + format.format(time));
            relayTimeOutput2AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
        if (source == relayCalculate3)
		{
            time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            relayInputTime1 = fourTime1InputF.getText();
            relayInputTime2 = fourTime2InputF.getText();
            relayInputTime3 = fourTime3InputF.getText();
            relayInputTime4 = fourTime4InputF.getText();

            relayInputTime1Min = relayInputTime1.substring(0, (2));
            	relayInputTime1 = relayInputTime1.substring(3, 8);
            relayInputTime2Min = relayInputTime2.substring(0, (2));
                relayInputTime2 = relayInputTime2.substring(3, 8);
            relayInputTime3Min = relayInputTime3.substring(0, (2));
                relayInputTime3 = relayInputTime3.substring(3, 8);
            relayInputTime4Min = relayInputTime4.substring(0, (2));
                relayInputTime4 = relayInputTime4.substring(3, 8);

            time1 = Double.parseDouble(relayInputTime1);
                timeMin1 = Integer.parseInt(relayInputTime1Min);
            time2 = Double.parseDouble(relayInputTime2);
                timeMin2 = Integer.parseInt(relayInputTime2Min);
            time3 = Double.parseDouble(relayInputTime3);
                timeMin3 = Integer.parseInt(relayInputTime3Min);
            time4 = Double.parseDouble(relayInputTime4);
                timeMin4 = Integer.parseInt(relayInputTime4Min);

            time = time1 + time2 + time3 + time4;
            timeMin = timeMin1 + timeMin2 + timeMin3 + timeMin4;
            timeAverage = ((time1 + time2 + time3 + time4) / 4);
            timeAverageMin = ((timeMin1 + timeMin2 + timeMin3 + timeMin4) / 4);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
            	timeAverageMin += 1;
                timeAverage -= 60;
            }
            relayTimeOutput3F.setText(format2.format(timeMin) + ":" + format.format(time));
            relayTimeOutput3AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
        if (source == indCalculate1)
        {
        	time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            indInputTime1 = fiftyTime1InputF.getText();
            indInputTime2 = fiftyTime2InputF.getText();

            indInputTime1Min = indInputTime1.substring(0, (2));
            	indInputTime1 = indInputTime1.substring(3, 8);
            indInputTime2Min = indInputTime2.substring(0, (2));
            	indInputTime2 = indInputTime2.substring(3, 8);

            time1 = Double.parseDouble(indInputTime1);
                timeMin1 = Integer.parseInt(indInputTime1Min);
            time2 = Double.parseDouble(indInputTime2);
                timeMin2 = Integer.parseInt(indInputTime2Min);

            time = time1 + time2;
            timeMin = timeMin1 + timeMin2;
            timeAverage = ((time1 + time2) / 2);
            timeAverageMin = ((timeMin1 + timeMin2) / 2);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
                timeAverageMin += 1;
                timeAverage -= 60;
            }
            indTimeOutput1F.setText(format2.format(timeMin) + ":" + format.format(time));
            indTimeOutput1AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
        if (source == indCalculate2)
        {
        	time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            indInputTime1 = oneHundredTime1InputF.getText();
            indInputTime2 = oneHundredTime2InputF.getText();

            indInputTime1Min = indInputTime1.substring(0, (2));
            	indInputTime1 = indInputTime1.substring(3, 8);
            indInputTime2Min = indInputTime2.substring(0, (2));
                indInputTime2 = indInputTime2.substring(3, 8);

            time1 = Double.parseDouble(indInputTime1);
                timeMin1 = Integer.parseInt(indInputTime1Min);
            time2 = Double.parseDouble(indInputTime2);
                timeMin2 = Integer.parseInt(indInputTime2Min);

            time = time1 + time2;
            timeMin = timeMin1 + timeMin2;
            timeAverage = ((time1 + time2) / 2);
            timeAverageMin = ((timeMin1 + timeMin2) / 2);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
            	timeAverageMin += 1;
                timeAverage -= 60;
            }
            indTimeOutput2F.setText(format2.format(timeMin) + ":" + format.format(time));
            indTimeOutput2AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
        if (source == indCalculate3)
        {
        	time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            indInputTime1 = twoHundredby50sTime1InputF.getText();
            indInputTime2 = twoHundredby50sTime2InputF.getText();
            indInputTime3 = twoHundredby50sTime3InputF.getText();
            indInputTime4 = twoHundredby50sTime4InputF.getText();

            indInputTime1Min = indInputTime1.substring(0, (2));
            	indInputTime1 = indInputTime1.substring(3, 8);
            indInputTime2Min = indInputTime2.substring(0, (2));
                indInputTime2 = indInputTime2.substring(3, 8);
            indInputTime3Min = indInputTime3.substring(0, (2));
                indInputTime3 = indInputTime3.substring(3, 8);
            indInputTime4Min = indInputTime4.substring(0, (2));
               indInputTime4 = indInputTime4.substring(3, 8);

            time1 = Double.parseDouble(indInputTime1);
            	timeMin1 = Integer.parseInt(indInputTime1Min);
            time2 = Double.parseDouble(indInputTime2);
                timeMin2 = Integer.parseInt(indInputTime2Min);
            time3 = Double.parseDouble(indInputTime3);
                timeMin3 = Integer.parseInt(indInputTime3Min);
            time4 = Double.parseDouble(indInputTime4);
                timeMin4 = Integer.parseInt(indInputTime4Min);

            time = time1 + time2 + time3 + time4;
            timeMin = timeMin1 + timeMin2 + timeMin3 + timeMin4;
            timeAverage = ((time1 + time2 + time3 + time4) / 4);
            timeAverageMin = ((timeMin1 + timeMin2 + timeMin3 + timeMin4) / 4);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
                timeAverageMin += 1;
                timeAverage -= 60;
            }
            indTimeOutput3F.setText(format2.format(timeMin) + ":" + format.format(time));
            indTimeOutput3AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
        if (source == indCalculate4)
        {
        	time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            indInputTime1 = twoHundredby100sTime1InputF.getText();
            indInputTime2 = twoHundredby100sTime2InputF.getText();

            indInputTime1Min = indInputTime1.substring(0, (2));
        	    indInputTime1 = indInputTime1.substring(3, 8);
            indInputTime2Min = indInputTime2.substring(0, (2));
                indInputTime2 = indInputTime2.substring(3, 8);

            time1 = Double.parseDouble(indInputTime1);
                timeMin1 = Integer.parseInt(indInputTime1Min);
            time2 = Double.parseDouble(indInputTime2);
                timeMin2 = Integer.parseInt(indInputTime2Min);

            time = time1 + time2;
            timeMin = timeMin1 + timeMin2;
            timeAverage = ((time1 + time2) / 2);
            timeAverageMin = ((timeMin1 + timeMin2) / 2);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
                timeAverageMin += 1;
          		timeAverage -= 60;
            }
            indTimeOutput4F.setText(format2.format(timeMin) + ":" + format.format(time));
            indTimeOutput4AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
        if (source == indCalculate5)
        {
      		time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            indInputTime1 = fiveHundredby50sTime1InputF.getText();
            indInputTime2 = fiveHundredby50sTime2InputF.getText();
            indInputTime3 = fiveHundredby50sTime3InputF.getText();
            indInputTime4 = fiveHundredby50sTime4InputF.getText();
            indInputTime5 = fiveHundredby50sTime5InputF.getText();
            indInputTime6 = fiveHundredby50sTime6InputF.getText();
            indInputTime7 = fiveHundredby50sTime7InputF.getText();
            indInputTime8 = fiveHundredby50sTime8InputF.getText();
            indInputTime9 = fiveHundredby50sTime9InputF.getText();
            indInputTime10 = fiveHundredby50sTime10InputF.getText();

            indInputTime1Min = indInputTime1.substring(0, (2));
            	indInputTime1 = indInputTime1.substring(3, 8);
            indInputTime2Min = indInputTime2.substring(0, (2));
                indInputTime2 = indInputTime2.substring(3, 8);
            indInputTime3Min = indInputTime3.substring(0, (2));
                indInputTime3 = indInputTime3.substring(3, 8);
            indInputTime4Min = indInputTime4.substring(0, (2));
                indInputTime4 = indInputTime4.substring(3, 8);

            time1 = Double.parseDouble(indInputTime1);
                timeMin1 = Integer.parseInt(indInputTime1Min);
            time2 = Double.parseDouble(indInputTime2);
                timeMin2 = Integer.parseInt(indInputTime2Min);
            time3 = Double.parseDouble(indInputTime3);
                timeMin3 = Integer.parseInt(indInputTime3Min);
            time4 = Double.parseDouble(indInputTime4);
                timeMin4 = Integer.parseInt(indInputTime4Min);
            time5 = Double.parseDouble(indInputTime5);
                timeMin5 = Integer.parseInt(indInputTime5Min);
            time6 = Double.parseDouble(indInputTime6);
                timeMin6 = Integer.parseInt(indInputTime6Min);
            time7 = Double.parseDouble(indInputTime7);
                timeMin7 = Integer.parseInt(indInputTime7Min);
            time8 = Double.parseDouble(indInputTime8);
                timeMin8 = Integer.parseInt(indInputTime8Min);
            time9 = Double.parseDouble(indInputTime9);
                timeMin9 = Integer.parseInt(indInputTime9Min);
            time10 = Double.parseDouble(indInputTime10);
                timeMin10 = Integer.parseInt(indInputTime10Min);

            time1 = Double.parseDouble(indInputTime1);
                timeMin1 = Integer.parseInt(indInputTime1Min);
            time2 = Double.parseDouble(indInputTime2);
                timeMin2 = Integer.parseInt(indInputTime2Min);
            time3 = Double.parseDouble(indInputTime3);
            	timeMin3 = Integer.parseInt(indInputTime3Min);
            time4 = Double.parseDouble(indInputTime4);
                timeMin4 = Integer.parseInt(indInputTime4Min);
            time5 = Double.parseDouble(indInputTime5);
                timeMin5 = Integer.parseInt(indInputTime5Min);
            time6 = Double.parseDouble(indInputTime6);
                timeMin6 = Integer.parseInt(indInputTime6Min);
            time7 = Double.parseDouble(indInputTime7);
                timeMin7 = Integer.parseInt(indInputTime7Min);
            time8 = Double.parseDouble(indInputTime8);
                timeMin8 = Integer.parseInt(indInputTime8Min);
            time9 = Double.parseDouble(indInputTime9);
                timeMin9 = Integer.parseInt(indInputTime9Min);
            time10 = Double.parseDouble(indInputTime10);
                timeMin10 = Integer.parseInt(indInputTime10Min);

            time = time1 + time2 + time3 + time4 + time5 + time6 + time7 + time8 + time8 + time10;
            timeMin = timeMin1 + timeMin2 + timeMin3 + timeMin4 + timeMin5 + timeMin6 + timeMin7 + timeMin8 + timeMin8 + timeMin10;
            timeAverage = ((time1 + time2 + time3 + time4 + time5 + time6 + time7 + time8 + time8 + time10) / 10);
            timeAverageMin = ((timeMin1 + timeMin2 + timeMin3 + timeMin4 + timeMin5 + timeMin6 + timeMin7 + timeMin8 + timeMin9 + timeMin10) / 10);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
            	timeAverageMin += 1;
                timeAverage -= 60;
            }
            indTimeOutput5F.setText(format2.format(timeMin)+ ":" + format.format(time));
            indTimeOutput5AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
        if (source == indCalculate6)
        {
        	time = 0;
            time1 = 0;
            time2 = 0;
            time3 = 0;
            time4 = 0;
            time5 = 0;
            time6 = 0;
            time7 = 0;
            time8 = 0;
            time9 = 0;
            time10 = 0;
            timeMin = 0;
            timeAverage = 0;
            timeAverageMin = 0;
            timeMin = 0;
            timeMin1 = 0;
            timeMin2 = 0;
            timeMin3 = 0;
            timeMin4 = 0;
            timeMin5 = 0;
            timeMin6 = 0;
            timeMin7 = 0;
            timeMin8 = 0;
            timeMin9 = 0;
            timeMin10 = 0;

            indInputTime1 = fiveHundredby100sTime1InputF.getText();
            indInputTime2 = fiveHundredby100sTime2InputF.getText();
            indInputTime3 = fiveHundredby100sTime3InputF.getText();
            indInputTime4 = fiveHundredby100sTime4InputF.getText();
            indInputTime5 = fiveHundredby100sTime5InputF.getText();

            indInputTime1Min = indInputTime1.substring(0, (2));
            	indInputTime1 = indInputTime1.substring(3, 8);
            indInputTime2Min = indInputTime2.substring(0, (2));
                indInputTime2 = indInputTime2.substring(3, 8);
            indInputTime3Min = indInputTime3.substring(0, (2));
                indInputTime3 = indInputTime3.substring(3, 8);
            indInputTime4Min = indInputTime4.substring(0, (2));
                indInputTime4 = indInputTime4.substring(3, 8);
            indInputTime5Min = indInputTime5.substring(0, (2));
            	indInputTime5 = indInputTime5.substring(3, 8);

            time1 = Double.parseDouble(indInputTime1);
            	timeMin1 = Integer.parseInt(indInputTime1Min);
            time2 = Double.parseDouble(indInputTime2);
                timeMin2 = Integer.parseInt(indInputTime2Min);
            time3 = Double.parseDouble(indInputTime3);
                timeMin3 = Integer.parseInt(indInputTime3Min);
            time4 = Double.parseDouble(indInputTime4);
                timeMin4 = Integer.parseInt(indInputTime4Min);
            time5 = Double.parseDouble(indInputTime5);
                timeMin5 = Integer.parseInt(indInputTime5Min);

            time = time1 + time2 + time3 + time4 + time5;
            timeMin = timeMin1 + timeMin2 + timeMin3 + timeMin4 + timeMin5;
            timeAverage = ((time1 + time2 + time3 + time4 + time5) / 5);
            timeAverageMin = ((timeMin1 + timeMin2 + timeMin3 + timeMin4 + timeMin5) / 5);

            while (time > 60)
            {
            	timeMin += 1;
                time -= 60;
            }
            while (timeAverage > 60)
            {
            	timeAverageMin += 1;
                timeAverage -= 60;
            }
            indTimeOutput6F.setText(format2.format(timeMin) + ":" + format.format(time));
            indTimeOutput6AverageF.setText(format2.format(timeAverageMin) + ":" + format.format(timeAverage));
		}
    }
}
class ConvertFieldListener implements ActionListener
{
	public void actionPerformed(ActionEvent click)
    {
    	Object source = click.getSource();

    	timeConv = 0;
    	timeMinConv = 0;
    	time = 0;
    	timeMin = 0;

    	if (source == mensConvert)
    	{
    		mensConversionsInputTime = mensConversionInputF.getText();

    		mensConversionsInputTimeMin = mensConversionsInputTime.substring(0, (2));
            	mensConversionsInputTime = mensConversionsInputTime.substring(3, 8);

            time = Double.parseDouble(mensConversionsInputTime);
            	timeMin = Integer.parseInt(mensConversionsInputTimeMin);

            optionsCheck = (String) mensConversionOptions.getSelectedItem();
            eventsCheck = (String) mensConversionEvents.getSelectedItem();

            if (optionsCheck == "Yards >> Short Course Meters")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1043;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1029;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1070;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8656;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1130;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1105;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0956;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1049;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
    		if (optionsCheck == "Short Course Meters >> Yards")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0181) * 0.8641);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0190) * 0.8669);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0217) * 0.8663);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0151) * 1.1048);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0319) * 0.8546);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0131) * 0.8592);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0031) * 0.8851);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0219) * 0.8576);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
        	if (optionsCheck == "Yards >> Long Course Yards")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1573;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1535;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1543;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9051;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1701;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1639;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1298;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1660;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
            if (optionsCheck == "Long Course Meters >> Yards")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8641;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8669;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8663;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1048;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8546;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8638;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8851;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8576;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
            if (optionsCheck == "Short Course Meters >> Long Course Meters")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0181;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0190;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0217;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0151;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0319;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0131;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0031;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0219;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
            if (optionsCheck == "Long Course Meters >> Short Course Meters")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9822;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9814;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9788;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9851;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9691;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9871;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9969;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9786;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		mensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
    	}
		if (source == womensConvert)
    	{
    		womensConversionsInputTime = womensConversionInputF.getText();

    		womensConversionsInputTimeMin = womensConversionsInputTime.substring(0, (2));
            	womensConversionsInputTime = womensConversionsInputTime.substring(3, 8);

            time = Double.parseDouble(womensConversionsInputTime);
            	timeMin = Integer.parseInt(womensConversionsInputTimeMin);

            optionsCheck = (String) womensConversionOptions.getSelectedItem();
            eventsCheck = (String) womensConversionEvents.getSelectedItem();

            if (optionsCheck == "Yards >> Short Course Meters")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1125;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1004;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1017;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8634;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0986;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1160;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0986;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1029;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
    		if (optionsCheck == "Short Course Meters >> Yards")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0146) * 0.8979);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0090) * 0.8728);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0090) * 0.8768);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0079) * 1.1291);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0182) * 0.8761);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0118) * 0.8753);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0009) * 0.8904);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = ((time * 1.0130) * 0.8826);
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
        	if (optionsCheck == "Yards >> Long Course Meters")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1137;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1457;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1405;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8857;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1414;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1425;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1231;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1330;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
            if (optionsCheck == "Long Course Meters >> Yards")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8979;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8728;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8768;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.1291;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8761;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8753;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8904;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.8826;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
            if (optionsCheck == "Short Course Meters >> Long Course Meters")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0146;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0090;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0090;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0079;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0182;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0118;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0009;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 1.0130;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
            if (optionsCheck == "Long Course Meters >> Short Course Meters")
            {
            	if (eventsCheck == "50 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9856;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9911;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(timeMinConv + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9911;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "500/400 Freestyle")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9922;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Backstroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9821;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Breaststroke")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9883;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "100 Butterfly")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9991;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            	if (eventsCheck == "200 Individual Medley")
            	{
            		while (timeMin > 0)
            		{
            			timeMin -= 1;
            			time +=60;
            		}
            		timeConv = time * 0.9872;
            		while (timeConv > 60)
            		{
            			timeConv -= 60;
            			timeMinConv += 1;
            		}
            		womensConversionOutputF.setText(format2.format(timeMinConv) + ":" + format.format(timeConv));
            	}
            }
    	}
	}
}
}