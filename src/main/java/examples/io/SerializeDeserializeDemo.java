package examples.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDeserializeDemo {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(SerializeDeserializeDemo.class);
  private static final String FILE_NAME = "demofiles/output/merchandising-order.bin";

  public SerializeDeserializeDemo() throws IOException {
  }

  public static void main(String[] args) throws IOException {

    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

      ClassB onlyOneB = new ClassB();
      ClassA firstA = new ClassA(onlyOneB);
      ClassA secondA = new ClassA(onlyOneB);

      System.out.println("Is the ClassB object in both ClassA objects the same? --> ");
      if (firstA.getMyB() == secondA.getMyB()) {
        System.out.println("YESS!");
      } else {
        System.out.println("NOO!");
      }

      out.writeObject(firstA);
      out.writeObject(secondA);
    }

    try (ObjectInputStream in =
             new ObjectInputStream(new FileInputStream(FILE_NAME))) {
      ClassA againFirstA = (ClassA) in.readObject();
      ClassA againSecondA = (ClassA) in.readObject();

      System.out.println("Is the ClassB object in both ClassA objects the same? --> ");
      if (againFirstA.getMyB() == againSecondA.getMyB()) {
        System.out.println("YESS!");
      } else {
        System.out.println("NOO!");
      }

    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }


  static class ClassA implements Serializable {
    private final ClassB myB;

    public ClassA(final ClassB myB) {
      this.myB = myB;
    }

    public ClassB getMyB() {
      return myB;
    }
  }

  static class ClassB implements Serializable {
    private final String id = "foobar";
  }
}

