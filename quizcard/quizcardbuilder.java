import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

class quizcardbuilder{
	JTextArea question;
	JTextArea answer;
	ArrayList<quizcard> cardList;
	JFrame frame;
	
	void go(){//building gui
		frame = new JFrame("Quiz Card Builder");//setting frame
		JPanel mainPanel = new JPanel();//setting panel
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
	
		Font bigFont = new Font("sanserif",Font.BOLD,24);
		
		JLabel qLabel = new JLabel("Question:");
		qLabel.setFont(bigFont);
		question = new JTextArea(6,20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);
		JScrollPane qScroller = new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JLabel aLabel = new JLabel("Answer:");
		aLabel.setFont(bigFont);
		
		answer = new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);
		JScrollPane aScroller = new JScrollPane(answer);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next Card");
		nextButton.addActionListener(new NextCardListener());
		
		
		cardList = new ArrayList<quizcard>();// when gui will run carList object can add lists now...
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		
		JMenuBar menubar = new JMenuBar();
		
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(new NewMenuListener());
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new SaveMenuListener());
		
		JMenu fileMenu = new JMenu("File");
		
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menubar.add(fileMenu);
		frame.setJMenuBar(menubar);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		
		frame.setSize(400,600);
		frame.setVisible(true);
		
	}
	
	public class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			quizcard card = new quizcard(question.getText(),answer.getText());
			cardList.add(card);
			clearCard();
		}
	}
	void clearCard(){
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
	public class SaveMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			quizcard card = new quizcard(question.getText(),answer.getText());
			cardList.add(card);
			
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			System.out.println(fileSave.getSelectedFile());
			saveFile(fileSave.getSelectedFile());
		}
	}
	void saveFile(File file){
		try{
			FileWriter fwrite = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fwrite);
			
			for(quizcard card:cardList){
				writer.write(card.q+"/");
				writer.write(card.a+"\n");
			}
			
			writer.close();
			
		}catch(IOException ex){
			System.out.println("couldn't write the cardlist out");
			ex.printStackTrace();
		}
	}
	public class NewMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			cardList.clear();
			clearCard();
		}
	}
	
	
}
