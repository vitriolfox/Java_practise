public class Main {
    public static void main(String[] args) {
        Factory gyar = new WindowsFactory();

        Button gomb = gyar.createButton();
        Checkbox csekboksz = gyar.createCheckbox();
    }
}
