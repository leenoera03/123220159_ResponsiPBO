/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DosenPage;

import java.util.List;

public interface InterfaceDAODosen {
    public void insert(dosenpage dosen);
    
    public void update(dosenpage dosen);
    
    public void delete(int id);
    
    public List<dosenpage> getAll();
}

