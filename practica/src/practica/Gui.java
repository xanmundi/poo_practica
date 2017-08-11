package practica;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTree;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import net.miginfocom.swing.MigLayout;

import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;


public class Gui {

	private JFrame frame;
	private JTextField textField_Add_DNI;
	private JTextField textField_Add_Nombre;
	private JTextField textField_Add_Email;
	private JTextField textField_Add_FormaP;
    private DefaultListModel modelo;
	private DefaultListModel modeloCliVehiculo;
    private JLabel lblClientes_2;
    private JTextField textField_DNI;
    private JTextField textField_Nombre;
    private JTextField textField_Email;
    private JTextField textField_FormaP;/*declaramos el Modelo*/
    private GestionFicheros gf;

	/**
	 * Launch the application. test
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui()
	
	{
		initialize();
	}
	
	private void cambiaVisible(){
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final DefaultListModel modelo = new DefaultListModel();
		final ListadoPersonas lp= new ListadoPersonas();
		final JList listaClientes = new JList();
		
		listaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Persona pers=lp.getCliente(listaClientes.getSelectedIndex());
				textField_DNI.setText(pers.getNIF());
				textField_Nombre.setText(pers.getNombre());
				textField_Email.setText(pers.getEmail());
			}
		});

		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane);
		
		JPanel Clientes = new JPanel();
		tabbedPane.addTab("Clientes", null, Clientes, "");
		
		JLabel lblClientes = new JLabel("Gesti\u00F3n de Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Linux Biolinum G", Font.BOLD, 24));
		
		JLabel lblVehculos = new JLabel("Veh\u00EDculos del Usuario");
		
		JPanel panel_CliListado = new JPanel();
		panel_CliListado.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		
		JPanel panel_CliAdd = new JPanel();
		panel_CliAdd.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		
		JPanel panel_CliVehCli = new JPanel();
		panel_CliVehCli.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		GroupLayout gl_Clientes = new GroupLayout(Clientes);
		gl_Clientes.setHorizontalGroup(
			gl_Clientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Clientes.createSequentialGroup()
					.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Clientes.createSequentialGroup()
							.addGap(345)
							.addComponent(lblClientes))
						.addGroup(gl_Clientes.createSequentialGroup()
							.addContainerGap(20, Short.MAX_VALUE)
							.addComponent(panel_CliListado, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_CliAdd, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Clientes.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_CliVehCli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(339)
							.addComponent(lblVehculos)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_Clientes.setVerticalGroup(
			gl_Clientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Clientes.createSequentialGroup()
					.addComponent(lblClientes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Clientes.createSequentialGroup()
							.addGap(327)
							.addComponent(lblVehculos))
						.addGroup(gl_Clientes.createSequentialGroup()
							.addGap(69)
							.addGroup(gl_Clientes.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_CliAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_CliListado, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_CliVehCli, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_CliVehCli.setLayout(null);
		
		JLabel label_CliVehSelecc = new JLabel("Veh\u00EDculos del Cliente");
		label_CliVehSelecc.setHorizontalAlignment(SwingConstants.CENTER);
		label_CliVehSelecc.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		label_CliVehSelecc.setBounds(30, 11, 318, 14);
		panel_CliVehCli.add(label_CliVehSelecc);
		
		JList<String> list_CliVehSelecc = new JList<String>();
		list_CliVehSelecc.setBounds(10, 36, 581, 106);
		panel_CliVehCli.add(list_CliVehSelecc);

		JButton btnCliVehAddRep = new JButton("Crear Reparaci\u00F3n");
		btnCliVehAddRep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCliVehAddRep.setBounds(616, 36, 205, 23);
		panel_CliVehCli.add(btnCliVehAddRep);
		panel_CliAdd.setLayout(null);
		
		JLabel lbl_Add_DNI = new JLabel("DNI / NIF");
		lbl_Add_DNI.setBounds(10, 45, 99, 14);
		panel_CliAdd.add(lbl_Add_DNI);
		
	
		textField_Add_DNI = new JTextField();
		textField_Add_DNI.setBounds(119, 42, 205, 20);
		panel_CliAdd.add(textField_Add_DNI);
		textField_Add_DNI.setColumns(10);
		
		JLabel lbl_Add_Nombre = new JLabel("Nombre:");
		lbl_Add_Nombre.setBounds(10, 71, 99, 14);
		panel_CliAdd.add(lbl_Add_Nombre);
		
		textField_Add_Nombre = new JTextField();
		textField_Add_Nombre.setBounds(119, 68, 205, 20);
		panel_CliAdd.add(textField_Add_Nombre);
		textField_Add_Nombre.setColumns(10);
		
		JLabel lbl_Add_Email = new JLabel("Email:");
		lbl_Add_Email.setBounds(10, 95, 99, 14);
		panel_CliAdd.add(lbl_Add_Email);
		
		textField_Add_Email = new JTextField();
		textField_Add_Email.setBounds(119, 92, 205, 20);
		panel_CliAdd.add(textField_Add_Email);
		textField_Add_Email.setColumns(10);
		
		JLabel lbl_Add_FormaP = new JLabel("F. Pago:");
		lbl_Add_FormaP.setBounds(10, 123, 99, 14);
		panel_CliAdd.add(lbl_Add_FormaP);
		
		textField_Add_FormaP = new JTextField();
		textField_Add_FormaP.setBounds(119, 120, 205, 20);
		panel_CliAdd.add(textField_Add_FormaP);
		textField_Add_FormaP.setColumns(10);
		
		JButton btnNewButton = new JButton("A\u00F1adir Cliente");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ListadoPersonas lp = new ListadoPersonas(); 
				lp.nuevoCliente(textField_Add_DNI.getText(),textField_Add_Nombre.getText(),textField_Add_Email.getText());
				//System.out.println(textField_Add_DNI.toString());				//mo();
				listaClientes.setModel(lp.getModelo());
			}
		});

		btnNewButton.setBounds(94, 167, 155, 23);
		panel_CliAdd.add(btnNewButton);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JLabel lblNuevoCliente = new JLabel("Nuevo Cliente");
		lblNuevoCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lblNuevoCliente.setBounds(94, 11, 171, 18);
		panel_CliAdd.add(lblNuevoCliente);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_CliListado.setLayout(null);
		
		DefaultListModel<String> modeloCliVehiculo = new DefaultListModel<String>();
		modeloCliVehiculo.addElement("Peugeot");
		modeloCliVehiculo.addElement("Renault");
		list_CliVehSelecc.setModel(modeloCliVehiculo);

		listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listaClientes.setModel(lp.getModelo());
		listaClientes.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, Color.LIGHT_GRAY, null));
		listaClientes.setBounds(10, 32, 145, 193);
		panel_CliListado.add(listaClientes);
		
		textField_DNI = new JTextField();
		textField_DNI.setBounds(194, 49, 271, 20);
		panel_CliListado.add(textField_DNI);
		textField_DNI.setColumns(10);
		textField_DNI.setEditable(false);

		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(194, 77, 113, 14);
		panel_CliListado.add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(195, 124, 112, 14);
		panel_CliListado.add(lblEmail);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(194, 142, 271, 20);
		panel_CliListado.add(textField_Email);
		textField_Email.setColumns(10);
		textField_Email.setEditable(false);
		
		JLabel lblFormaDePago = new JLabel("Forma de Pago:");
		lblFormaDePago.setBounds(194, 172, 157, 14);
		panel_CliListado.add(lblFormaDePago);
		
		textField_FormaP = new JTextField();
		textField_FormaP.setBounds(194, 188, 271, 20);
		panel_CliListado.add(textField_FormaP);
		textField_FormaP.setColumns(10);
		textField_FormaP.setEditable(false);
		final JButton btnEditar = new JButton("Editar");
		final JButton btnGrabaModCliente = new JButton("Guardar");
		final JButton btnCancelaModifCliente = new JButton("Cancelar");
		btnGrabaModCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lp.modifCliente(listaClientes.getSelectedIndex(),textField_DNI.getText(),textField_Nombre.getText(),textField_Email.getText());
				listaClientes.setModel(lp.getModelo());
				textField_DNI.setEditable(false);
				textField_Nombre.setEditable(false);
				textField_Email.setEditable(false);
				textField_FormaP.setEditable(false);
				btnCancelaModifCliente.setVisible(false);
				btnGrabaModCliente.setVisible(false);
				btnEditar.setVisible(true);
				}
		});
		btnGrabaModCliente.setVisible(false);
		btnGrabaModCliente.setBounds(195, 235, 117, 25);
		panel_CliListado.add(btnGrabaModCliente);
		

		btnCancelaModifCliente.setVisible(false);
		btnCancelaModifCliente.setBounds(346, 235, 96, 25);
		panel_CliListado.add(btnCancelaModifCliente);
		btnCancelaModifCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_DNI.setEditable(false);
				textField_Nombre.setEditable(false);
				textField_Email.setEditable(false);
				textField_FormaP.setEditable(false);
				btnCancelaModifCliente.setVisible(false);
				btnGrabaModCliente.setVisible(false);
				btnEditar.setVisible(true);
				
			}
		});
		
		
		btnEditar.setVisible(true);
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (listaClientes.getSelectedIndex()>=0)
				{				
				textField_DNI.setEditable(true);
				textField_Nombre.setEditable(true);
				textField_Email.setEditable(true);
				textField_FormaP.setEditable(true);
				btnEditar.setVisible(false);
				btnGrabaModCliente.setVisible(true);
				btnCancelaModifCliente.setVisible(true);
				
				}
			}
				
		});
		btnEditar.setBounds(195, 235, 117, 25);
		panel_CliListado.add(btnEditar);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(194, 96, 271, 20);
		textField_Nombre.setEditable(false);
		panel_CliListado.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		lblClientes_2 = new JLabel("Clientes");
		lblClientes_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblClientes_2.setBounds(10, 11, 145, 14);
		panel_CliListado.add(lblClientes_2);
		
		JButton btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
		btnEliminarSeleccionado.setBounds(20, 235, 133, 23);
		panel_CliListado.add(btnEliminarSeleccionado);
		
		JLabel lblDniNif = new JLabel("DNI / NIF");
		lblDniNif.setBounds(194, 35, 46, 14);
		panel_CliListado.add(lblDniNif);
		
		btnEliminarSeleccionado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = listaClientes.getSelectedIndex();
				System.out.println("i = "+i);
				//modelo.remove(listaClientes.getSelectedIndex());
				lp.borraRegistro(i);//System.out.println(listaClientes.getSelectedIndex());
				//listaClientes.setModel(modelo);
				//textField.setEditable(false);
				listaClientes.setModel(lp.getModelo());
				
			}
		});
		Clientes.setLayout(gl_Clientes);
		
		JPanel Reparaciones = new JPanel();
		tabbedPane.addTab("Reparaciones", null, Reparaciones, null);
		
		JLabel lblReparaciones = new JLabel("Gesti\u00F3n de Reparaciones");
		lblReparaciones.setFont(new Font("Linux Biolinum G", Font.BOLD, 24));
		Reparaciones.add(lblReparaciones);
		
		JPanel Vehiculos = new JPanel();
		tabbedPane.addTab("Vehiculos", null, Vehiculos, null);
	
		JLabel lblVehiculos = new JLabel("Gesti\u00F3n de Veh\u00EDculos");
		lblVehiculos.setFont(new Font("Linux Biolinum G", Font.BOLD, 24));
		Vehiculos.add(lblVehiculos);
		
		JPanel Mecanicos = new JPanel();
		tabbedPane.addTab("Mec\u00E1nicos", null, Mecanicos, null);
		
		JLabel label_1 = new JLabel("Gesti\u00F3n de Mec\u00E1nicos");
		label_1.setFont(new Font("Linux Biolinum G", Font.BOLD, 24));
		Mecanicos.add(label_1);
        
        //ListadoPersonas lp= new ListadoPersonas();
        //lp.llenaArray();
       	
		//instanciamos el modelo
        //DefaultListModel modelo = new DefaultListModel();
        //ListadoPersonas lp= new ListadoPersonas();
        //modelo = lp.getModelo();
        
        JLabel lblClientes_1 = new JLabel("Clientes");
		//DefaultListModel modeloCliVehiculo = new DefaultListModel();
		//modeloCliVehiculo.addElement("Peugeot");
		//modeloCliVehiculo.addElement("Renault");
        
        

	}

}