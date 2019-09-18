//import ru.qa.pft.addressbook.model.GroupData;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GroupDataGenerator {
//  public static void main(String[] args) throws IOException {
//    int count = Integer.parseInt(args[0]);
//    File file = new File(args[1]);
//    List<GroupData> groups = generateGroups(count);
//    save(groups, file);
//  }
//
//  private static void save(List<GroupData> groups, File file) throws IOException {
//    System.out.println(new File(".").getAbsolutePath());
//    Writer writer = new FileWriter(file);
//    for (GroupData group : groups)
//    {
//      Writer.write (String.format("%s%s%s\n", group.getName(), group.getHeader(), group.getFooter()));
//    }
//    writer.close();
//
//  }
//
//  private static List<GroupData> generateGroups(int count) {
//    List<GroupData> group = new ArrayList<GroupData>();
//    for (int i = 0; i < count; i++) {
//      group.add(new GroupData().withName(String.format("test %s", i)).withHeader(String.format("test %s", i))
//              .withFooter(String.format("test %s", i)));
//    }
////    return groups;
//  }
//}