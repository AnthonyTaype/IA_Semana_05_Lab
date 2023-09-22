package semana05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Yogurt extends JFrame implements ActionListener {

	// Declaraci�n de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox<String> cboMarca;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Yogurt frame = new Yogurt();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Yogurt() {
		setTitle("Yogurt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 87, 14);
		contentPane.add(lblMarca);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 80, 14);
		contentPane.add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Laive", "Gloria", "Pura Vida", "Milkito" }));
		cboMarca.setBounds(107, 8, 100, 20);
		contentPane.add(cboMarca);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(107, 33, 100, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsaci�n del bot�n Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		cboMarca.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int cant, cara;
		double pre, impC, impD, impP;
		String marc;
		
		cant = Integer.parseInt(txtCantidad.getText());
		marc = cboMarca.getSelectedItem().toString();
		
		//precio
		if(marc == "Laive"){pre=5.4;}
		else if(marc =="Gloria"){pre=5.7;}
		else if(marc =="Pura Vida"){pre=4.8;}
		else{pre=5.3;}
		
		impC = pre*cant;
		
		//descuento
		if(cant<3){impD=impC*0.0;}
		else if(cant>=3 && cant<6){impD=impC*0.25;}
		else if (cant>=6 && cant<12){impD=impC*0.05;}
		else{impD=impC*0.75;}
		
		impP = impC-impD;
		
		//caramelos
		if(marc == "Laive"){cara=2*cant;}
		else if(marc == "Gloria"){cara=3*cant;}
		else if(marc == "Pura vida"){cara=4*cant;}
		else{cara=2*cant;}
		
		txtS.setText("Yogurt \n\n");
		imprimir("Importe compra     : " + decimalFormat(impC));
		imprimir("Importe descuento  : " + decimalFormat(impD));
		imprimir("Importe pagar      : " + decimalFormat(impP));
		imprimir("Caramelos         : " + cara);
}
	
	String decimalFormat(double p){
		return String.format("%.2f",p).replace(",", ".");
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	



