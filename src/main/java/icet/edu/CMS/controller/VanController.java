package icet.edu.CMS.controller;

import icet.edu.CMS.dao.VanEntity;
import icet.edu.CMS.dto.Van;
import icet.edu.CMS.service.VanService;
import icet.edu.CMS.service.VanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vans")
public class VanController {

    @Autowired
    private VanServiceImpl vanService;

    @PostMapping
    public Van addVan(@RequestBody Van van){
        return vanService.addVan(van);
    }

    @GetMapping
    public List<Van> getAllVans(){
        return vanService.getAllVans();
    }
}
