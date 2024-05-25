/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Dosen;

/**
 *
 * @author DELL
 */

import Controller.ControllerDosen;
import Model.Dosen.ModelDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewDataDosen extends JFrame {

    Integer baris;
    ControllerDosen controller;

    JLabel header = new JLabel("Daftar Dosen");
    JButton tombolTambah = new JButton("Tambah Dosen");
    JButton tombolEdit = new JButton("Edit Dosen");
    JButton tombolHapus = new JButton("Hapus Dosen");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"ID", "Nama", "NIP"};

    public ViewDataDosen() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Daftar Dosen");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(552, 540);

        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);

        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 512, 320);
        tombolTambah.setBounds(20, 370, 512, 40);
        tombolEdit.setBounds(20, 414, 512, 40);
        tombolHapus.setBounds(20, 456, 512, 40);

        controller = new ControllerDosen(this);
        controller.showAllDosen();

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputDataDosen();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    int id = (int) table.getValueAt(baris, 0);
                    dispose();
                    new EditDataDosen(id);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah!");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteDosen(baris);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus!");
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = table.rowAtPoint(e.getPoint());
            }
        });
    }

    public JTable getTableDosen() {
        return table;
    }
}

