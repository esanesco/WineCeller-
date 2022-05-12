package fr.eni.tp.service;

import fr.eni.tp.bo.Wine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WineService {

    public List<Wine> findAll();
    public Wine findById(Long id);
    public void save(Wine wine);
    public void delete(Long id);

}
