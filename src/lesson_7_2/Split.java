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
public class Split {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;


        int numOfFiles = 10;
        Path path = Paths.get(args[0]);
        Path pathName = path.getParent();
        Path fileName = path.getFileName();
        long size = Files.size(path); // to be split into 10 parts




        try {

            Path output = pathName.resolve(fileName);
//            System.out.println(output + " " + size);
            in = new FileInputStream(args[0]);

            int c;
            for (int i = 0; i < numOfFiles; i++)
            {
                out = new FileOutputStream(String.valueOf(output + ".part" + i));
                {
                    for (int j = 0; j < size / numOfFiles; j++)
//                    while ((c = in.read()) != -1 || (c = in.read()) != size / numOfFiles + beenRead) ;
                    {
                        c = in.read();
                        out.write(c);
                    }


                }







            }
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }


//        System.out.println(path + " " + size);




    }
}
