import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static int fakturCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        if (!login.logIn(scanner)) {
            System.out.println("Login gagal. Program dihentikan.");
            return;
        }

        System.out.println("Selamat Datang di Supermarket TefaMart");
        Date currentDate = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'pada' hh:mm:ss a zzz");
        System.out.println("Tanggal dan Waktu: " + ft.format(currentDate));

        String lanjut;
        do {
            try {
                System.out.print("\nMasukkan Nama Barang: ");
                String namaBarang = scanner.nextLine().trim().toUpperCase();

                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine().trim();

                System.out.print("Masukkan Harga Barang: ");
                double hargaBarang = Double.parseDouble(scanner.nextLine());

                if (hargaBarang <= 0) {
                    throw new IllegalArgumentException("Harga barang harus lebih dari 0!");
                }

                System.out.print("Masukkan Jumlah Beli: ");
                int jumlahBeli = Integer.parseInt(scanner.nextLine());

                if (jumlahBeli <= 0) {
                    throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!");
                }

                String noFaktur = "FTR" + String.format("%03d", fakturCounter++);
                Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

                System.out.println("\n+----------------------------------------------------+");
                System.out.println(transaksi);
                System.out.println("+----------------------------------------------------+");
                System.out.println("Kasir: Ridho Dwi Syahputra");
                System.out.println("+----------------------------------------------------+");

            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka untuk harga barang atau jumlah beli!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Terjadi kesalahan yang tidak diketahui.");
            }

            System.out.print("\nApakah Anda ingin memasukkan transaksi lain? (YA/TIDAK): ");
            lanjut = scanner.nextLine().trim();
        } while (lanjut.equalsIgnoreCase("YA"));

        scanner.close();
        System.out.println("Terima kasih telah menggunakan program ini.");
    }
}