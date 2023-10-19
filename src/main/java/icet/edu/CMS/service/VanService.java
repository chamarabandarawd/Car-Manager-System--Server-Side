package icet.edu.CMS.service;

import icet.edu.CMS.dao.VanEntity;
import icet.edu.CMS.dto.Van;

import java.util.List;

public interface VanService {
    public Van addVan(Van van);
    public List<Van> getAllVans();
    public Van getById(Long id);
    public List<Van> getHostVans();
}
