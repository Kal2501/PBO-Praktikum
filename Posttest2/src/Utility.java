import java.util.ArrayList;
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

    public static void dataMobil() {
        ArrayList<Mobil> mobilList = Mobil.getDaftarMobil();
        int index = 1;
        System.out.println("Daftar Mobil Tersedia:");
        System.out.println("================================================================================");
        System.out.printf("%-5s | %-15s | %-15s | %-15s | %-10s\n", "No", "Merk", "Nama", "Mesin", "Harga");
        System.out.println("--------------------------------------------------------------------------------");
        for (Mobil mobil : mobilList) {
            System.out.printf("%-5d | %-15s | %-15s | %-15s | Rp%,10d\n", (index), mobil.getMerk(), mobil.getNama(),
                    mobil.getMesin(), mobil.getHarga());
            index++;
            System.out.println("--------------------------------------------------------------------------------");
        }
        System.out.println("================================================================================");
    }
}