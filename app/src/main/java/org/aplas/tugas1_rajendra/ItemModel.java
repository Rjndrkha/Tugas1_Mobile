package org.aplas.tugas1_rajendra;

public class ItemModel {

    String nama,type;
    int gambar;

    public ItemModel(String nama, String type, int gambar) {
        this.nama = nama;
        this.type = type;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
