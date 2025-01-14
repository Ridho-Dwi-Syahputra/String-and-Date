public class Barang {
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;

    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public double hitungTotal(int jumlahBeli) {
        return hargaBarang * jumlahBeli;
    }

    @Override
    public String toString() {
        return "Nama Barang: " + namaBarang + "\n" +
               "Kode Barang: " + kodeBarang + "\n" +
               "Harga Barang: " + hargaBarang;
    }
}
