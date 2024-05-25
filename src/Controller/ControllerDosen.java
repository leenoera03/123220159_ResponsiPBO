/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author DELL
 */

import DosenPage.*;
import View.Dosen.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerDosen {

    ViewDataDosen halamanTable;
    InputDataDosen halamanInput;
    EditDataDosen halamanEdit;

    InterfaceDAODosen daoDosen;

    List<dosenpage> daftarDosen;

    public ControllerDosen(ViewDataDosen halamanTable) {
        this.halamanTable = halamanTable;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(InputDataDosen halamanInput) {
        this.halamanInput = halamanInput;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(EditDataDosen halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoDosen = new DAODosen();
    }

    public void showAllDosen() {
        daftarDosen = daoDosen.getAll();
        ModelTableDosen table = new ModelTableDosen(daftarDosen);
        halamanTable.getTableDosen().setModel(table);
    }

    public void insertDosen() {
        try {
            dosenpage dosenBaru = new dosenpage();
            String nama = halamanInput.getInputNama();
            String no_hp = halamanInput.getInputNoHp();
            String email = halamanInput.getInputEmail();

            if ("".equals(nama) || "".equals(no_hp)) {
                throw new Exception("Datatidak boleh kosong!");
            }
            
            dosenBaru.setNama(nama);
            dosenBaru.setNo_hp(no_hp);
            dosenBaru.setEmail(email);
            daoDosen.insert(dosenBaru);
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");
            halamanInput.dispose();
            new ViewDataDosen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editDosen(int id) {
        try {
            dosenpage dosenYangMauDiedit = new dosenpage();
            String nama = halamanEdit.getInputNama();
            String no_hp = halamanEdit.getInputNoHp();
            String email = halamanEdit.getInputEmail();

            if ("".equals(nama) || "".equals(no_hp)) {
                throw new Exception("Nama atau NIP tidak boleh kosong!");
            }
            
            dosenYangMauDiedit.setId(id);
            dosenYangMauDiedit.setNama(nama);
            dosenYangMauDiedit.setNo_hp(no_hp);
            dosenYangMauDiedit.setEmail(email);
            daoDosen.update(dosenYangMauDiedit);
            JOptionPane.showMessageDialog(null, "Data dosen berhasil diubah.");
            halamanEdit.dispose();
            new ViewDataDosen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteDosen(Integer baris) {
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();
        int input = JOptionPane.showConfirmDialog(null, "Hapus " + nama + "?", "Hapus Dosen", JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            daoDosen.delete(id);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            showAllDosen();
        }
    }
}

