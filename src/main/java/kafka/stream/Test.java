package kafka.stream;

public class Test {
    public static void main(String[] args) {
        String line = "123>>>ads";
        line = line.replaceAll(">>>","---");
        System.out.println(line);

    }
}
