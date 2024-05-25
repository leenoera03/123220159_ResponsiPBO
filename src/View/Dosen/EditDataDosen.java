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
import DosenPage.DAODosen;
import DosenPage.dosenpage;
import javax.swing.*;

public class EditDataDosen extends JFrame {

    JLabel header = new JLabel("Edit Dosen");

    JLabel labelNama = new JLabel("Nama:");
    JTextField fieldNama = new JTextField();

    JLabel labelNo_hp = new JLabel("No Hp:");
    JTextField fieldNo_hp = new JTextField();
    
    JLabel labelEmail = new JLabel("Email:");
    JTextField fieldEmail = new JTextField();

    JButton tombolSimpan = new JButton("Simpan");
    JButton tombolBatal = new JButton("Batal");

    ControllerDosen controller;
    DAODosen daoDosen = new DAODosen();

    public EditDataDosen(int id) {
        dosenpage dosen = daoDosen.getAll().stream().filter(d -> d.getId() == id).findFirst().orElse(null);
        if (dosen != null) {
            fieldNama.setText(dosen.getNama());
            fieldNo_hp.setText(dosen.getNo_hp());
            fieldEmail.setText(dosen.getEmail());
            
        }

        setTitle("Edit Dosen");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(300, 300);

        add(header);
        add(labelNama);
        add(fieldNama);
        add(labelNo_hp);
        add(fieldNo_hp);
        add(labelEmail);
        add(fieldEmail);
        add(tombolSimpan);
        add(tombolBatal);

        header.setBounds(20, 8, 260, 24);
        labelNama.setBounds(20, 36, 80, 24);
        fieldNama.setBounds(100, 36, 160, 24);
        labelNo_hp.setBounds(20, 66, 80, 24);
        fieldNo_hp.setBounds(100, 66, 160, 24);
        labelEmail.setBounds(20, 96, 80, 24);
        fieldEmail.setBounds(100, 96, 160, 24);
        tombolSimpan.setBounds(20, 96, 240, 24);
        tombolBatal.setBounds(20, 126, 240, 24);

        controller = new ControllerDosen(this);

        tombolSimpan.addActionListener(e -> controller.editDosen(id));
        tombolBatal.addActionListener(e -> {
            dispose();
            new ViewDataDosen();
        });
    }

    public String getInputNama() {
        return fieldNama.getText();
    }

    public String getInputNoHp() {
        return fieldNo_hp.getText();
    }
    
    public String getInputEmail() {
        return fieldEmail.getText();
    }
}

