package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.StudentListenner;
import DatabaseAcessObject.DAOStudent;
import Model.Student;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentView extends JFrame {
    
	
	private Student student  ;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JComboBox comboBox;
	public static JTextField textField_name;
	public static JTextField textField_id;
	public static JTextField textField_score;
	private static JTable table;

	
	public StudentView() {
		this.student = new Student() ;
		this.Init();
		this.setVisible(true);
	}
	
	public void Init() {
		
		ActionListener ac = new StudentListenner(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(30, 92, 30, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Arial", Font.BOLD, 25));
		lblName.setBounds(30, 142, 70, 30);
		contentPane.add(lblName);
		
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setFont(new Font("Arial", Font.BOLD, 25));
		lblScore.setBounds(29, 282, 100, 30);
		contentPane.add(lblScore);
		
		JLabel lblGender = new JLabel("gender");
		lblGender.setFont(new Font("Arial", Font.BOLD, 25));
		lblGender.setBounds(30, 194, 85, 30);
		contentPane.add(lblGender);
		
		textField_name = new JTextField();
		textField_name.setBounds(110, 142, 145, 30);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(90, 92, 145, 30);
		contentPane.add(textField_id);
		
		textField_score = new JTextField();
		textField_score.setColumns(10);
		textField_score.setBounds(140, 282, 75, 30);
		contentPane.add(textField_score);
		
	    comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 10));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(129, 192, 40, 40);
		contentPane.add(comboBox);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("Arial", Font.BOLD, 10));
		btnInsert.setBounds(30, 368, 100, 50);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(ac);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 10));
		btnDelete.setBounds(320, 368, 100, 50);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(ac);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 10));
		btnUpdate.setBounds(168, 368, 100, 50);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(ac);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.setFont(new Font("Arial", Font.BOLD, 10));
		btnSelect.setBounds(449, 368, 100, 50);
		contentPane.add(btnSelect);
		btnSelect.addActionListener(ac);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 58, 500, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "GENDER", "SCORE"
			}
		));
		scrollPane.setViewportView(table);
		ShowData(DAOStudent.getInstance().selectAll());
		
	}
	
	public void ShowData(ArrayList<Student> list_student) {
		ArrayList<Student> ls = new ArrayList<Student>() ;
		 ls = list_student ;
		 DefaultTableModel table_model ; 
		 table.getModel() ;
		 table_model=(DefaultTableModel)table.getModel();
		 table_model.setRowCount(0);
		 
		 list_student.forEach((student)->{
			  
			 String gender ;
			 if(student.getGender() == 0) {
				 gender = "Male";
			 } else {
				 gender = "FeMale";
			 }
			 
			table_model.addRow( new Object [] {
					
					student.getId() ,student.getName() ,gender , student.getScore() 
			});
			 
			
		 });
		 
	}
}
