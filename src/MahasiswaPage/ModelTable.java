/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MahasiswaPage;


/**
 *
 * @author DELL
 */


import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTable extends AbstractTableModel {

    // Berfungsi untuk menyimpan daftar mahasiswa
    List<mahasiswapage> daftarMahasiswa;

       String kolom[] = {"ID", "Nama", "NIM", "Email", "Password", "Angkatan"};

    public ModelTable(List<mahasiswapage> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    @Override
    public int getRowCount() {
        return daftarMahasiswa.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarMahasiswa.get(rowIndex).getId();
            case 1:
                return daftarMahasiswa.get(rowIndex).getNama();
            case 2:
                return daftarMahasiswa.get(rowIndex).getNim();
            case 3:
                return daftarMahasiswa.get(rowIndex).getEmail();
            case 4:
                return daftarMahasiswa.get(rowIndex).getPass();
            case 5:
                return daftarMahasiswa.get(rowIndex).getAngkatan();    
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}

