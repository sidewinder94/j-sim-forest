package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class FenÍtreSave {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenÍtreSave window = new FenÍtreSave();
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
	public FenÍtreSave() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 354, 214);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("30px"),
				ColumnSpec.decode("193px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("95px"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				RowSpec.decode("23px"),
				RowSpec.decode("65px"),
				RowSpec.decode("23px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JComboBox comboBox = new JComboBox();
		frame.getContentPane().add(comboBox, "2, 2, fill, center");
		
		JButton btnParcourir = new JButton("Parcourir");
		frame.getContentPane().add(btnParcourir, "4, 2, fill, center");
		
		JButton btnNewButton = new JButton("Sauvegarder");
		frame.getContentPane().add(btnNewButton, "2, 4, left, center");
		
		JButton btnImporter = new JButton("Importer");
		frame.getContentPane().add(btnImporter, "4, 4, fill, center");
		
		JButton btnQuitter = new JButton("Quitter");
		frame.getContentPane().add(btnQuitter, "4, 6, fill, default");
	}

}
