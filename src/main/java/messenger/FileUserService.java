package messenger;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileUserService {
    IOUtils ioUtils;

    public FileUserService(IOUtils ioUtils) {
        this.ioUtils = ioUtils;
    }

    public void addUser() {

        try {
            ioUtils.writeMessage("Enter email: ");
            String email = ioUtils.readNextLine();
            if (Files.exists(Paths.get(email + ".txt"))) {
                ioUtils.writeMessage("User already exist");
                return;
            }

            ioUtils.writeMessage("Enter your password");
            String password = ioUtils.readNextLine();
            ioUtils.writeMessage("Enter your full name: ");
            String name = ioUtils.readNextLine();
            ioUtils.writeMessage("Enter your age: ");
            int age = ioUtils.readNextInt();
            PrintWriter writer = new PrintWriter(email + ".txt");
            writer.println(email);
            writer.println(password);
            writer.println(name);
            writer.println(age);
            writer.close();

        } catch (
                IOException e) {
            ioUtils.writeMessage("Password or email is incorrect");

        }
    }

    public void login() {
        ioUtils.writeMessage("Enter your email: ");
        String enteredEmail = ioUtils.readNextLine();
        ioUtils.writeMessage("Enter password: ");
        String enteredPassword = ioUtils.readNextLine();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        try {
            Path filePath = Paths.get(enteredEmail + ".txt");
            List<String> lines = Files.readAllLines(filePath);
            if (lines.get(0).equals(enteredEmail) && lines.get(1).equals(enteredPassword)) {

                ioUtils.writeMessage("Enter email of recipient");
                String emailOfRecipient = ioUtils.readNextLine();
                ioUtils.fileExist(enteredEmail + emailOfRecipient + ".txt");
                if (Files.exists(Paths.get(emailOfRecipient + ".txt"))) {
                    ioUtils.writeMessage("Enter your message");
                    String message = ioUtils.readNextLine();
                    PrintWriter pw = new PrintWriter(enteredEmail + "'s_message_to_" + emailOfRecipient + ".txt");
                    pw.println(timeStamp +" " + lines.get(2) + " says " + ": " + message);
                    pw.close();
                } else {
                    ioUtils.writeMessage("No addressee found");
                }

            } else {
                ioUtils.writeMessage("Entered Email or password is Incorrect");
                return;
            }
        } catch (IOException e) {
            ioUtils.writeMessage("Password or email is incorrect");
        }
    }

}