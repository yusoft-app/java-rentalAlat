package apprentalalatgunung;
import java.text.*;
import java.util.*;

public class booking extends AppRentalAlatGunung{
    private int err = 1;
    private int tampilMenu = 1;
    private ArrayList<Integer> nmrAlat = new ArrayList();
    private ArrayList<String> namaUser = new ArrayList();
    private ArrayList<String> namaPeralatan = new ArrayList();
    private ArrayList<String> tglAmbil = new ArrayList();
    private ArrayList<String> tglKembali = new ArrayList();
    private ArrayList<Integer> qty = new ArrayList();
    private ArrayList<Double> biayaSewa = new ArrayList();
    AppRentalAlatGunung awal = new AppRentalAlatGunung();
    
    public void menuBooking(){
        System.out.println("#----------------#");
        System.out.println("#  MENU BOOKING  #");
        System.out.println("#----------------#");
        System.out.println("[1] Daftar Booking");
        System.out.println("[2] Tambah Booking");
        System.out.println("[3] Hapus Booking");
        System.out.println("[4] Kembali ke Menu Utama");
        err = 1;
        while(err == 1){
            System.out.println("");
            System.out.print("Pilih menu booking [1 ~ 4]: ");
            int menuAlat = inputan.nextInt();
            err = 0;
            if (menuAlat < 1 || menuAlat > 4){
                err = 1;
            }
            switch (menuAlat){
                case 1: tampilMenu = 1; booking.listBooking(); break;
                case 2: booking.tambahBooking(); break;
                case 3: booking.hapusBooking(); break;
                case 4: menuUtama(); break;
                default: System.out.println("Pilihan salah! Ulangi!");
            }
        }
    }
    
    public void listBooking(){
        //Membuat format Rp.
        DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kurs.setDecimalFormatSymbols(formatRp);
        Double totalBiaya;

        if(namaUser.isEmpty()){
            System.out.println("Belum ada daftar booking!");
            tampilMenu = 1;
        }else{
            System.out.println(" ## DAFTAR BOOKING ##");
            System.out.println("+--------------------------------------------------------------------------------------------------------+");
            System.out.println("| NO |    Nama User    | TGL Ambil | TGL Kembali |  Nama Alat  | Qty |   Biaya Sewa   | Total Biaya Sewa |");
            System.out.println("|----|-----------------|-----------|-------------|-------------|-----|----------------|------------------|");
            for(int i = 0; i < namaUser.size(); i++){
                totalBiaya = biayaSewa.get(i) * qty.get(i);
                System.out.printf("|%-4s|%-17s|%-11s|%-13s|%-13s|%-5s| Rp.%11s | Rp.%13s |%n",i+1,namaUser.get(i),tglAmbil.get(i),tglKembali.get(i),namaPeralatan.get(i),qty.get(i),kurs.format(biayaSewa.get(i)),kurs.format(totalBiaya));
            }
            System.out.println("|--------------------------------------------------------------------------------------------------------|");
        }
        if(tampilMenu == 1){
            tampilMenu = 0;
            booking.menuBooking();
        }
    }
    
    public void tambahBooking(){
        //Membuat format Rp.
        DecimalFormat kurs = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kurs.setDecimalFormatSymbols(formatRp);
        
        if(peralatan.namaAlat.isEmpty()){
            System.out.println("Tidak bisa tambah Booking karena belum ada data alat! Tambahkan beberapa alat terlebih dahulu!");
            tampilMenu = 1;
        }else{
            peralatan.listAlat();
            System.out.print("Pilih nomor alat                  : ");
            int inputNmr = inputan.nextInt();
            System.out.print("Qty                               : ");
            int inputQty = inputan.nextInt();
            System.out.print("Nama User                         : ");
            String inputNama = inputan.next();
            System.out.print("TGL Ambil [Format: tgl-bln-thn]   : ");
            String inputTanggalAmbil = inputan.next();
            System.out.print("TGL Kembali [Format: tgl-bln-thn] : ");
            String inputTanggalKembali = inputan.next();
            namaPeralatan.add(peralatan.namaAlat.get(inputNmr - 1));
            nmrAlat.add(inputNmr-1);
            qty.add(inputQty);
            namaUser.add(inputNama);
            tglAmbil.add(inputTanggalAmbil);
            tglKembali.add(inputTanggalKembali);
            biayaSewa.add(peralatan.biayaAlat.get(inputNmr - 1));
            peralatan.ubahQtyBooking(inputNmr, inputQty);
            System.out.println("");
            System.out.println("==== NOTA SEWA BARANG AMANAH ADVENTURE ====");
            System.out.println(" Nama Pelanggan  : "+inputNama);
            System.out.println(" Nama Barang     : "+peralatan.namaAlat.get(inputNmr - 1));
            System.out.println(" Biaya Sewa      : Rp. " + kurs.format(peralatan.biayaAlat.get(inputNmr - 1)));
            System.out.println(" Qty             : "+inputQty);
            System.out.println(" TGL Ambil       : "+inputTanggalAmbil);
            System.out.println(" TGL Kembali     : "+inputTanggalKembali);
            System.out.println("-------------------------------------------");
            System.out.println(" TOTAL BAYAR     : Rp. " + kurs.format(peralatan.biayaAlat.get(inputNmr - 1) * inputQty));
            System.out.println("");
            System.out.println("Terimakasih atas kepercayaannya menggunakan peralatan kami.");
            System.out.println("");
            booking.menuBooking();
        }
    }
    
    public void hapusBooking(){
        tampilMenu = 0;
        booking.listBooking();
        System.out.print("Pilih nomor booking yang akan dihapus : ");
        int index = inputan.nextInt();
        int sisaQtyBooking = peralatan.qtyBooking.get(index-1) - booking.qty.get(index-1);
        peralatan.ubahQtyBooking(booking.nmrAlat.get(index-1)+1, sisaQtyBooking);
        booking.nmrAlat.remove(index-1);
        booking.namaUser.remove(index-1);
        booking.namaPeralatan.remove(index-1);
        booking.tglAmbil.remove(index-1);
        booking.tglKembali.remove(index-1);
        booking.qty.remove(index-1);
        booking.biayaSewa.remove(index-1);
        booking.menuBooking();
    }
}