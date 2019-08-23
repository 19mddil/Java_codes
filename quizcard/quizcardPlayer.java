import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

class quizcardPlayer{
	JTextArea display,answer;
	ArrayList<quizcard>cardList;
	quizcard currentCard;
	int currentCardIndex;
	JFrame frame;
	JButton nextButton;
	boolean isShowAnswer;
	
	void go(){
		frame = new JFrame("Quiz Card Player");
		JPanel mainPanel = new JPanel();
		
		Font bigFont = new Font("sanserif",Font.BOLD,24);
		
		display = new JTextArea(10,20);
		display.setFont(bigFont);
		display.setEditable(false);/////uuuu check it
		
		JScrollPane qScroller = new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		nextButton = new JButton("Show Question");
		mainPanel.add(qScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar = new JMenuBar();
		JMenuItem loadMenuItem = new JMenuItem("Load Set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		JMenu fileMenu = new JMenu("File");
		
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(640,500);
		frame.setVisible(true);
		
		
		
		
	}
	
	public class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			if(isShowAnswer){//for first time false
				display.setText(currentCard.a);
				nextButton.setText("Next Card");
				isShowAnswer = false;
			}
			else{
				if(currentCardIndex < cardList.size()){//so load the cardList from save file...
					showNextCard();
				}else{
					display.setText("That was the last card");
					nextButton.setEnabled(false);//uuuuu need to work on it...
				}
			}
		}
	}
	
	void showNextCard(){
		currentCard = cardList.get(currentCardIndex);
		display.setText(currentCard.q);
		nextButton.setText("Show Answer");
		isShowAnswer = true;
		currentCardIndex++;
	}
	
	public class OpenMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
	}
	
	
	void loadFile(File file){
		cardList = new ArrayList<quizcard>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine())!= null){
				makeCard(line);
			}
			reader.close();
		}catch(Exception ex){
			
		}
		//showNextCard();
	}
	
	void makeCard(String l){
		String[] result = l.split("/");
		quizcard card = new quizcard(result[0],result[1]);
		cardList.add(card);
	}
	
}
