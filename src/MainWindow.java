import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainWindow {

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Testing echo pieces code.
		OneCostPiece piece = new OneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.levelOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneOneCostPiece();
		piece.printInfo();
		System.out.println();
		piece.tuneOneCostPiece();
		piece.printInfo();
		System.out.println();
		//End of testing echo pieces code.
	}

}
