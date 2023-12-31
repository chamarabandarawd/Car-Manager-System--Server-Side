package icet.edu.CMS.service;

import icet.edu.CMS.dao.VanEntity;
import icet.edu.CMS.dto.Van;
import icet.edu.CMS.repository.VanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service

public class VanServiceImpl implements VanService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VanRepository vanRepository;

    public Van addVan(Van van){
      VanEntity vanEntity=modelMapper.map(van, VanEntity.class);
      return modelMapper.map(vanRepository.save(vanEntity), Van.class);

    }

    public List<Van> getAllVans(){

        return vanRepository.findAll().stream()
                .map(van -> modelMapper.map(van, Van.class))
                .collect(Collectors.toList());
    }

    public Van getById(Long id){

        return modelMapper.map(vanRepository.findById(id), Van.class);
    }
    
    public List<Van> getHostVans(){
       List<VanEntity> vanList= vanRepository.findVanEntitiesByHostId("123");
        return vanList.stream()
                .map(van->modelMapper.map(van,Van.class))
                .collect(Collectors.toList());
    }

    public HashMap<String, String> deleteVanById(Long id){
        HashMap<String,String> deleteResponse=new HashMap<>();
        try{
            vanRepository.deleteById(id);
            String deleteMsg=id+" - this item was deleted";
            deleteResponse.put("message",deleteMsg);
            return deleteResponse;
        }
        catch(RuntimeException e){
            String deleteMsg=id+" - this item not found!";
            deleteResponse.put("message",deleteMsg);
            return deleteResponse;
        }

    }

    public void updateVan(Van van){
        VanEntity vanEntity=modelMapper.map(van,VanEntity.class);
        vanRepository.save(vanEntity);
    }
}
