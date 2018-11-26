import java.io.*;

public class TestRun {

    public static void main(String[] args) {
        Pupil p = new Student("Ivanov", 3, 3);
        Pupils p2 = new Pupils();

        String fileDirection = "D://Irina//byteTest.txt";
        String fileDirection2 = "D://Irina//symbolTest.txt";
        String fileDirection3 = "D://Irina//serialTest.txt";


        p.setMark(0,5);
        p.setMark(1,4);
        p.setMark(2,3);

        p.setSubject(0, "Russian");
        p.setSubject(1, "Math");
        p.setSubject(2, "Physics");
/*
        System.out.println("1. Првоерка методов класса Pupils");
        p2.printSubjects(p);
        p2.printMarks(p);
        p2.printAverage(p);

        p.setMark(0,1);
        p.setMark(1,2);
        p.setMark(2,5);

        p.setSubject(0, "Geometry");
        p.setSubject(1, "Biology");
        p.setSubject(2, "History");

        System.out.println("2. Проверка байтовых потоков");

        try (FileOutputStream fos = new FileOutputStream(fileDirection))
        {
            p2.outputPupil(p, fos);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        try (FileInputStream fis = new FileInputStream(fileDirection))
        {
            p = p2.inputPupil(fis);
            p.printSubject();
            p.printMark();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        p.setMark(0,2);
        p.setMark(1,5);
        p.setMark(2,4);

        p.setSubject(0, "Math");
        p.setSubject(1, "Biology");
        p.setSubject(2, "History");

        System.out.println("3. Проверка символьных потоков");

        try(FileWriter fw = new FileWriter(fileDirection2))
        {
            p2.writePupil(p, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try(FileReader fr = new FileReader(fileDirection2))
        {
            p = p2.readPupil(fr);
            p.printSubject();
            p.printMark();
        } catch (IOException e) {
            e.printStackTrace();
        }

        p.setMark(0,4);
        p.setMark(1,2);
        p.setMark(2,5);

        p.setSubject(0, "Physics");
        p.setSubject(1, "History");
        p.setSubject(2, "Russian");
*/
        System.out.println("4. Проверка сериализация/десериализация");

        try {
            FileOutputStream fos = new FileOutputStream(fileDirection3);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream(fileDirection3);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student s = (Student)ois.readObject();
            System.out.println("Десериализуем");
            s.printMark();
            s.printSubject();
            System.out.println("Исходный объект");
            p.printMark();
            p.printSubject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
