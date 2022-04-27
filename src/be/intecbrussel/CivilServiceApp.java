package be.intecbrussel;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.*;
import java.nio.file.Path;

//deel 2 van Opdracht 6 pag 390

public class CivilServiceApp {
    public static void main(String[] args) throws FileNotFoundException {

        Path path = Path.of("C:\\Java\\Opdrachten");
        File opdrachtenDirectory = path.toFile();
        File[] files = opdrachtenDirectory.listFiles();
        for (File file : files) {
            if (file.isFile()) {

                try (ObjectInputStream objectInputStream = new ObjectInputStream(
                        new FileInputStream(file.getAbsoluteFile()))) {

                    Person person = (Person) objectInputStream.readObject();
                    System.out.println(person);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }   // RESULT: Person{firstName='Alex', lastName='Johnson', birthday=2000-04-12}
      //  Person{firstName='Oleg', lastName='Orlov', birthday=1978-02-11}
    }
}