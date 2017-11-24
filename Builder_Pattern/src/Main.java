public class Main {
    public static void main(String[] args) {

        Complex complex = new Complex.Builder(1, 2).setBtr3(3).setBtr7(7).build();

        try {
            Complex complex2 = complex.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
