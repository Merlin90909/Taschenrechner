import java.util.Scanner;
public class Taschenrechner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib den ersten Wert ein:");
        double a = scanner.nextDouble();
        System.out.println("Bitte gib den zweiten Wert ein:");
        double b = scanner.nextDouble();
        System.out.println("Bitte gib die Rechenoperation ein:");
        scanner.nextLine(); // diese Zeile schluckt den übrig gebliebenen \n
        String x = scanner.nextLine();
        double ergebnis;


        if(x.equals("+")){
            ergebnis = a+b;
            System.out.println(ergebnis);
        } else if (x.equals("-")) {
            ergebnis = a-b;
            System.out.println(ergebnis);
        } else if (x.equals("*")) {
            ergebnis = a*b;
            System.out.println(ergebnis);
        } else if (x.equals("/")) {
            ergebnis = a/b;
            System.out.println(ergebnis);
        }
    }
}
