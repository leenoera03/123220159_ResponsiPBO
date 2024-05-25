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
import javax.swing.*;

public class InputDataDosen extends JFrame {

    JLabel header = new JLabel("Tambah Dosen");

    JLabel labelNama = new JLabel("Nama:");
    JTextField fieldNama = new JTextField();

    JLabel labelNIP = new JLabel("NIP:");
    JTextField fieldNIP = new JTextField();

    JButton tombolSimpan = new JButton("Simpan");
    JButton tombolBatal = new JButton("Batal");

    ControllerDosen controller;

    public InputDataDosen() {
        setTitle("Tambah Dosen");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(300, 300);

        add(header);
        add(labelNama);
        add(fieldNama);
        add(labelNIP);
        add(fieldNIP);
        add(tombolSimpan);
        add(tombolBatal);

        header.setBounds(20, 8, 260, 24);
        labelNama.setBounds(20, 36, 80, 24);
        fieldNama.setBounds(100, 36, 160, 24);
        labelNIP.setBounds(20, 66, 80, 24);
        fieldNIP.setBounds(100, 66, 160, 24);
        tombolSimpan.setBounds(20, 96, 240, 24);
        tombolBatal.setBounds(20, 126, 240, 24);

        controller = new ControllerDosen(this);

        tombolSimpan.addActionListener(e -> controller.insertDosen());
        tombolBatal.addActionListener(e -> {
            dispose();
            new ViewDataDosen();
        });
    }

    public String getInputNama() {
        return fieldNama.getText();
    }

    public String getInputNIP() {
        return fieldNIP.getText();
    }
}

