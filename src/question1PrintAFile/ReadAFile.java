package question1PrintAFile;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class ReadAFile {


	public static void main(String[]args) throws IOException {

        String fileName = new File("src/question1PrintAFile/test.txt").getAbsolutePath();
        boolean isfileexists =  isfileExist(fileName);
        String line = null;
        if (isfileexists){
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                SplitAndPrint(line);
            }
            br.close();
        }
    }

    public static void SplitAndPrint(String line){
        String lines[] = line.split("–");
        System.out.println(lines[0].trim());
        System.out.println(lines[1].trim());
    }

    public static boolean isfileExist(String path) {

        try {
            FileReader fr =
                    new FileReader(path);
            BufferedReader br =
                    new BufferedReader(fr);
            br.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
            return false;
        } catch (IOException ex) {
            System.out.println(ex);
            return false;
        }
    }
}
