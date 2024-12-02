import java.util.Scanner;

public class prestasikel1 {
    private static final int MAX_ENTRIES = 100;
    private static String[][] prestasiData = new String[MAX_ENTRIES][5];
    private static int entryCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (choice) {
                case 1:
                    addPrestasiData(scanner);
                    break;
                case 2:
                    displayPrestasiData();
                    break;
                case 3:
                    analyzePrestasiData(scanner);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);
    }

    private static void displayMenu() {
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data Prestasi");
        System.out.println("2. Tampilkan Daftar Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void addPrestasiData(Scanner scanner) {
        if (entryCount >= MAX_ENTRIES) {
            System.out.println("Maaf, data prestasi sudah mencapai kapasitas maksimal.");
            return;
        }

        System.out.print("Masukkan nama mahasiswa: ");
        prestasiData[entryCount][0] = scanner.nextLine();

        System.out.print("Masukkan NIM mahasiswa: ");
        prestasiData[entryCount][1] = scanner.nextLine();

        System.out.print("Masukkan jenis prestasi: ");
        prestasiData[entryCount][2] = scanner.nextLine();

        System.out.print("Masukkan tingkat prestasi (Lokal/Nasional/Internasional): ");
        prestasiData[entryCount][3] = scanner.nextLine();

        System.out.print("Masukkan tahun prestasi (2010 - 2024): ");
        int tahun = scanner.nextInt();
        scanner.nextLine();

        if (tahun < 2010 || tahun > 2024) {
            System.out.println("Tahun prestasi tidak valid. Silakan coba lagi.");
            return;
        }

        prestasiData[entryCount][4] = String.valueOf(tahun);
        entryCount++;
        System.out.println("Data prestasi berhasil ditambahkan.");
    }

    private static void displayPrestasiData() {
        System.out.println("=== DAFTAR PRESTASI MAHASISWA ===");
        System.out.println("Nama\tNIM\tJenis\tTingkat\tTahun");

        for (int i = 0; i < entryCount; i++) {
            System.out.println(prestasiData[i][0] + "\t" +
                              prestasiData[i][1] + "\t" +
                              prestasiData[i][2] + "\t" +
                              prestasiData[i][3] + "\t" +
                              prestasiData[i][4]);
        }
    }

    private static void analyzePrestasiData(Scanner scanner) {
        System.out.println("=== ANALISIS PRESTASI ===");
        System.out.print("Masukkan jenis prestasi yang ingin dianalisis: ");
        String jenisPrestasiTarget = scanner.nextLine();

        int localCount = 0;
        int nasionalCount = 0;
        int internasionalCount = 0;

        for (int i = 0; i < entryCount; i++) {
            if (prestasiData[i][2].equals(jenisPrestasiTarget)) {
                if (prestasiData[i][3].equals("Lokal")) {
                    localCount++;
                } else if (prestasiData[i][3].equals("Nasional")) {
                    nasionalCount++;
                } else if (prestasiData[i][3].equals("Internasional")) {
                    internasionalCount++;
                }
            }
        }

        System.out.println("Jumlah prestasi " + jenisPrestasiTarget + " berdasarkan tingkat:");
        System.out.println("Lokal: " + localCount);
        System.out.println("Nasional: " + nasionalCount);
        System.out.println("Internasional: " + internasionalCount);
    }
}