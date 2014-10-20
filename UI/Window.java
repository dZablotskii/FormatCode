import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
class Window{
	private static JTextArea textAreaRead;
	private static JTextArea textAreaWrite;
	public void set(){
		JFrame frame = new JFrame("Format");
		frame.setSize(1000,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JButton format = new JButton("Format");    
		JButton delete = new JButton("Delete");

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout());
		panelButton.add(format);
		panelButton.add(delete);

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
}