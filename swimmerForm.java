import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.print.*;
import java.io.*;
import java.text.*;
import javax.swing.text.MaskFormatter;

public class swimmerForm
{
    JFrame swimmerFormFrame = new JFrame();
        JTabbedPane swimmerFormPane = new JTabbedPane();
            JPanel swimmerFormPanelYards = new JPanel(),
                   swimmerFormPanelShortCourseMeters = new JPanel(),
                   swimmerFormPanelLongCourseMeters = new JPanel();
                GridLayout layout7 = new GridLayout(19, 4);
                JMenuBar swimmerFormMenuBar = new JMenuBar();
                    JMenu swimmerFormFileMenu = new JMenu("File");
                        JMenuItem openSwimmerForm = new JMenuItem("Open"),
                        		  saveSwimmerForm = new JMenuItem("Save"),
                            	  printSwimmerForm = new JMenuItem("Print"),
                                  closeSwimmerForm = new JMenuItem("Close");
                JLabel[] swimmerNameL = new JLabel[4],
                    eventsL = new JLabel[4],
                    mostRecentTimeL = new JLabel[4],
                    bestTimeL = new JLabel[4],
                    butterflyL = new JLabel[4],
                    backstrokeL = new JLabel[4],
                    breaststrokeL = new JLabel[4],
                    freestyleL = new JLabel[4],
                    individualMedleyL = new JLabel[4],
                    distance50L = new JLabel[17],
                    distance100L = new JLabel[21],
                    distance200L = new JLabel[7],
                    distance500L = new JLabel[4];
            JTextField[] swimmerNameF = new JTextField[4],
                mostRecentTimeF = new JTextField[37],
                bestTimeF = new JTextField[37];
        JButton[] enterNewTimeB = new JButton[37];
	JFileChooser swimmerFormFileChooser = new JFileChooser();
	//JOptionPane addNewTime = new JOptionPane();
	ActionListener listener6 = new swimmerFormMenuListener();
	ActionListener listener7 = new addNewTimeListener();
//	ActionListener listener8 = new getNewTimeListener();

	public swimmerForm()
	{
            for (int j = 1; j < 4; j++)
            {
                initializeSwimmerNameL(j);
                initializeEventsL(j);
                initializeMostRecentTimeL(j);
                initializeBestTimeL(j);
                initializeButterflyL(j);
                initializeBackstrokeL(j);
                initializeBreaststrokeL(j);
                initializeFreestyleL(j);
                initializeIndividualMedleyL(j);
                initializeDistance500L(j);
                initializeSwimmerName(j);
            }
            for(int i = 1; i < 17; i++)
            {
                    initializeDistance50L(i);
            }
            for(int h = 1; h < 21; h++)
            {
                initializeDistance100L(h);
            }
            for(int k = 1; k < 7; k++)
            {
                initializeDistance200L(k);
            }
            for(int g = 1; g < 37; g++)
            {
                initializeMostRecentTimeF(g);
                initializeBestTimeF(g);
                initializeEnterNewTimeB(g);
            }
            createSwimmerFormPane();
            swimmerFormMenuBar.add(createSwimmerFormMenuBar());
            swimmerFormFrame.setTitle("Swimmer Form");
            swimmerFormFrame.setSize(525, 600);
            swimmerFormFrame.setJMenuBar(swimmerFormMenuBar);
            swimmerFormFrame.add(swimmerFormPane);
            swimmerFormFrame.setVisible(true);
	}
    public JLabel initializeSwimmerNameL(int j)
    {
        swimmerNameL[j] = new JLabel("Swimmer's Name");
        return swimmerNameL[j];
    }
    public JLabel initializeEventsL(int j)
    {
        eventsL[j] = new JLabel("Events");
        return eventsL[j];
    }
    public JLabel initializeMostRecentTimeL(int j)
    {
       mostRecentTimeL[j] = new JLabel("Most Recent Time");
        return mostRecentTimeL[j];
    }
    public JLabel initializeBestTimeL(int j)
    {
        bestTimeL[j] = new JLabel("Best Time");
        return bestTimeL[j];
    }
    public JButton initializeEnterNewTimeB(int g)
    {
        enterNewTimeB[g] = new JButton("Enter New Time");
        enterNewTimeB[g].addActionListener(listener7);
        return enterNewTimeB[g];
    }
    public JLabel initializeButterflyL(int j)
    {
        butterflyL[j] = new JLabel("Butterfly");
        return butterflyL[j];
    }
    public JLabel initializeBackstrokeL(int j)
    {
        backstrokeL[j] = new JLabel("Backstroke");
        return backstrokeL[j];
    }
    public JLabel initializeBreaststrokeL(int j)
    {
        breaststrokeL[j] = new JLabel("Breaststroke");
        return breaststrokeL[j];
    }
    public JLabel initializeFreestyleL(int j)
    {
        freestyleL[j] = new JLabel("Freestyle");
        return freestyleL[j];
    }
    public JLabel initializeIndividualMedleyL(int j)
    {
        individualMedleyL[j] = new JLabel("Individual Medley");
        return individualMedleyL[j];
    }
    public JLabel initializeDistance50L(int i)
    {
        distance50L[i] = new JLabel("50", JLabel.RIGHT);
        return distance50L[i];
    }
    public JLabel initializeDistance100L(int h)
    {
        distance100L[h] = new JLabel("100", JLabel.RIGHT);
        return distance100L[h];
    }
    public JLabel initializeDistance200L(int k)
    {
        distance200L[k] = new JLabel("200", JLabel.RIGHT);
        return distance200L[k];
    }
    public JLabel initializeDistance500L(int j)
    {
        distance500L[j] = new JLabel("500", JLabel.RIGHT);
        return distance500L[j];
    }
    public JTextField initializeSwimmerName(int j)
    {
        swimmerNameF[j] = new JTextField("");
        swimmerNameF[j].setEditable(true);
        return swimmerNameF[j];
    }
    public JTextField initializeMostRecentTimeF(int g)
    {
        mostRecentTimeF[g] = new JTextField("00:00.00");
        mostRecentTimeF[g].setEditable(false);
    	return mostRecentTimeF[g];
    }
    public JTextField initializeBestTimeF(int g)
    {
        bestTimeF[g] = new JTextField("00:00.00");
        bestTimeF[g].setEditable(false);
        return bestTimeF[g];
    }
    public JMenu createSwimmerFormMenuBar()
    {
        swimmerFormFileMenu.add(openSwimmerForm);
            openSwimmerForm.addActionListener(listener6);
		swimmerFormFileMenu.add(saveSwimmerForm);
			saveSwimmerForm.addActionListener(listener6);
    	swimmerFormFileMenu.add(printSwimmerForm);
            printSwimmerForm.addActionListener(listener6);
        swimmerFormFileMenu.addSeparator();
    	swimmerFormFileMenu.add(closeSwimmerForm);
            closeSwimmerForm.addActionListener(listener6);
    	return swimmerFormFileMenu;
    }
    public JTabbedPane createSwimmerFormPane()
    {
        swimmerFormPanelYards.setLayout(layout7);

        swimmerFormPanelYards.add(swimmerNameL[1]);
        swimmerFormPanelYards.add(swimmerNameF[1]);
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
        swimmerFormPanelYards.add(eventsL[1]);
        swimmerFormPanelYards.add(mostRecentTimeL[1]);
        swimmerFormPanelYards.add(bestTimeL[1]);
            swimmerFormPanelYards.add(new JLabel(""));
        swimmerFormPanelYards.add(butterflyL[1]);
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
        swimmerFormPanelYards.add(distance50L[1]);
        swimmerFormPanelYards.add(mostRecentTimeF[1]);
        swimmerFormPanelYards.add(bestTimeF[1]);
        swimmerFormPanelYards.add(enterNewTimeB[1]);
        swimmerFormPanelYards.add(distance100L[1]);
        swimmerFormPanelYards.add(mostRecentTimeF[2]);
        swimmerFormPanelYards.add(bestTimeF[2]);
        swimmerFormPanelYards.add(enterNewTimeB[2]);
        swimmerFormPanelYards.add(backstrokeL[1]);
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
        swimmerFormPanelYards.add(distance50L[2]);
        swimmerFormPanelYards.add(mostRecentTimeF[3]);
        swimmerFormPanelYards.add(bestTimeF[3]);
        swimmerFormPanelYards.add(enterNewTimeB[3]);
        swimmerFormPanelYards.add(distance100L[2]);
        swimmerFormPanelYards.add(mostRecentTimeF[4]);
        swimmerFormPanelYards.add(bestTimeF[4]);
        swimmerFormPanelYards.add(enterNewTimeB[4]);
        swimmerFormPanelYards.add(breaststrokeL[1]);
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
        swimmerFormPanelYards.add(distance50L[3]);
        swimmerFormPanelYards.add(mostRecentTimeF[5]);
        swimmerFormPanelYards.add(bestTimeF[5]);
        swimmerFormPanelYards.add(enterNewTimeB[5]);
        swimmerFormPanelYards.add(distance100L[3]);
        swimmerFormPanelYards.add(mostRecentTimeF[6]);
        swimmerFormPanelYards.add(bestTimeF[6]);
        swimmerFormPanelYards.add(enterNewTimeB[6]);
        swimmerFormPanelYards.add(freestyleL[1]);
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
        swimmerFormPanelYards.add(distance50L[4]);
        swimmerFormPanelYards.add(mostRecentTimeF[7]);
        swimmerFormPanelYards.add(bestTimeF[7]);
        swimmerFormPanelYards.add(enterNewTimeB[7]);
        swimmerFormPanelYards.add(distance100L[4]);
        swimmerFormPanelYards.add(mostRecentTimeF[8]);
        swimmerFormPanelYards.add(bestTimeF[8]);
        swimmerFormPanelYards.add(enterNewTimeB[8]);
        swimmerFormPanelYards.add(distance200L[1]);
        swimmerFormPanelYards.add(mostRecentTimeF[9]);
        swimmerFormPanelYards.add(bestTimeF[9]);
        swimmerFormPanelYards.add(enterNewTimeB[9]);
        swimmerFormPanelYards.add(distance500L[1]);
        swimmerFormPanelYards.add(mostRecentTimeF[10]);
        swimmerFormPanelYards.add(bestTimeF[10]);
        swimmerFormPanelYards.add(enterNewTimeB[10]);
        swimmerFormPanelYards.add(individualMedleyL[1]);
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
            swimmerFormPanelYards.add(new JLabel(""));
        swimmerFormPanelYards.add(distance100L[5]);
        swimmerFormPanelYards.add(mostRecentTimeF[11]);
        swimmerFormPanelYards.add(bestTimeF[11]);
        swimmerFormPanelYards.add(enterNewTimeB[11]);
        swimmerFormPanelYards.add(distance200L[2]);
        swimmerFormPanelYards.add(mostRecentTimeF[12]);
        swimmerFormPanelYards.add(bestTimeF[12]);
        swimmerFormPanelYards.add(enterNewTimeB[12]);

        swimmerFormPanelShortCourseMeters.setLayout(layout7);

        swimmerFormPanelShortCourseMeters.add(swimmerNameL[2]);
        swimmerFormPanelShortCourseMeters.add(swimmerNameF[2]);
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
        swimmerFormPanelShortCourseMeters.add(eventsL[2]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeL[2]);
        swimmerFormPanelShortCourseMeters.add(bestTimeL[2]);
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
        swimmerFormPanelShortCourseMeters.add(butterflyL[2]);
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
        swimmerFormPanelShortCourseMeters.add(distance50L[5]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[13]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[13]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[13]);
        swimmerFormPanelShortCourseMeters.add(distance100L[6]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[14]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[14]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[14]);
        swimmerFormPanelShortCourseMeters.add(backstrokeL[2]);
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
        swimmerFormPanelShortCourseMeters.add(distance50L[6]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[15]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[15]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[15]);
        swimmerFormPanelShortCourseMeters.add(distance100L[7]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[16]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[16]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[16]);
        swimmerFormPanelShortCourseMeters.add(breaststrokeL[2]);
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
        swimmerFormPanelShortCourseMeters.add(distance50L[7]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[17]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[17]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[17]);
        swimmerFormPanelShortCourseMeters.add(distance100L[8]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[18]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[18]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[18]);
        swimmerFormPanelShortCourseMeters.add(freestyleL[2]);
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
        swimmerFormPanelShortCourseMeters.add(distance50L[8]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[19]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[19]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[19]);
        swimmerFormPanelShortCourseMeters.add(distance100L[9]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[20]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[20]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[20]);
        swimmerFormPanelShortCourseMeters.add(distance200L[3]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[21]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[21]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[21]);
        swimmerFormPanelShortCourseMeters.add(distance500L[2]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[22]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[22]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[22]);
        swimmerFormPanelShortCourseMeters.add(individualMedleyL[2]);
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
            swimmerFormPanelShortCourseMeters.add(new JLabel(""));
        swimmerFormPanelShortCourseMeters.add(distance100L[10]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[23]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[23]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[23]);
        swimmerFormPanelShortCourseMeters.add(distance200L[4]);
        swimmerFormPanelShortCourseMeters.add(mostRecentTimeF[24]);
        swimmerFormPanelShortCourseMeters.add(bestTimeF[24]);
        swimmerFormPanelShortCourseMeters.add(enterNewTimeB[24]);

        swimmerFormPanelLongCourseMeters.setLayout(layout7);

        swimmerFormPanelLongCourseMeters.add(swimmerNameL[3]);
        swimmerFormPanelLongCourseMeters.add(swimmerNameF[3]);
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
        swimmerFormPanelLongCourseMeters.add(eventsL[3]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeL[3]);
        swimmerFormPanelLongCourseMeters.add(bestTimeL[3]);
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
        swimmerFormPanelLongCourseMeters.add(butterflyL[3]);
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
        swimmerFormPanelLongCourseMeters.add(distance50L[11]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[25]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[25]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[25]);
        swimmerFormPanelLongCourseMeters.add(distance100L[12]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[26]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[26]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[26]);
        swimmerFormPanelLongCourseMeters.add(backstrokeL[3]);
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
        swimmerFormPanelLongCourseMeters.add(distance50L[12]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[27]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[27]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[27]);
        swimmerFormPanelLongCourseMeters.add(distance100L[13]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[28]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[28]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[28]);
        swimmerFormPanelLongCourseMeters.add(breaststrokeL[3]);
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
        swimmerFormPanelLongCourseMeters.add(distance50L[13]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[29]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[29]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[29]);
        swimmerFormPanelLongCourseMeters.add(distance100L[14]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[30]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[30]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[30]);
        swimmerFormPanelLongCourseMeters.add(freestyleL[3]);
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
        swimmerFormPanelLongCourseMeters.add(distance50L[14]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[31]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[31]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[31]);
        swimmerFormPanelLongCourseMeters.add(distance100L[15]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[32]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[32]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[32]);
        swimmerFormPanelLongCourseMeters.add(distance200L[5]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[33]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[33]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[33]);
        swimmerFormPanelLongCourseMeters.add(distance500L[3]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[34]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[34]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[34]);
        swimmerFormPanelLongCourseMeters.add(individualMedleyL[3]);
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
            swimmerFormPanelLongCourseMeters.add(new JLabel(""));
        swimmerFormPanelLongCourseMeters.add(distance100L[16]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[35]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[35]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[35]);
        swimmerFormPanelLongCourseMeters.add(distance200L[6]);
        swimmerFormPanelLongCourseMeters.add(mostRecentTimeF[36]);
        swimmerFormPanelLongCourseMeters.add(bestTimeF[36]);
        swimmerFormPanelLongCourseMeters.add(enterNewTimeB[36]);

        swimmerFormPane.addTab("Yards", swimmerFormPanelYards);
        swimmerFormPane.addTab("Short Course Meters", swimmerFormPanelShortCourseMeters);
        swimmerFormPane.addTab("Long Course Meters", swimmerFormPanelLongCourseMeters);

		return swimmerFormPane;
	}
	class swimmerFormMenuListener implements ActionListener
	{
            public void actionPerformed(ActionEvent click)
            {
                Object source = click.getSource();

/*                if (source == openSwimmerForm)
                {
                	try
                	{
                	int saveSwimmerFormValue = new swimmerFormFileChooser.showSaveDialog(saveSwimmerForm);
                    File selFile = swimmerFormFileChooser.getSelectedFile();
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selFile));

                    swimmerNameF[1].write(bufferedWriter);
                    	bufferedWriter.newLine();

					mostRecentTimeF[1].write(bufferedWriter);
                   		bufferedWriter.newLine();
                   	bestTimeF[1].write(bufferedWriter);
                }*/
                if (source == saveSwimmerForm)
                {
                	int eventNumber = 1;
                	try
                	{
		            	int saveSwimmerFormValue = swimmerFormFileChooser.showSaveDialog(saveSwimmerForm);
		                File selFile = swimmerFormFileChooser.getSelectedFile();
		                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selFile));

		                swimmerNameF[1].write(bufferedWriter);
		                	bufferedWriter.newLine();
						while (eventNumber <= 37)
						{
							mostRecentTimeF[eventNumber].write(bufferedWriter);
		               			bufferedWriter.newLine();
		               		bestTimeF[eventNumber].write(bufferedWriter);
		               			bufferedWriter.newLine();

		               		eventNumber = eventNumber + 1;
						}
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
                if (source == printSwimmerForm)
                {
                	swimmerNameF[1].setEditable(false);
                	swimmerNameF[2].setEditable(false);
                	swimmerNameF[3].setEditable(false);
					PrintUtilities.printComponent(swimmerFormPanelYards);
					PrintUtilities.printComponent(swimmerFormPanelShortCourseMeters);
					PrintUtilities.printComponent(swimmerFormPanelLongCourseMeters);
					swimmerNameF[1].setEditable(true);
					swimmerNameF[2].setEditable(true);
					swimmerNameF[3].setEditable(true);
                }
                if (source == closeSwimmerForm)
                {
                    swimmerFormFrame.dispose();
                }
            }
	}
	class addNewTimeListener implements ActionListener
	{
            public void actionPerformed(ActionEvent click)
            {
            	try
            	{

            		JFrame frame = new JFrame("New Time");
			        JPanel panel = new JPanel(new BorderLayout(5,3));
			        panel.add(new JLabel("Enter New Time: "), BorderLayout.WEST);

			        MaskFormatter mask = new MaskFormatter("##':##'.##");
			        	mask.setPlaceholderCharacter('0');
			        JFormattedTextField text = new JFormattedTextField(mask);
			        JButton addTimeB = new JButton("Add Time");

			        panel.add(text, BorderLayout.CENTER);
			 //       panel.add(new JLabel(""));
			        frame.add(panel);
			        frame.add(addTimeB, BorderLayout.EAST);
			        frame.setSize(400, 75);
					frame.setVisible(true);
            	}
            	        catch (ParseException e)
            	        {
            	        }
            }
//            class getNewTimeListener implements ActionListener
//            {
//            }
/*            	new addNewTime();
            	System.out.println("TRUE2");
               new addNewTimeDialog();
				try
        		{


        			MaskFormatter mask = new MaskFormatter("##':##'.##");
            			mask.setPlaceholderCharacter('0');

            		JFormattedTextField newTime = new JFormattedTextField(mask);
//            		newTime.setValue("00:00.00");
//					mask.install(addNewTime);
					JOptionPane addNewTime = new JOptionPane(JOptionPane.QUESTION_MESSAGE);
//					addNewTime.add(mask);
					addNewTime.showInputDialog("Enter New Time:", newTime);

					String newTimeS = "00:00.00";
					newTimeS.add();
//						= newTime.getValue();
        		}
/*		try
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

/*    		int saveSwimmerFormValue = swimmerFormFileChooser.showSaveDialog();
                File selFile = swimmerFormFileChooser.getSelectedFile();
                try
                {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selFile));
                }
                catch (IOException ex)
                {
                    Logger.getLogger(swimmerForm.class.getName()).log(Level.SEVERE, null, ex);
                }

		}*/
    		}
//	}
}