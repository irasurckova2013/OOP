import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Pupils {

    public static void printSubjects(Pupil p) {
        p.printSubject();
    }

    public static void printMarks(Pupil p) {
        p.printMark();
    }

    public static void printAverage(Pupil p) {
       double count = 0;
       double sum = 0;

       for (int i = 0; i < p.getMarksSize(); i++) {
           sum += p.getMark(i);
           count++;
       }

       System.out.println(sum/count);
    }

    public static void outputPupil(Pupil p, OutputStream out) {
        int countString;
        StringBuilder sb = new StringBuilder();

        sb.append(p.getSurname());
        sb.append(p.getSubjectSize());
        sb.append(p.getMarksSize());
        for (int i = 0; i < p.getSubjectSize(); i++){
            sb.append(p.getSubject(i));
        }
        for (int i = 0; i < p.getMarksSize(); i++){
            sb.append(p.getMark(i));
        }
        countString = sb.toString().length();
        String finalString = countString + sb.toString();
        try (DataOutputStream dos = new DataOutputStream(out)){
            dos.write(finalString.getBytes());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Pupil inputPupil(InputStream in){
        Pupil p = new Student("", 0, 0);
        StringBuilder sb = new StringBuilder();
        String surname, subject;
        Pattern regexp;
        Matcher m;
        int count = 0;
        int next, markSize;

        try(DataInputStream dis = new DataInputStream(in))
        {
            while ((next = dis.read()) != -1){
                sb.append((char)next);
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /*Запись оценок по предметам*/
        regexp = Pattern.compile("\\d{1,10}");
        m = regexp.matcher(sb);
        while (m.find()){
            count++;
            if (count == 3) {
                markSize = m.end() - m.start();
                int start = m.start();
                for(int j = 1; j <= markSize; j ++){
                    p.addMark(parseInt(sb.substring(start, start + 1)));
                    start += 1;
                }
            }
        }

        /*Запись фамилии и предметов*/
        regexp = Pattern.compile("[A-Z,a-z]{1,20}");
        m = regexp.matcher(sb);
        count = 0;
        while(m.find()){
            count++;
            if (count == 1) {
                surname = sb.substring(m.start(), m.end());
                p.setSurname(surname);
            } else {
                subject = sb.substring(m.start(), m.end());
                regexp = Pattern.compile("[A-Z]{1}[a-z]{1,20}");
                m = regexp.matcher(subject);
                while (m.find()) {
                    p.addSubject(subject.substring(m.start(), m.end()));
                }

            }
        }
        return p;
    }

    public static void writePupil(Pupil p, Writer out){
        int countString;
        StringBuilder sb = new StringBuilder();

        sb.append(p.getSurname());
        sb.append(p.getSubjectSize());
        sb.append(p.getMarksSize());
        for (int i = 0; i < p.getSubjectSize(); i++){
            sb.append(p.getSubject(i));
        }
        for (int i = 0; i < p.getMarksSize(); i++){
            sb.append(p.getMark(i));
        }
        countString = sb.toString().length();
        String finalString = countString + sb.toString();

        PrintWriter pw = new PrintWriter(out);
        pw.write(finalString);

    }

    public static Pupil readPupil(Reader in) throws IOException {
        BufferedReader br = new BufferedReader(in);
        String st = br.readLine();
        Pupil p = new Student("", 0, 0);
        String surname, subject;
        Pattern regexp;
        Matcher m;
        int count = 0;
        int next, markSize;

        /*Запись оценок по предметам*/
        regexp = Pattern.compile("\\d{1,10}");
        m = regexp.matcher(st);
        while (m.find()){
            count++;
            if (count == 3) {
                markSize = m.end() - m.start();
                int start = m.start();
                for(int j = 1; j <= markSize; j ++){
                    p.addMark(parseInt(st.substring(start, start + 1)));
                    start += 1;
                }
            }
        }

        /*Запись фамилии и предметов*/
        regexp = Pattern.compile("[A-Z,a-z]{1,20}");
        m = regexp.matcher(st);
        count = 0;
        while(m.find()){
            count++;
            if (count == 1) {
                surname = st.substring(m.start(), m.end());
                p.setSurname(surname);
            } else {
                subject = st.substring(m.start(), m.end());
                regexp = Pattern.compile("[A-Z]{1}[a-z]{1,20}");
                m = regexp.matcher(subject);
                while (m.find()) {
                    p.addSubject(subject.substring(m.start(), m.end()));
                }

            }
        }
        return p;
    }
}
