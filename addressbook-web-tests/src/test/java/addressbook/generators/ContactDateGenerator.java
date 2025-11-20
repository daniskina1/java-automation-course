package addressbook.generators;

import addressbook.model.ContactDate;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDateGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDateGenerator generator = new ContactDateGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactDate> contacts = generateContacts(count);
        if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format: " + format);
        }
    }

    private void saveAsJson(List<ContactDate> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private List<ContactDate> generateContacts(int count) {
        List<ContactDate> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactDate()
                    .withFirstname(String.format("Firstname %s", i))
                    .withLastname(String.format("Lastname %s", i))
                    .withMobilePhone(String.format("8-9%s-456-78-90", i))
                    .withEmail(String.format("email%s@test.com", i))
            );
        }
        return contacts;
    }



}
