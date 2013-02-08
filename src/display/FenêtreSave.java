package display;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import DataAccess.DataBaseAccess;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import display.Fenêtre.MouseAbstractListener;

public class FenêtreSave {
	
	
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

	private JFrame frame;
	private DataBaseAccess BDD;
	private Fenêtre frmJsimForest;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FenêtreSave window = new FenêtreSave(frmJsimForest);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public FenêtreSave(Fenêtre frmJsimForest) {
		super();
		this.frmJsimForest = frmJsimForest;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		frame = new JFrame();
		frame.setBounds(100, 100, 354, 214);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		frame.getContentPane().add(comboBox, "2, 2, fill, center");
		
		JButton btnParcourir = new JButton("Parcourir");
		frame.getContentPane().add(btnParcourir, "4, 2, fill, center");
		
		JButton btnSauvegarder = new JButton("Sauvegarder");
		frame.getContentPane().add(btnSauvegarder, "2, 4, left, center");
		
		JButton btnImporter = new JButton("Importer");
		frame.getContentPane().add(btnImporter, "4, 4, fill, center");
		
		JButton btnQuitter = new JButton("Quitter");
		frame.getContentPane().add(btnQuitter, "4, 6, fill, default");
		
		btnImporter.addMouseListener(new MouseAbstractListener(){
			@Override
			public void mouseClicked(MouseEvent e)
			{//TODO
				try{
					
				if(comboBox.getItemCount() <= 0)
				{
					System.out.println("Choississez un fichier");
				}
				else
				{
					BDD = new DataBaseAccess("C:\\Users\\arnaud\\git\\j-sim-forest\\JSimBDD.sqlite");
					BDD.connect();

					ResultSet rs = BDD.GetParametre(comboBox.getSelectedItem().toString());
					ArrayList<String> nb_pas = new ArrayList();
					ArrayList<String> vitesse = new ArrayList();
					ArrayList<String> taille_grille = new ArrayList();
					if (rs != null) {
						int j = 0;
					    do {
					    	nb_pas.add(rs.getString("nb_pas"));
					    	vitesse.add(rs.getString("vitesse"));
					    	taille_grille.add(rs.getString("taille_grille_x"));
					        
					    } while (rs.next());

						
						for (String nb : nb_pas)
						{
							frmJsimForest.getTxtChoixPas().setText(nb);
						}
						for (String vit : vitesse)
						{
							frmJsimForest.getTxtDlai().setText(vit);
						}
						for (String taille : taille_grille)
						{
							frmJsimForest.getComboBox_1().setSelectedItem(taille);
						}
						
					}

					System.out.println("Importation effectuée");

					BDD.disconnect();
				}
				}
							catch(SQLException e1)
							{
								do {
							         System.out.println("SQL STATE: " + e1.getSQLState());
							         System.out.println("ERROR CODE: " + e1.getErrorCode());
							         System.out.println("MESSAGE: " + e1.getMessage());
							         System.out.println();
							         e1 = e1.getNextException();
							      } while (e1 != null);
							}

				
			}
		});
		
		// sauvegarde des données
		btnSauvegarder.addMouseListener(new MouseAbstractListener(){
			@Override
			public void mouseClicked(MouseEvent e)
			{//TODO
				try{
					BDD = new DataBaseAccess("C:\\Users\\arnaud\\git\\j-sim-forest\\JSimBDD.sqlite");
					BDD.connect();
					ResultSet rs = BDD.getID();
                    int i=0;
                    ArrayList<String> temporaire = new ArrayList();
                    if (rs != null) {
    					int j = 0;
    				    do {
    				    	temporaire.add(rs.getString("id_configuration"));
    				        
    				    } while (rs.next());
                    }
                    String index =temporaire.get(temporaire.size()-1)+1;
					String retour = BDD.Sauvegarde(index,frmJsimForest.getTxtChoixPas().getText(), frmJsimForest.getTxtDlai().getText(), frmJsimForest.getComboBox_1().getSelectedItem().toString(),comboBox.getSelectedItem().toString());
					System.out.println(retour);
					BDD.disconnect();
					}
							catch(Exception e1)
							{

							}
				
			}
		});
		
		btnParcourir.addMouseListener(new MouseAbstractListener(){
			@Override
			public void mouseClicked(MouseEvent e)
			{//TODO
				try{
				BDD = new DataBaseAccess("C:\\Users\\arnaud\\git\\j-sim-forest\\JSimBDD.sqlite");
				BDD.connect();
				ResultSet rs = BDD.getName();
				ArrayList<String> temporaire = new ArrayList();
				if (rs != null) {
					int j = 0;
				    do {
				    	temporaire.add(rs.getString("name"));
				        
				    } while (rs.next());

					int i=0;
					
					for (String item : temporaire)
					{
						
						comboBox.addItem(item);
						i++;
					}
					
				}
				if (rs == null) {
					System.out.println("Pas de sauvegarde");
				}

				BDD.disconnect();
				}
						catch(SQLException e1)
						{
							do {
						         System.out.println("SQL STATE: " + e1.getSQLState());
						         System.out.println("ERROR CODE: " + e1.getErrorCode());
						         System.out.println("MESSAGE: " + e1.getMessage());
						         System.out.println();
						         e1 = e1.getNextException();
						      } while (e1 != null);
						}

				
			}
		});
		
		btnQuitter.addMouseListener(new MouseAbstractListener(){
			@Override
			public void mouseClicked(MouseEvent e)
			{//TODO
				frame.dispose();
			}
		});
		
		comboBox.addMouseListener(new MouseAbstractListener(){
			@Override
			public void mouseClicked(MouseEvent e)
			{//TODO
				System.out.println("paramètres chargés");
			}
		});
		
		
	}

}
