import java.util.Observable;
/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.ArrayList;
import java.util.Date;

public class Prof extends Observable {
	private String name;
	private Date midtermDate;
	private ArrayList<Student> students;
	private TeachingAssistant ta;

	public Prof(String aName) {
		this.name = aName;
		this.students = new ArrayList<Student>();
	}

	public Date getMidterm() {
		return this.midtermDate;
	}

	public String getName() {
		return this.name;
	}

	public void setMidterm(Date date) {
		this.midtermDate = date;
		setChanged();
		notifyObservers("study");
	}
	
	public void postponeMidterm(Date date){
		this.midtermDate = date;
		setChanged();
		notifyObservers("postponed");
	}
	
	public void setTA(TeachingAssistant theTA){
		this.ta = theTA;
	}
	
	public void addStudent(Student s){
		this.students.add(s);
	}


	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		Student s = new Student("Homer");
		Student s2 = new Student("Bart");
		TeachingAssistant ta = new TeachingAssistant("Michael");
	
		p.addObserver(s);
		p.addObserver(s2);
		p.addObserver(ta);
	
//		p.addStudent(s);
//		p.addStudent(s2);
//		p.setTA(ta);
	
		Date midterm = new Date();
		p.setMidterm(midterm);
	
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}