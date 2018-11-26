public interface Pupil {
    String getSurname();

    void setSurname(String surname);

    int getMark(int z);

    void setMark(int marks, int e);

    void printMark();

    String getSubject(int s);

    void setSubject(int subject, String q);

    void printSubject();

    int getMarksSize ();

    int getSubjectSize ();

    void addMark(int k);

    void addSubject (String u);

    /*Клонирование */
    Object clone();
}
