package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;

public class Fenêtre {

	private JFrame frame;
	private JTextField txtChoixPas;
	private JTextField txtDlai;
	private JButton btnNewButton;
	private JComboBox comboBox;
	private JLabel lblDensits;
	private JLabel lblJeunesPousses;
	private JLabel lblArbustes;
	private JLabel lblArbres;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnPleincran;
	private JButton btnLancerLaSimulation;
	private JPanel panel;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenêtre window = new Fenêtre();
					window.frame.setVisible(true);
					//UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fenêtre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 80, 151, 0, 58, 73, 0};
		gridBagLayout.rowHeights = new int[]{0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.gridheight = 8;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		textPane = new JTextPane();
		panel.add(textPane);
		
		lblDensits = new JLabel("Densit\u00E9s :");
		GridBagConstraints gbc_lblDensits = new GridBagConstraints();
		gbc_lblDensits.anchor = GridBagConstraints.WEST;
		gbc_lblDensits.insets = new Insets(0, 0, 5, 5);
		gbc_lblDensits.gridx = 4;
		gbc_lblDensits.gridy = 2;
		frame.getContentPane().add(lblDensits, gbc_lblDensits);
		
		lblJeunesPousses = new JLabel("Jeunes Pousses :");
		GridBagConstraints gbc_lblJeunesPousses = new GridBagConstraints();
		gbc_lblJeunesPousses.anchor = GridBagConstraints.WEST;
		gbc_lblJeunesPousses.insets = new Insets(0, 0, 5, 5);
		gbc_lblJeunesPousses.gridx = 4;
		gbc_lblJeunesPousses.gridy = 3;
		frame.getContentPane().add(lblJeunesPousses, gbc_lblJeunesPousses);
		
		lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 3;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		lblArbustes = new JLabel("Arbustes :");
		GridBagConstraints gbc_lblArbustes = new GridBagConstraints();
		gbc_lblArbustes.anchor = GridBagConstraints.WEST;
		gbc_lblArbustes.insets = new Insets(0, 0, 5, 5);
		gbc_lblArbustes.gridx = 4;
		gbc_lblArbustes.gridy = 4;
		frame.getContentPane().add(lblArbustes, gbc_lblArbustes);
		
		lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 4;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblArbres = new JLabel("Arbres :");
		GridBagConstraints gbc_lblArbres = new GridBagConstraints();
		gbc_lblArbres.anchor = GridBagConstraints.WEST;
		gbc_lblArbres.insets = new Insets(0, 0, 5, 5);
		gbc_lblArbres.gridx = 4;
		gbc_lblArbres.gridy = 5;
		frame.getContentPane().add(lblArbres, gbc_lblArbres);
		
		lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 5;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		btnPleincran = new JButton("Plein \u00C9cran");
		GridBagConstraints gbc_btnPleincran = new GridBagConstraints();
		gbc_btnPleincran.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPleincran.insets = new Insets(0, 0, 5, 5);
		gbc_btnPleincran.gridx = 4;
		gbc_btnPleincran.gridy = 6;
		frame.getContentPane().add(btnPleincran, gbc_btnPleincran);
		
		btnLancerLaSimulation = new JButton("Lancer la simulation");
		GridBagConstraints gbc_btnLancerLaSimulation = new GridBagConstraints();
		gbc_btnLancerLaSimulation.insets = new Insets(0, 0, 5, 5);
		gbc_btnLancerLaSimulation.gridx = 4;
		gbc_btnLancerLaSimulation.gridy = 7;
		frame.getContentPane().add(btnLancerLaSimulation, gbc_btnLancerLaSimulation);
		
		txtChoixPas = new JTextField();
		txtChoixPas.setText("Choix pas");
		GridBagConstraints gbc_txtChoixPas = new GridBagConstraints();
		gbc_txtChoixPas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChoixPas.insets = new Insets(0, 0, 5, 5);
		gbc_txtChoixPas.gridx = 1;
		gbc_txtChoixPas.gridy = 9;
		frame.getContentPane().add(txtChoixPas, gbc_txtChoixPas);
		txtChoixPas.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choix simulation catastrophe"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 9;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		txtDlai = new JTextField();
		txtDlai.setText("D\u00E9lai");
		GridBagConstraints gbc_txtDlai = new GridBagConstraints();
		gbc_txtDlai.insets = new Insets(0, 0, 5, 5);
		gbc_txtDlai.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDlai.gridx = 1;
		gbc_txtDlai.gridy = 10;
		frame.getContentPane().add(txtDlai, gbc_txtDlai);
		txtDlai.setColumns(10);
		
		btnNewButton = new JButton("Importation/sauvegarde");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	}

}
