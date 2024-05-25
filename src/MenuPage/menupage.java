/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menupage extends JFrame implements ActionListener {
    JLabel header = new JLabel();
    
    JButton tombolMahasiswa = new JButton("Mahasiswa");
    JButton tombolDosen = new JButton("Dosen");
    JButton tombolLogout = new JButton("Logout");

    menupage(String username, String password) {
        
        setVisible(true);
        setSize(480, 480);
        setTitle("Menu Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        add(header);
      
        add(tombolMahasiswa);
        add(tombolDosen);
        add(tombolLogout);

        header.setText("Selamat datang, " + username);
        header.setFont(header.getFont().deriveFont(20.0f));
        header.setBounds(20, 20, 440, 24);

        tombolMahasiswa.setBounds(14, 200, 452, 36);
        tombolDosen.setBounds(14, 240, 452, 36);
        tombolDosen.setBounds(14, 2800, 452, 36);

        tombolMahasiswa.addActionListener(this);
        tombolDosen.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolMahasiswa) {
            new mahasiswapage();
        } else if (e.getSource() == tombolDosen) {
            new dosenpage();
        }
        else if (e.getSource() == tombolLogout) {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }
}
