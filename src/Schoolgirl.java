import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Schoolgirl extends Pupil_abstr implements Pupil, Serializable {
    private String surname;
    private Register[] registers;

     public Schoolgirl(String fam, Register[] registers) {
        this.surname = fam;
        this.registers = registers;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int getMark(int z) {
        return 0;
    }

    @Override
    public void setMark(int marks, int e) {

    }

    public void printSubject(){
        for (int i = 0; i < registers.length; i++){
            System.out.println(registers[i].getSubject());
        }
    }

    @Override
    public int getMarksSize() {
        return 0;
    }

    @Override
    public int getSubjectSize() {
        return 0;
    }

    @Override
    public void addMark(int k) {

    }

    public void printMark() {
        for (int i = 0; i < registers.length; i++) {
            System.out.println(registers[i].getMark());
        }
    }

    @Override
    public String getSubject(int s) {
        return null;
    }

    @Override
    public void setSubject(int subject, String q) {

    }

    public void addSubject (String u) throws DuplicateSubjectException {
        for (int i = 0; i < registers.length; i++) {
           if(registers[i].getSubject().equals(u)){
               throw new DuplicateSubjectException("You can not add an existing item");
           }
        }
         Register[] registersNew = Arrays.copyOf(registers, registers.length + 1);
        registersNew[registers.length - 1].setSubject(u);
        registers = registersNew;
    }

    public void addMark(int k, String g){
         try {
             addSubject(g);
         } catch (DuplicateSubjectException ex){
             ex.printStackTrace();
         }
         registers [registers.length -1].setMark(k);
    }

    public void addMark(int k, int g) throws MarkOutOfBoundsException{
        registers[g].setMark(k);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Schoolgirl)) {
            return false;
        }
        Schoolgirl other = (Schoolgirl) o;
        if (surname != other.surname) {
            return false;
        }
        return true;
    }

    @Override
    public Object clone() {
        Pupil result = (Schoolgirl)super.clone();
        return result;
    }

    @Override
    public int hashCode() {

        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(registers);
        return result;
    }

    @Override
    public String toString() {
        return "Schoolgirl{" +
                "surname='" + surname + '\'' +
                ", registers=" + (registers == null ? null : Arrays.asList(registers)) +
                '}';
    }

    private class Register {
        private int marks;
        private String subjects;

        public int getMark() {
            return this.marks;
        }

        public String getSubject(){
            return this.subjects;
        }

        public void setSubject(String subject){
            this.subjects=subject;
        }

        public void setMark(int mark) {
            this.marks=mark;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Register register = (Register) o;
            return marks == register.marks &&
                    Objects.equals(subjects, register.subjects);
        }

        @Override
        public int hashCode() {
            int result = marks;
            result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
            return result;

        }
    }
}
