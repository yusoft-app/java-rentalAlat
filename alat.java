package apprentalalatgunung;
import java.util.*;

public class alat {
    private ArrayList namaAlat = new ArrayList();
    private ArrayList qtyAlat = new ArrayList();
    private ArrayList biayaAlat = new ArrayList();
    private int err = 1;
    private int tampilMenu = 0;
    Scanner inputan = new Scanner(System.in);
    AppRentalAlatGunung awal = new AppRentalAlatGunung();
    
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
                case 1: tampilMenu = 1; list(); break;
                case 2: tambah(); break;
                case 3: ubah(); break;
                case 4: hapus(); break;
                case 5: awal.menuUtama(); break;
                default: System.out.println("Pilihan salah! Ulangi!");
            }
        }
    }
    
    void list(){
        if(namaAlat.isEmpty()){
            System.out.println("Belum ada alat terdata. Tambahkan terlebih dahulu beberapa alat!");
            tampilMenu = 1;
        }else{
            for(int i = 0; i < namaAlat.size(); i++){
                System.out.println(String.format("[%d] %s", i, namaAlat.get(i)));
            }
        }
        if(tampilMenu == 1){
            tampilMenu = 0;
            menuAlat();
        }
    }
    
    void tambah(){
        System.out.print("Nama  : ");
        String nama = inputan.next();
        System.out.print("Qty   : ");
        int qty = inputan.nextInt();
        System.out.print("Biaya : ");
        double biaya = inputan.nextDouble();
        namaAlat.add(nama);
        qtyAlat.add(qty);
        biayaAlat.add(biaya);
        menuAlat();
    }
    
    void ubah(){
        list();
        System.out.print("Pilih nomor alat yang akan diubah : ");
        int index = inputan.nextInt();
        System.out.print("Ubah Nama  : ");
        String nama = inputan.next();
        System.out.print("Ubah Qty   : ");
        int qty = inputan.nextInt();
        System.out.print("Ubah Biaya : ");
        double biaya = inputan.nextDouble();
        namaAlat.set(index, nama);
        qtyAlat.set(index, qty);
        biayaAlat.set(index, biaya);
        menuAlat();
    }
    
    void hapus(){
        list();
        System.out.print("Pilih nomor alat yang akan dihapus : ");
        int index = inputan.nextInt();
        namaAlat.remove(index);
        qtyAlat.remove(index);
        biayaAlat.remove(index);
        menuAlat();
    }
}
