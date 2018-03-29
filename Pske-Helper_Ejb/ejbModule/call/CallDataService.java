package checkpoints;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.checkpoints.Call;

/**
 * Session Bean implementation class demoBean
 */
@Stateless
@LocalBean
@TransactionManagement (TransactionManagementType.CONTAINER)
public class DemoBean {

	@PersistenceContext(unitName="Pske-Helper_Jpa") private EntityManager em;
    /**
     * Default constructor. 
     */
    public DemoBean() {
    }
    
    public List<Call> getCalls()
    {
    	Query q = em.createNamedQuery(Call.GET_ALL_CALLS, Call.class);
    	
    	@SuppressWarnings("unchecked")
		List<Call> calls = (List<Call>) q.getResultList();
    	
    	return calls;
    }

}
