/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MahasiswaPage;


import java.util.List;

public interface InterfaceDAOMahasiswa {
    public void insert(mahasiswapage mahasiswa);
    
    public void update(mahasiswapage mahasiswa);
    
    public void delete(int id);
    
    public List<mahasiswapage> getAll();
}
