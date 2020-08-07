import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class addNewTime
{
	public void createTimeDialog(String response) throws ParseException
	{
            JFrame frame = new JFrame();
            JPanel panel = new JPanel( new BorderLayout(5,0) );
            panel.add(new JLabel("Enter New Time: "), BorderLayout.WEST);

            MaskFormatter mask = new MaskFormatter("##':##.'##");
        	mask.setPlaceholderCharacter('0');
            JFormattedTextField text = new JFormattedTextField(mask);
            text.setValue("00:00.00");
            panel.add(text);
            frame.add(panel);
		frame.setVisible(true);

            response = text.getText();
            System.out.println("TRUE1");
            return;
	}
}