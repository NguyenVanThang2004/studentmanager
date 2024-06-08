package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DatabaseAcessObject.DAOStudent;
import Model.Student;
import View.StudentView;

public class StudentListenner implements ActionListener{
    
	private StudentView student_view ;
	
	public StudentListenner(StudentView student_view) {
		this.student_view = student_view ;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String src = e.getActionCommand();
		
		if(src.equals("INSERT")) {
			 Student student = new Student() ;
			 student.setId(student_view.textField_id.getText());
			 student.setName(student_view.textField_name.getText());
			 
			 if(student_view.comboBox.getSelectedIndex()==0) {
				 student.setGender(0);
			 } else {
				 student.setGender(1);
			 }
			 student.setScore(Float.valueOf(student_view.textField_score.getText()));
			 DAOStudent.getInstance().insert(student);
			 student_view.ShowData(DAOStudent.getInstance().selectAll());
			 
		} else if ( src.equals("UPDATE")){
			
		
		} else if ( src.equals("DELETE")) {
			 Student student = new Student() ;
			 student.setId(student_view.textField_id.getText());
			 student.setName(student_view.textField_name.getText());
			 if(student_view.comboBox.getSelectedIndex()==0) {
				 student.setGender(0);
			 } else {
				 student.setGender(1);
			 }
			 student.setScore(Float.valueOf(student_view.textField_score.getText()));
			 DAOStudent.getInstance().delete(student);
			 student_view.ShowData(DAOStudent.getInstance().selectAll());
		} else if ( src.equals("SELECT")) {
			
		}
		
	}
  
}
