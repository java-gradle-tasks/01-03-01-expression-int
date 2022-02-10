import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestPrintTaskSolution {

   @Test
   public void testInput() {

      String newLine="";
      if (System.getProperty("os.name").startsWith("Windows")) {
         newLine="\r\n";
      } else {
         newLine="\n";
      }

      InputStream stdin = System.in;

      int numberOfStudent=228;

      String input=String.valueOf(numberOfStudent)+newLine;
      System.setIn(new ByteArrayInputStream(input.getBytes()));

      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(byteArrayOutputStream);
      PrintStream stdout = System.out;
      System.setOut(ps);

      MyNumberOfStudent.main(new String[0]);

      System.setIn(stdin);
      System.setOut(stdout);

      String expected="Osztalyok szamanak meghatarozasa!"+newLine;
      expected+="Adja meg a tanulok szamat:Osztalyletszam:26"+newLine;
      expected+="Teljessen feltoltott osztalyok szama:8"+newLine;
      expected+="A nem feltoltott osztalyba felveheto diakok szama:6"+newLine;

      String actual=byteArrayOutputStream.toString();

      System.out.println("Elvart:"+newLine+expected);
      System.out.println("Aktualis:"+newLine+actual);

      Assertions.assertEquals(expected,actual,"A teljes feladat megoldasanak megjelenitese nem megfelelo!");
   }
}
