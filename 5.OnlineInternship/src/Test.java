import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File tmp = File.createTempFile("pre","sfx");
        System.out.println(tmp.getAbsolutePath());
        System.out.println("finisht");
    }
}
