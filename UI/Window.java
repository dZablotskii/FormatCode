import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import ru.omsu.Reader;
import ru.omsu.Format;
class Window{
	private static JTextArea textAreaRead;
	private static JTextArea textAreaWrite;
	private static JTextField saveNameFile;
	public void set(){
		JFrame frame = new JFrame("Format");
		frame.setSize(1000,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JButton format = new JButton("Format");    
		JButton delete = new JButton("Delete");

		JButton save = new JButton("Save");
		saveNameFile = new JTextField(15);
		JPanel panelSave = new JPanel();
		JLabel saveFileLabel = new JLabel("Enter name of new file");
		panelSave.add(save);
		panelSave.add(saveFileLabel);
		panelSave.setBorder(BorderFactory.createEmptyBorder(0,200,0,0));
		panelSave.add(saveNameFile);

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout());
		panelButton.add(format);
		panelButton.add(delete);
		panelButton.add(panelSave);

		textAreaRead = new JTextArea();
		textAreaRead.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		textAreaRead.setFont(new Font("Courier", Font.PLAIN, 14));
		textAreaWrite = new JTextArea();
		textAreaWrite.setFont(new Font("Courier", Font.PLAIN, 14));
		textAreaWrite.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		JPanel panelText = new JPanel();
		panelText.setLayout(new GridLayout());
		panelText.add(textAreaRead);
		panelText.add(textAreaWrite);

		frame.add(panelText,BorderLayout.CENTER);
		frame.add(panelButton,BorderLayout.PAGE_END);

		format.addActionListener(new FormatActionListener());
		delete.addActionListener(new DeleteActionListener());
		save.addActionListener(new SaveActionListener());
		frame.setVisible(true);	
		
	}
	public class FormatActionListener implements ActionListener{
		@Override 
		public void actionPerformed(ActionEvent e){
			try{
				textAreaWrite.setText("");
				BufferedWriter bw = new BufferedWriter(new FileWriter("WrongCode.txt"));
				String s1 = textAreaRead.getText();
				bw.write(s1);
				s1 = null;
				bw.close();
				Reader r = new Reader();
				Format format = new Format();
				ExceptionBrackets ex = new ExceptionBrackets();
				r.ini();
				char prev = 'a';
				char post = r.read();
				char c = post;
				String s="";
				while(c!='`'){
					post = r.read();
					s = format.check(prev,c,post);
					if(c!='`'){
						textAreaWrite.setText(textAreaWrite.getText()+s);
					}
					prev = c;
					c = post;			
				}
			}
			catch(Exception ex){System.out.println("ERROR");}
			
		}
	}
	public class DeleteActionListener implements ActionListener{
		@Override 
		public void actionPerformed(ActionEvent e){
			textAreaWrite.setText("");
			textAreaRead.setText("");
		}
	}
	public class SaveActionListener implements ActionListener{
		@Override 
		public void actionPerformed(ActionEvent e){
			try{
				BufferedWriter bw = new BufferedWriter(new FileWriter(saveNameFile.getText()));
				bw.write(textAreaWrite.getText());
				bw.close();
			}catch(Exception ec){}
		}
	}
}
