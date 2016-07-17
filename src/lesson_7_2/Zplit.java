package lesson_7_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-06-16
 */
public class Zplit {
    public static void main(String[] args) throws IOException {
        if (args.length != 2)
        {
            System.err.println("usage: java Zplit zplitSize filePath");
            System.exit(1);
        }

        Path path = Paths.get(args[1]);
        Path pathName = path.getParent();
        Path fileName = path.getFileName();
        System.out.println(path + "\n" + pathName + "\n" + fileName);
        long maxByte = Long.parseLong((args[0]));
        long numOfFiles;

        if (Files.size(path) % maxByte == 0)
            numOfFiles = Files.size(path) / maxByte;
        else
            numOfFiles = Files.size(path) / maxByte + 1;

        Path output = pathName.resolve(fileName);

        //med buffer
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[1]));
        BufferedOutputStream out;
//        FileInputStream in = new FileInputStream(args[1]);
//        FileOutputStream out;
        int c;

        for (int i = 0; i < numOfFiles; i++)
        {
            //med buffer
            out = new BufferedOutputStream(new FileOutputStream(output.toString() + ".part" + i));

//            out = new FileOutputStream(output.toString() + ".part" + i);

            for (int j = 0; (c = in.read()) != -1 && j < maxByte; j++)
            {
                out.write(c);
            }
            out.close();
        }
        in.close();
    }
}
