package display;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

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

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenêtreSave window = new FenêtreSave();
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
	public FenêtreSave() {
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
		
		JComboBox comboBox = new JComboBox();
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
				System.out.println("Importer");
			}
		});
		
		
		btnSauvegarder.addMouseListener(new MouseAbstractListener(){
			@Override
			public void mouseClicked(MouseEvent e)
			{//TODO
				System.out.println("Sauvegarder");
			}
		});
		
		btnParcourir.addMouseListener(new MouseAbstractListener(){
			@Override
			public void mouseClicked(MouseEvent e)
			{//TODO
				System.out.println("Parcourir");
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
				System.out.println("Merde");
			}
		});
		
		
	}

}
