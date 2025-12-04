package addressbook.tests;

import addressbook.model.ContactDate;
import addressbook.model.Contacts;
import addressbook.model.GroupDate;
import addressbook.model.Groups;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactCreationTests extends TestBase {

    public static Stream<Arguments> validContactsFromJson() throws IOException {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.json"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        }

        // ВАЖНО: Добавьте эту настройку!
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        List<ContactDate> contacts = gson.fromJson(json.toString(), new TypeToken<List<ContactDate>>(){}.getType());
        return contacts.stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("validContactsFromJson")
        public void testContactCreation() throws Exception {
            Contacts before = app.db().contacts();
            Groups groups = app.db().groups();
          if (groups.size() == 0) {
            app.goTo().GroupPage();
            // Создаем группу если нет групп
            GroupDate group = new GroupDate().withName("test_group");
            app.group().create(group);
            groups = app.db().groups();
        }
        File photo = new File("src/test/resources/stru.png");
        ContactDate newContact = new ContactDate().withFirstname("test_name")
                .withLastname("test_surname")
                .withPhoto(photo).withMobile("1234567890")
                .withEmail("@email.com");

            app.contact().create(newContact);

            Contacts after = app.db().contacts();
            assertThat(after.size(), equalTo(before.size() + 1));

            assertThat(after, equalTo(
                    before.withAdded(newContact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
        }

}

