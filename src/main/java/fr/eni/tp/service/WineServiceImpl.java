package fr.eni.tp.service;

import fr.eni.tp.bo.Wine;
import fr.eni.tp.dal.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImpl implements WineService{

    private WineRepository wineRepository;

    @Autowired
    public WineServiceImpl(WineRepository wineRepository){
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> findAll() {
        return wineRepository.findAll();
    }

    @Override
    public Wine findById(Long id) {
        Optional<Wine> result = wineRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }else {
            throw new RuntimeException("Wine not found, id: "+ id);
        }
    }

    @Override
    public void save(Wine wine) {
        boolean isValid = validateWine(wine);
        if (isValid){
            wineRepository.save(wine);
        }
    }

    private boolean validateWine(Wine wine) {
        boolean isValid = true;
        if (wine.getName().length()<5 || wine.getName().length()>50){
            isValid = false;
        }

        return isValid;
    }

    @Override
    public void delete(Long id) {
        wineRepository.deleteById(id);
    }
}
