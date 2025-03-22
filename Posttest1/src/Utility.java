import java.util.Scanner;

public class Utility {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Gagal membersihkan layar!");
        }
    }

    public static void tekanEnter(Scanner scanner) {
        System.out.println("Tekan Enter untuk keluar/lanjut...");
        scanner.nextLine();
        clearScreen();
        return;
    }
}