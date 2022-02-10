import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MyNumberOfStudentStudentNotInClassNumber130 {

   @Test
   public void test() {
      String newLine="";
      if (System.getProperty("os.name").startsWith("Windows")) {
         newLine="\r\n";
      } else {
         newLine="\n";
      }

      InputStream stdin = System.in;

      int numberOfStudent=157;

      String input=String.valueOf(numberOfStudent)+newLine;
      System.setIn(new ByteArrayInputStream(input.getBytes()));

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(byteArrayOutputStream);
      PrintStream stdout = System.out;
      System.setOut(ps);

      MyNumberOfStudent.main(new String[0]);

      System.setIn(stdin);
      System.setOut(stdout);

      String expected="A nem feltoltott osztalyba felveheto diakok szama:25"+newLine;
      String actual=byteArrayOutputStream.toString();

      System.out.println("Elvart:"+newLine+expected);
      System.out.println("Aktualis:"+newLine+actual);

      boolean found=actual.contains(expected);

      Assertions.assertTrue(found,"Csonka osztaly eseten annak letszamat rosszul hatarozta meg!");
   }
}
