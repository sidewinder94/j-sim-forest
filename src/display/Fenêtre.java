package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Settings.GridSizes;
import Settings.Etats;
import Settings.Mode;
import Settings.CellSizes;
//TODO : Renommer l'ensemble des contrôles de la fenêtre
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
	private JButton btnQuitter;
	private JScrollPane scrollPane;
	private FenêtreSave Importation;
	private JComboBox comboBox_1;
	private JLabel lblChoixTaille;
	private JButton btnNewButton_1;
	private JLabel lblTailleDuneCellule;
	private JComboBox comboBox_2;
	private AffGrille grid;

	/**
	 * Classe MouseListener permettant de réaliser des actions souris sur les controles
	 */
	static class MouseAbstractListener implements MouseListener
	{
		protected Object data;
		
		public MouseAbstractListener()
		{
			this.data = null;
		}
		
		public MouseAbstractListener(Object data)
		{
			this.data = data;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}
		
	}
	
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
		frame.setMinimumSize(new Dimension(650, 360));
		frame.setBounds(100, 100, 650, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 80, 151, 72, 36, 58, 73, 0};
		gridBagLayout.rowHeights = new int[]{0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.gridheight = 9;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		lblDensits = new JLabel("Densit\u00E9s :");
		GridBagConstraints gbc_lblDensits = new GridBagConstraints();
		gbc_lblDensits.anchor = GridBagConstraints.WEST;
		gbc_lblDensits.insets = new Insets(0, 0, 5, 5);
		gbc_lblDensits.gridx = 5;
		gbc_lblDensits.gridy = 2;
		frame.getContentPane().add(lblDensits, gbc_lblDensits);
		
		lblJeunesPousses = new JLabel("Jeunes Pousses :");
		GridBagConstraints gbc_lblJeunesPousses = new GridBagConstraints();
		gbc_lblJeunesPousses.anchor = GridBagConstraints.WEST;
		gbc_lblJeunesPousses.insets = new Insets(0, 0, 5, 5);
		gbc_lblJeunesPousses.gridx = 5;
		gbc_lblJeunesPousses.gridy = 3;
		frame.getContentPane().add(lblJeunesPousses, gbc_lblJeunesPousses);
		
		lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 3;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		lblArbustes = new JLabel("Arbustes :");
		GridBagConstraints gbc_lblArbustes = new GridBagConstraints();
		gbc_lblArbustes.anchor = GridBagConstraints.WEST;
		gbc_lblArbustes.insets = new Insets(0, 0, 5, 5);
		gbc_lblArbustes.gridx = 5;
		gbc_lblArbustes.gridy = 4;
		frame.getContentPane().add(lblArbustes, gbc_lblArbustes);
		
		lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 4;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblArbres = new JLabel("Arbres :");
		GridBagConstraints gbc_lblArbres = new GridBagConstraints();
		gbc_lblArbres.anchor = GridBagConstraints.WEST;
		gbc_lblArbres.insets = new Insets(0, 0, 5, 5);
		gbc_lblArbres.gridx = 5;
		gbc_lblArbres.gridy = 5;
		frame.getContentPane().add(lblArbres, gbc_lblArbres);
		
		lblNewLabel_2 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 5;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		btnPleincran = new JButton("Plein \u00C9cran");
		GridBagConstraints gbc_btnPleincran = new GridBagConstraints();
		gbc_btnPleincran.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPleincran.insets = new Insets(0, 0, 5, 5);
		gbc_btnPleincran.gridx = 5;
		gbc_btnPleincran.gridy = 6;
		frame.getContentPane().add(btnPleincran, gbc_btnPleincran);
		
		btnLancerLaSimulation = new JButton("Lancer la simulation");
		GridBagConstraints gbc_btnLancerLaSimulation = new GridBagConstraints();
		gbc_btnLancerLaSimulation.insets = new Insets(0, 0, 5, 5);
		gbc_btnLancerLaSimulation.gridx = 5;
		gbc_btnLancerLaSimulation.gridy = 7;
		frame.getContentPane().add(btnLancerLaSimulation, gbc_btnLancerLaSimulation);
		
		lblTailleDuneCellule = new JLabel("Taille d'une cellule : ");
		GridBagConstraints gbc_lblTailleDuneCellule = new GridBagConstraints();
		gbc_lblTailleDuneCellule.anchor = GridBagConstraints.WEST;
		gbc_lblTailleDuneCellule.insets = new Insets(0, 0, 5, 5);
		gbc_lblTailleDuneCellule.gridx = 5;
		gbc_lblTailleDuneCellule.gridy = 8;
		frame.getContentPane().add(lblTailleDuneCellule, gbc_lblTailleDuneCellule);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(CellSizes.values()));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.BOTH;
		gbc_comboBox_2.gridx = 6;
		gbc_comboBox_2.gridy = 8;
		frame.getContentPane().add(comboBox_2, gbc_comboBox_2);
		
		lblChoixTaille = new JLabel("Choix Taille :");
		GridBagConstraints gbc_lblChoixTaille = new GridBagConstraints();
		gbc_lblChoixTaille.insets = new Insets(0, 0, 5, 5);
		gbc_lblChoixTaille.anchor = GridBagConstraints.WEST;
		gbc_lblChoixTaille.gridx = 1;
		gbc_lblChoixTaille.gridy = 11;
		frame.getContentPane().add(lblChoixTaille, gbc_lblChoixTaille);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(GridSizes.values()));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 11;
		frame.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		btnNewButton_1 = new JButton("G\u00E9n\u00E9rer la grille");
		btnNewButton_1.addMouseListener(new MouseAbstractListener(this.scrollPane){
			@Override
			public void mouseClicked(MouseEvent e)
			{
				JScrollPane pane = (JScrollPane)this.data;
				grid = new AffGrille();
				
				GridSizes gridSize = (GridSizes)comboBox_1.getSelectedItem();
				CellSizes cellSize = (CellSizes)comboBox_2.getSelectedItem();
				
				grid.setTaille(gridSize.getEtats());
				grid.setCote(cellSize.getCellSize());
				int size = gridSize.getEtats() * cellSize.getCellSize();
				
				grid.setPreferredSize(new Dimension(size,size));
				pane.setViewportView(grid);
				
				grid.addMouseMotionListener(new MouseMotionListener() {

					@Override//Useless
					public void mouseDragged(MouseEvent arg0) {}

					@Override
					public void mouseMoved(MouseEvent arg0) 
					{
						grid.repaint();
					}
				});// Repeint jp2 lorsque la souris se déplace
				grid.addMouseListener(new MouseAbstractListener()
				{
					public void mouseClicked(MouseEvent arg0)
					{
						super.mouseClicked(arg0);
						JOptionPane.showMessageDialog(null, "Tuile n° " + grid.numero);
					}
				});
			}
			
			
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 11;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		txtChoixPas = new JTextField();
		txtChoixPas.setText("Choix pas");
		GridBagConstraints gbc_txtChoixPas = new GridBagConstraints();
		gbc_txtChoixPas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtChoixPas.insets = new Insets(0, 0, 5, 5);
		gbc_txtChoixPas.gridx = 1;
		gbc_txtChoixPas.gridy = 12;
		frame.getContentPane().add(txtChoixPas, gbc_txtChoixPas);
		txtChoixPas.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Mode.values()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 12;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		txtDlai = new JTextField();
		txtDlai.setText("D\u00E9lai");
		GridBagConstraints gbc_txtDlai = new GridBagConstraints();
		gbc_txtDlai.insets = new Insets(0, 0, 0, 5);
		gbc_txtDlai.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDlai.gridx = 1;
		gbc_txtDlai.gridy = 13;
		frame.getContentPane().add(txtDlai, gbc_txtDlai);
		txtDlai.setColumns(10);
		
		btnNewButton = new JButton("Importation/sauvegarde");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 13;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnQuitter = new JButton("Quitter");
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuitter.gridx = 6;
		gbc_btnQuitter.gridy = 13;
		frame.getContentPane().add(btnQuitter, gbc_btnQuitter);
		btnPleincran.addMouseListener(new MouseAbstractListener()
		{
			public void mouseClicked(MouseEvent e) 
			{
			Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
	    	Dimension screenSize = defaultToolkit .getScreenSize();
		    	frame.setSize(screenSize);
		    	frame.setLocation(0, 0);
			}
		});
		
		
		
		btnQuitter.addMouseListener(new MouseAbstractListener()
		{
			public void mouseClicked(MouseEvent e) 
			{
				frame.dispose();
			}
		});
		
		
		btnNewButton.addMouseListener(new MouseAbstractListener()
		{
			public void mouseClicked(MouseEvent e) 
			{
				if(Importation != null)
				{
					Importation.getFrame().setVisible(true);
				}
				else
				{
					Importation = new FenêtreSave();
					Importation.getFrame().setVisible(true);
				}
			}
		});
	}
}

@SuppressWarnings("serial")
class AffGrille extends JPanel { // Classe personnelle qui crée une grile
	// hexagonale.
	int cote; // Ceci définit la taille du côté d'un polygone
	private int taille; //Nombre de polygones de cotés
	int numero = 0; // Retien le n° du polygone sur lequel est la souris
	Polygon pol;

	//Getters - Setters
	public int getTaille() {
		return taille;
	}

	public int getCote() {
		return cote;
	}

	public void setCote(int cote) {
		this.cote = cote;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	
	@Override
	public void paint(Graphics arg0) {
		Polygon p2 = getPolygon(0, 0, cote); // Crée un hexagone
		Rectangle r = p2.getBounds(); // Récupère le plus petit rectangle // aux
		// bord de la fenêtre dans lequel
		// l'hexagone peut s'inscrire
		Point hovered = null;
		arg0.setColor(Color.black);
		super.paint(arg0);
		Graphics2D g2d;
		g2d = (Graphics2D) arg0;
		BasicStroke bs1 = new BasicStroke(1);// Permet de fixer l'épaisseur du
		// trait dans la suite
		BasicStroke bs3 = new BasicStroke(3);// Idem
		g2d.setStroke(bs1);
		for (int l = 0; l < this.taille; l++) {// hauteur

			for (int c = 0; c < this.taille; c++) {// largeur
				Point p;
				p = getMousePosition();
				Polygon poly = getPolygon(c * r.width, (int) (l * cote), cote);
				if (p != null && poly.contains(p)) {
					hovered = new Point(c * r.width, (int) (l * cote));
					numero = l * this.taille + c;
					pol = poly;
				}
				g2d.draw(poly);
			}
		}
		if (hovered != null) {
			arg0.setColor(Color.red);
			g2d.setStroke(bs3);
			Polygon p = getPolygon(hovered.x, hovered.y, cote);
			g2d.draw(p);
		}
	}

	public Polygon getPolHover() {
		return pol;
	}

	public static Polygon getPolygon(int x, int y, int cote) {// Forme le
		// polygone
		Polygon p = new Polygon();
		p.addPoint(x, y);
		p.addPoint(x, y + cote);
		p.addPoint(x + cote, y + cote);
		p.addPoint(x + cote, y);
		return p;
	}
}

