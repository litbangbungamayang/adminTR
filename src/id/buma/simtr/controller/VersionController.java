/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.simtr.controller;

/**
 *
 * @author Bayu Anandavi Muhardika
 * 
 */

public class VersionController {
    
    String version;
    
    public String getVersion(){
        version = "0.9.1";
        /*
        + Versi pre-rilis
        + Sebagian besar GUI sudah tampil
        + Modul RDKK sudah di-test (UAT ke-1)
        */
        version = "0.9.2";
        /*
        + Nomor kontrak sudah di-generate otomatis
        + Ditambahkan pilihan untuk input kategori tanaman di modul RDKK
        */
        version = "0.9.3";
        /*
        + Pembatasan jumlah minimal luas lahan 5 Ha setiap kelompok
        */
        version = "0.9.4";
        /*
        + Membuat modul login
        + Menampilkan tabel kelompok sesuai dengan afdeling user
        */
        version = "0.9.5";
        /*
        + Menampilkan cetak Berita Acara SKK
        + Menampilkan cetak Kontrak TR
        + Mengganti alur, tidak pakai draft RDKK
        + Mengganti listener table Kelompok Tani di halaman verifikasi RDKK, 
            semula Mouse Listener, menjadi List Listener
        + Improvisasi master-child tabel Kelompok Tani dan Tabel Petani
        + Improvisasi auto Filter di tabel kelompok tani halaman validasi RDKK
        */
        version = "0.9.6";
        /*
        + Mengubah format cetak laporan, dibuat berada dalam JPanel
        */
        version = "0.9.7";
        /*
        + Menampilkan modul permintaan pupuk
        + Menambahkan handler untuk master-detail tabel
        */
        version = "0.9.8";
        /*
        + Perbaikan modul permintaan pupuk :
            ++ Perubahan algoritma untuk tampilan tabel permintaan pupuk
        */
        version = "0.9.9";
        /*
        + Perubahan format BA SKK
        */
        version = "0.9.10";
        /*
        + Penambahan modul admin pengguna
        */
        version = "0.9.11";
        /*
        + Migrasi database dari MS SQL ke MySQl
        + Penyesuaian di kelas koneksi database untuk menghindari resources leak
        */
        version = "0.9.12";
        /*
        + Penambahan modul manajemen pengguna
        */
        version = "0.9.13";
        /*
        + Penambahan listener untuk form login on keypress enter
        + Penambahan modul manajemen bahan produksi
        */
        version = "0.9.14";
        /*
        + Perubahan mode tampilan database pada form kelompok tani, apabila system admin dan penanggungjawab maka tidak dibatasi afdeling
        */
        version = "0.9.15";
        /*
        + Penambahan modul manajemen bahan produksi (pupuk dan bahan kimia lain pendukung produksi)
        + Perubahan stored_procedure untuk system admin dan penanggungjawab
        */
        version = "0.9.16";
        /*
        + Perubahan stored procedure dan struktur tabel transaksi pupuk. Ditambahkan kode transaksi dan nilai transaksi untuk mengakomodir
            pupuk masuk ke gudang
        + Perubahan stored procedure untuk CRUD kelompok tani
        + Overhaul DAOSQL transaksi pupuk
        */
        version = "0.9.17";
        /*
        + Penambahan modul monitoring bahan produksi untuk input barang masuk
        */
        version = "0.9.18";
        /*
        + Perbaikan UX untuk penambahan permintaan pupuk (ujicoba handler) setiap ganti nama kelompok, maka isian buffer akan di reset jika belum di submit
        */
        version = "0.9.19";
        /*
        + Penambahan cetak permintaan pupuk
        + Perbaikan stored procedure
        + Penambahan table bukti transaksi bahan
        + Perbaikan transaksi SQL untuk transaksi pupuk (menggunakan COMMIT)
        + Perubahan UI pada modul pupuk
        */
        version = "0.9.20";
        /*
        + Penambahan cetak rekapitulasi pemakaian biaya pupuk
        */
        version = "0.9.21";
        /*
        + Perubahan table model petani, untuk data kosong
        + Penambahan modul perawatan tanaman
        + Pengubahan panjang id petani di tabel menjadi 15 (varchar)
        + Pengubahan stored procedure penambahan petani baru, menjadi format SAP
        + Penambahan konfirmasi untuk penyimpanan transaksi pupuk
        + Perbaikan table model kelompok tani untuk data kosong
        + Perubahan nama tabel : semula TBL_TRANSAKSI_PUPUK menjadi TBL_TRANSAKSI
        + Penambahan field di TBL_TRANSAKSI = ID_BIAYA (INT)
        + Perubahan struktur report Rekap Evaluasi Pupuk
        */
        version = "0.9.22";
        /*
        + Perubahan lagi utk model petani, dikosongin lagi karena saat daftar kelompok tani, ada record kosong ikut
        + Insert data RDKK baru pakai batch
        + Penggabungan insert data RDKK baru dengan transaksi biaya ukur lahan (batch)
        + Penggabungan insert transaksi bahan/upah dengan nomor bukti (batch)
        */
        version = "0.9.23";
        /*
        + Perubahan common controller untuk error dan info pakai html tag
        + Pembuatan Kuitansi Permintaan Biaya Pupuk
        */
        version = "0.9.24";
        /*
        + Pembuatan table buffer permintaan perawatan kebun
        + Perubahan table row renderer petani (lebar kolom fleksibel)
        + Pembuatan form cetak bon dalam perawatan
        + Koreksi perhitungan biaya ukur lahan, sebelumnya dihitung dari total luas (RDKKController)
        + Perbaikan report bon dalam, nilai NULL dalam transaksi sampai dengan diubah menjadi 0
        + Perubahan flow permintaan pekerjaan perawatan kebun, semula satu kali transaksi hanya satu kali memilih petani dan
            pekerjaan, menjadi satu transaksi bisa beberapa pilihan kombinasi petani dan pekerjaan
        */
        version = "0.9.25";
        /*
        + Perbaikan penomoran transaksi pada permintaan pupuk
        + Perbaikan pengambilan data pada tabel buffer permintaan perawatan tanaman
        */
        version = "0.9.26";
        /*
        + Pembuatan form master data biaya perawatan
        */
        return version;
    }
        
}
