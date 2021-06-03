package dummy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equifax.dev.model.dao.ProductoDaoImpl;

@Service
public class DummyTest {
	
	@Autowired
	private ProductoDaoImpl dao;
	
	public List<Object> test1(){
		List<Object> lista = dao.findAllActiveProdByCliente(new Long(1));
		for(Object o: lista) {
			System.out.println(o);
		}
		return lista;
	}

}
