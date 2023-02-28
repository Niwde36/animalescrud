package com.animales.crud.Service;
import com.animales.crud.Models.Grupo;
import com.animales.crud.Dao.GrupoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GrupoService {
	@Autowired
	private GrupoDao grupoDao;
	
	@Transactional(readOnly=false)
	public Grupo save(Grupo grupo){
		return grupoDao.save(grupo);
	}

	@Transactional(readOnly=false)
	public void delete(String id) {
        grupoDao.deleteById(id);
	}

	@Transactional(readOnly=true)
	public Grupo findById(String id) {
		return grupoDao.findById(id).orElse(null);
	}

	@Transactional(readOnly=true)
	public List<Grupo> findAll() {
		return (List<Grupo>) grupoDao.findAll();
	}
}

