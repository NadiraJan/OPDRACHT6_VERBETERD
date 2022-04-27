package be.intecbrussel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

//DEEL 1 VAN DE OPDRACHT 6 PAG.390


public class MaternityApp {
    public static void main(String[] args) throws IOException {

        Person johnson = new Person("Oleg", "Orlov", LocalDate.of(1978, 02, 11));
        Path path = Path.of("C:\\Java\\Opdrachten");
        Path johnsonPath = Path.of(path.toString() + "\\" + johnson.getFirstName() + johnson.getLastName());

        try{
        if (Files.notExists(johnsonPath)) {
            Files.createFile(johnsonPath);
        }
    }catch (IOException e){
        e.printStackTrace();
    }
    try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream(johnsonPath.toString()))) {
        objectOutputStream.writeObject(johnson);
    }

}}
//RESULT: IN DE FOLDER C:\Java\Opdrachten ZIE JE TWEE BESTANDEN VAN: ALEX JOHNSON EN OLEG ORLOV