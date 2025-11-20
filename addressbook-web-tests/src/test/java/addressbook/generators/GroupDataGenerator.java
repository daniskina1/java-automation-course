package addressbook.generators;

import addressbook.model.GroupDate;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main (String [] args) throws IOException {
        GroupDataGenerator generatior = new GroupDataGenerator();
        JCommander JCommander = new JCommander(generatior);
        try {
            JCommander.parse(args);
        } catch (ParameterException ex) {
            JCommander.usage();
            return;
        }
        generatior.run();
    }

    private void run() throws IOException {
        List<GroupDate> groups = generateGroups(count);
        save (groups, new File(file));

    }

    private void save(List<GroupDate> groups, File file) throws IOException {

        Writer writer = new FileWriter(file);
        for (GroupDate group : groups) {
            writer.write(String.format("%s, %s, %s\n",group.getName(),group.getHeader(), group.getFooter()));
        }
        writer.close();
    }

    private List<GroupDate> generateGroups(int count) {
        List<GroupDate> groups = new ArrayList<GroupDate>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupDate().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i))
                    .withFooter(String.format("footer %s", i)));
        }
        return groups;
    }
}
