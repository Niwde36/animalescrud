package com.animales.crud.Service;
import com.animales.crud.Models.Especie;
import com.animales.crud.Dao.EspecieDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class EspecieService {
	@Autowired
	private EspecieDao especieDao;
	
	@Transactional(readOnly=false)
	public Especie save(Especie especie){
		return especieDao.save(especie);
	}

	@Transactional(readOnly=false)
	public void delete(String id) {
        especieDao.deleteById(id);
	}

	@Transactional(readOnly=true)
	public Especie findById(String id) {
		return especieDao.findById(id).orElse(null);
	}

	@Transactional(readOnly=true)
	public List<Especie> findAll() {
		return (List<Especie>) especieDao.findAll();
	}
}


