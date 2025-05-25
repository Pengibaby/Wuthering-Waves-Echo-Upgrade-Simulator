import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class MainWindow {

	private JLabel[] substatNameLabelList = new JLabel[5];
	private JLabel[] substatValueLabelList = new JLabel[5];
	private OneCostPiece currentOneCostPiece = null;
	private ThreeCostPiece currentThreeCostPiece = null;
	private FourCostPiece currentFourCostPiece = null;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Wuthering Waves Echo Rolling Simulator");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		/* Testing echo pieces code.
		FourCostPiece piece = new FourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneFourCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneFourCostPiece();
		piece.printInfo();
		System.out.println();
		End of testing echo pieces code.
		*/
		
		//Labels for Echo name
		JLabel EchoLabel = new JLabel("Echo:");
		EchoLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		EchoLabel.setBounds(60, 50, 139, 25);
		frame.getContentPane().add(EchoLabel);
		
		JLabel PieceNameLabel = new JLabel("?");
		PieceNameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		PieceNameLabel.setBounds(197, 50, 220, 26);
		frame.getContentPane().add(PieceNameLabel);
		
		//Current level of echo Label
		JLabel currentLevelLabel = new JLabel("Level:");
		currentLevelLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		currentLevelLabel.setBounds(60, 127, 76, 25);
		frame.getContentPane().add(currentLevelLabel);
		
		JLabel currentLevelValueLabel = new JLabel("?");
		currentLevelValueLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		currentLevelValueLabel.setBounds(138, 127, 76, 25);
		frame.getContentPane().add(currentLevelValueLabel);
		
		//Labels for main stat name and value
		JLabel mainStatNameLabel = new JLabel("?");
		mainStatNameLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		mainStatNameLabel.setBounds(60, 163, 308, 25);
		frame.getContentPane().add(mainStatNameLabel);
		
		JLabel mainStatValueLabel = new JLabel("?");
		mainStatValueLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		mainStatValueLabel.setBounds(378, 163, 102, 25);
		frame.getContentPane().add(mainStatValueLabel);
		
		//Labels for secondary stat name and value
		JLabel secondaryStatNameLabel = new JLabel("?");
		secondaryStatNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		secondaryStatNameLabel.setBounds(60, 199, 308, 25);
		frame.getContentPane().add(secondaryStatNameLabel);
		
		JLabel secondaryStatValueLabel = new JLabel("?");
		secondaryStatValueLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		secondaryStatValueLabel.setBounds(378, 199, 102, 25);
		frame.getContentPane().add(secondaryStatValueLabel);
		
		//Separator to separate the main stat from the sub stats
		JSeparator separator = new JSeparator();
		separator.setBounds(48, 235, 359, 2);
		frame.getContentPane().add(separator);
		
		//substat names and labels
		JLabel substatOneNameLabel = new JLabel("?");
		substatOneNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatOneNameLabel.setBounds(60, 267, 308, 14);
		frame.getContentPane().add(substatOneNameLabel);
		
		JLabel substatOneValueLabel = new JLabel("?");
		substatOneValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatOneValueLabel.setBounds(378, 267, 102, 14);
		frame.getContentPane().add(substatOneValueLabel);
		
		JLabel substatTwoNameLabel = new JLabel("?");
		substatTwoNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatTwoNameLabel.setBounds(60, 320, 308, 14);
		frame.getContentPane().add(substatTwoNameLabel);
		
		JLabel substatTwoValueLabel = new JLabel("?");
		substatTwoValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatTwoValueLabel.setBounds(378, 320, 102, 14);
		frame.getContentPane().add(substatTwoValueLabel);
		
		JLabel substatThreeNameLabel = new JLabel("?");
		substatThreeNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatThreeNameLabel.setBounds(60, 373, 308, 14);
		frame.getContentPane().add(substatThreeNameLabel);
		
		JLabel substatThreeValueLabel = new JLabel("?");
		substatThreeValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatThreeValueLabel.setBounds(378, 373, 102, 14);
		frame.getContentPane().add(substatThreeValueLabel);
		
		JLabel substatFourNameLabel = new JLabel("?");
		substatFourNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatFourNameLabel.setBounds(60, 426, 308, 14);
		frame.getContentPane().add(substatFourNameLabel);
		
		JLabel substatFourValueLabel = new JLabel("?");
		substatFourValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatFourValueLabel.setBounds(378, 426, 102, 14);
		frame.getContentPane().add(substatFourValueLabel);
		
		JLabel substatFiveNameLabel = new JLabel("?");
		substatFiveNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatFiveNameLabel.setBounds(60, 479, 308, 14);
		frame.getContentPane().add(substatFiveNameLabel);
		
		JLabel substatFiveValueLabel = new JLabel("?");
		substatFiveValueLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		substatFiveValueLabel.setBounds(378, 479, 102, 14);
		frame.getContentPane().add(substatFiveValueLabel);
		
		
		//Add substat name labels to list
		this.substatNameLabelList[0] = substatOneNameLabel;
		this.substatNameLabelList[1] = substatTwoNameLabel;
		this.substatNameLabelList[2] = substatThreeNameLabel;
		this.substatNameLabelList[3] = substatFourNameLabel;
		this.substatNameLabelList[4] = substatFiveNameLabel;
		
		//Add substat value labels to list
		this.substatValueLabelList[0] = substatOneValueLabel;
		this.substatValueLabelList[1] = substatTwoValueLabel;
		this.substatValueLabelList[2] = substatThreeValueLabel;
		this.substatValueLabelList[3] = substatFourValueLabel;
		this.substatValueLabelList[4] = substatFiveValueLabel;
		
		
		//Get an Echo button.
		JButton GetAnEchoButton = new JButton("Get an Echo");
		GetAnEchoButton.setBounds(510, 64, 178, 46);
		frame.getContentPane().add(GetAnEchoButton);
		
		//Upgrade to next rank button.
		JButton UpgradeToNextRankButton = new JButton("Upgrade to next rank");
		UpgradeToNextRankButton.setBounds(510, 142, 178, 46);
		frame.getContentPane().add(UpgradeToNextRankButton);
		UpgradeToNextRankButton.setEnabled(false);
		
		//Tune the echo button.
		JButton TuneEchoButton = new JButton("Tune Echo");
		TuneEchoButton.setBounds(510, 220, 178, 46);
		frame.getContentPane().add(TuneEchoButton);
		TuneEchoButton.setEnabled(false);
		
		
		//Set the function for GetAnEchoButton.
		GetAnEchoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Set all echoes to null to reset everything.
				currentOneCostPiece = null;
				currentThreeCostPiece = null;
				currentFourCostPiece = null;
				
				//generated a random integer between 0 and 2 both inclusive
				int randomInteger = (int)(Math.random() * 3);
				
				//Decide which echoes to generate, then set the labels
				if(randomInteger == 0) {
					//1-cost echo
					currentOneCostPiece = new OneCostPiece();
					PieceNameLabel.setText(currentOneCostPiece.getEchoName());
					currentLevelValueLabel.setText("+" + String.valueOf(currentOneCostPiece.getCurrentLevel()));
					mainStatNameLabel.setText(currentOneCostPiece.getMainStatName());
					mainStatValueLabel.setText(String.valueOf(currentOneCostPiece.getMainStatValue()));
					secondaryStatNameLabel.setText(currentOneCostPiece.getSecondStatName());
					secondaryStatValueLabel.setText(String.valueOf(currentOneCostPiece.getSecondStatValue()));
					for(int i = 0; i < 5; i++) {
						substatNameLabelList[i].setText(currentOneCostPiece.getSubstatNames()[i]);
						substatValueLabelList[i].setText(String.valueOf(currentOneCostPiece.getSubstatValues()[i]));
					}
				} else if(randomInteger == 1) {
					//3-cost echo
					currentThreeCostPiece = new ThreeCostPiece();
					PieceNameLabel.setText(currentThreeCostPiece.getEchoName());
					currentLevelValueLabel.setText("+" + String.valueOf(currentThreeCostPiece.getCurrentLevel()));
					mainStatNameLabel.setText(currentThreeCostPiece.getMainStatName());
					mainStatValueLabel.setText(String.valueOf(currentThreeCostPiece.getMainStatValue()));
					secondaryStatNameLabel.setText(currentThreeCostPiece.getSecondStatName());
					secondaryStatValueLabel.setText(String.valueOf(currentThreeCostPiece.getSecondStatValue()));
					for(int i = 0; i < 5; i++) {
						substatNameLabelList[i].setText(currentThreeCostPiece.getSubstatNames()[i]);
						substatValueLabelList[i].setText(String.valueOf(currentThreeCostPiece.getSubstatValues()[i]));
					}
				} else {
					//4-cost echo
					currentFourCostPiece = new FourCostPiece();
					PieceNameLabel.setText(currentFourCostPiece.getEchoName());
					currentLevelValueLabel.setText("+" + String.valueOf(currentFourCostPiece.getCurrentLevel()));
					mainStatNameLabel.setText(currentFourCostPiece.getMainStatName());
					mainStatValueLabel.setText(String.valueOf(currentFourCostPiece.getMainStatValue()));
					secondaryStatNameLabel.setText(currentFourCostPiece.getSecondStatName());
					secondaryStatValueLabel.setText(String.valueOf(currentFourCostPiece.getSecondStatValue()));
					for(int i = 0; i < 5; i++) {
						substatNameLabelList[i].setText(currentFourCostPiece.getSubstatNames()[i]);
						substatValueLabelList[i].setText(String.valueOf(currentFourCostPiece.getSubstatValues()[i]));
					}
				}
				
				//Enable the upgrade button
				UpgradeToNextRankButton.setEnabled(true);
			}
		});
	}

}
