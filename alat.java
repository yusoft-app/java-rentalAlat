package apprentalalatgunung;
import java.text.*;
import java.util.*;

public class alat extends AppRentalAlatGunung{
    public ArrayList<String> namaAlat = new ArrayList();
    public ArrayList<Integer> qtyAlat = new ArrayList();
    public ArrayList<Integer> qtyBooking = new ArrayList();
    public ArrayList<Double> biayaAlat = new ArrayList();
    private int qtySisa;
    private int err = 1;
    private int tampilMenu = 0;
//    Scanner inputan = new Scanner(System.in);
//    AppRentalAlatGunung awal = new AppRentalAlatGunung();
    
    public void menuAlat(){
        System.out.println("#----------------#");
        System.out.println("# MENU PERALATAN #");
        System.out.println("#----------------#");
        System.out.println("[1] Daftar Alat");
        System.out.println("[2] Tambah Alat");
        System.out.println("[3] Ubah Alat");
        System.out.println("[4] Hapus Alat");
        System.out.println("[5] Kembali ke Menu Utama");
        err = 1;
        while(err == 1){
            System.out.println("");
            System.out.print("Pilih menu peralatan [1 ~ 5]: ");
            int menuAlat = inputan.nextInt();
            err = 0;
            if (menuAlat < 1 || menuAlat > 5){
                err = 1;
            }
            switch (menuAlat){
                case 1: tampilMenu = 1; peralatan.listAlat(); break;
                case 2: peralatan.tambahAlat(); break;
                case 3: peralatan.ubahAlat(); break;
                case 4: peralatan.hapusAlat(); break;
                case 5: menuUtama(); break;
                default: System.out.println("Pilihan salah! Ulangi!");
            }
        }
    }
    
    public void listAlat(){
        //Membuat format Rp.
        DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kurs.setDecimalFormatSymbols(formatRp);

        if(namaAlat.isEmpty()){
            System.out.println("Belum ada alat terdata. Tambahkan terlebih dahulu beberapa alat!");
            tampilMenu = 1;
        }else{
            System.out.println("+---------------------------------------------------------------------------------+");
            System.out.println("| NO |    Nama Alat    | Qty Alat | Qty Disewa | Qty Tersedia | Biaya Sewa / hari |");
            System.out.println("|----|-----------------|----------|------------|--------------|-------------------|");
            for(int i = 0; i < peralatan.namaAlat.size(); i++){
                qtySisa = peralatan.qtyAlat.get(i) - peralatan.qtyBooking.get(i);
                System.out.printf("|%-4s|%-17s|%-10s|%-12s|%-14s| Rp.%14s |%n",i+1,peralatan.namaAlat.get(i),peralatan.qtyAlat.get(i),peralatan.qtyBooking.get(i),qtySisa,kurs.format(peralatan.biayaAlat.get(i)));
            }
            System.out.println("|---------------------------------------------------------------------------------|");
        }
        if(tampilMenu == 1){
            tampilMenu = 0;
            peralatan.menuAlat();
        }
    }
    
    public void tambahAlat(){
        System.out.print("Nama  : ");
        String nama = inputan.next();
        System.out.print("Qty   : ");
        int qty = inputan.nextInt();
        System.out.print("Biaya : ");
        double biaya = inputan.nextDouble();
        peralatan.namaAlat.add(nama);
        peralatan.qtyAlat.add(qty);
        peralatan.biayaAlat.add(biaya);
        peralatan.qtyBooking.add(0);
        peralatan.menuAlat();
    }
    
    public void ubahAlat(){
        listAlat();
        System.out.print("Pilih nomor alat yang akan diubah : ");
        int index = inputan.nextInt();
        System.out.print("Ubah Nama  : ");
        String nama = inputan.next();
        System.out.print("Ubah Qty   : ");
        int qty = inputan.nextInt();
        System.out.print("Ubah Biaya : ");
        double biaya = inputan.nextDouble();
        peralatan.namaAlat.set(index-1, nama);
        peralatan.qtyAlat.set(index-1, qty);
        peralatan.biayaAlat.set(index-1, biaya);
        peralatan.menuAlat();
    }
    
    public void ubahQtyBooking(int nmrAlat, int qtyUbah){
        peralatan.qtyBooking.set(nmrAlat-1, qtyUbah);
    }
    
    public void hapusAlat(){
        listAlat();
        System.out.print("Pilih nomor alat yang akan dihapus : ");
        int index = inputan.nextInt();
        peralatan.namaAlat.remove(index-1);
        peralatan.qtyAlat.remove(index-1);
        peralatan.biayaAlat.remove(index-1);
        peralatan.qtyBooking.remove(index-1);
        peralatan.menuAlat();
    }
}
