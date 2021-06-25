import java.io.*;

public class Task {
    public static void main(String[] ar) {
        Task t = new Task();
        Database d = t.readCSV("./resources/iris.data");
//        System.out.println(d.getData()[1][0]);
//        System.out.println(d.getValue("s-width",121));
//        System.out.println(d.getNumRows()+1);
//        System.out.println(d.getColNames()[d.getColNames().length-1]);
    }

    public Database readCSV(String filename) {
        String contents = "";
        try (InputStream in = new BufferedInputStream(new FileInputStream(filename))){
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                String kb = new String(buffer, 0, lengthRead);
                contents = contents + kb;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return (new Database(contents));
    }
}
