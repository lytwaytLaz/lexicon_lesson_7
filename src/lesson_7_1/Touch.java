package lesson_7_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-06-15
 */
public class Touch {
    public static void main(String... args) {
        if (args.length == 0) {
            if (args[0].equals("-d") && args.length == 5) {
                System.err.println("Usage: java Touch [-d yyyy.MM.dd HH:mm:ss z] pathname");
                System.exit(1);
            }
        }

        String timeDate = args[1] + " " + args[2] + " " + args[3];
        Path p1 = Paths.get(args[4]);

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss z");
            ZonedDateTime zonTid = ZonedDateTime.parse(timeDate, format);
            Files.setLastModifiedTime(p1, FileTime.from(zonTid.toInstant()));
            System.out.println("Time: " + zonTid.toString());
        } catch (DateTimeParseException|IOException e) {
            e.printStackTrace();
        }
//        FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());

    }
//            FileTime now = FileTime.fromMillis(System.currentTimeMillis());


}

