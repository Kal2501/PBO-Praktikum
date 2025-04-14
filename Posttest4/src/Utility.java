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
        System.out.println(
                "========================================================================================================");
        System.out.printf("| %-4s | %-15s | %-20s | %-15s | %-15s | %-15s |\n",
                "No", "Merk", "Nama", "Mesin", "Harga", "Bahan Bakar");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------");

        for (Mobil mobil : mobilList) {
            System.out.printf("| %-4d | %-15s | %-20s | %-15s | Rp%,13d | %-15s |\n",
                    index++, mobil.getMerk(), mobil.getNama(), mobil.getMesin(), mobil.getHarga(),
                    mobil.getBahanBakar());
        }

        System.out.println(
                "========================================================================================================");
    }

}