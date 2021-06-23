public class Main {
    public static void main(String[] args) {
        char[] arr = new char[3];
        for (char c : arr) {
            System.out.println(c);
            System.out.println(String.valueOf(c).isEmpty());
            System.out.println(String.valueOf(c).isBlank());
        }
    }
}
