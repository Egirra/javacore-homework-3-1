import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static Date dateNow = new Date();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) {
        List<File> folderList = Arrays.asList(
                new File("C://Games", "src"),
                new File("C://Games", "res"),
                new File("C://Games", "savegames"),
                new File("C://Games", "temp"),
                new File("C://Games/src", "main"),
                new File("C://Games/src", "test"),
                new File("C://Games/res", "drawables"),
                new File("C://Games/res", "vectors"),
                new File("C://Games/res", "icons")
        );

        List<File> fileList = Arrays.asList(
                new File("C://Games/src/main//Main.java"),
                new File("C://Games/src/main//Utils.java"),
                new File("C://Games/temp//temp.txt")
        );
        folderCreation(folderList, sb);
        fileCreation(fileList, sb);

        try (FileWriter writer = new FileWriter("C://Games/temp//temp.txt")) {
            writer.append(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void folderCreation(List<File> folderList, StringBuilder sb) {
        for (File dir : folderList) {
            if (dir.mkdir()) {
                sb.append("Каталог " + dir.getName() + " создан - " + dir.getParent() +
                        " - " + dateFormat.format(dateNow) + "\n");
            }
        }
    }

    public static void fileCreation(List<File> fileList, StringBuilder sb) {
        for (File file : fileList) {
            try {
                if (file.createNewFile())
                    sb.append("Файл " + file.getName() + " создан - " + file.getParent() +
                            " - " + dateFormat.format(dateNow) + "\n");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}