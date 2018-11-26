import java.io.Serializable;
import java.util.Arrays;

public class Student extends Pupil_abstr implements Serializable {
    private String surname;
    private int[] marks;
    private String[] subjects;

    public Student(String fam, int a, int b) {
        this.surname = fam;
        marks = new int[a];
        subjects = new String[b];
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMark(int z) {
        return this.marks[z];
    }

    public void setMark(int marks, int e) {
        this.marks[marks] = e;
    }

    public void printMark() {
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
        }
    }

    public String getSubject(int s){
        return this.subjects[s];
    }

    public void setSubject(int subject, String q){
        this.subjects[subject]=q;
    }

    public void printSubject(){
        for (int i = 0; i < subjects.length; i++){
            System.out.println(subjects[i]);
        }
    }

    public int getMarksSize (){
       return this.marks.length;
    }

    public int getSubjectSize (){
        return this.subjects.length;
    }

    public void addMark(int k){
        int [] marksNew = Arrays.copyOf(marks, marks.length +1);
        marksNew [marks.length] = k;
        marks = marksNew;
    }

    public void addSubject (String u){
        String [] subjectNew = Arrays.copyOf(subjects, subjects.length +1);
        subjectNew [subjects.length] = u;
        subjects = subjectNew;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", marks=" + marks +
                ", subjects=" + (subjects == null ? null : Arrays.asList(subjects)) +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student other = (Student) o;
        if (surname != other.surname && marks != other.marks && subjects !=other.subjects) {
            return false;
        }
        return true;
    }

    @Override
    public Object clone() {
        Pupil pupil = null;
        pupil = (Student)super.clone();

        return pupil;
    }

    @Override
    public int hashCode() {

        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(marks);
        result = 31 * result + Arrays.hashCode(subjects);
        return result;
    }
}
