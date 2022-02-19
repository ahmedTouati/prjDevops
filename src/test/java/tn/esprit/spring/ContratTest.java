package tn.esprit.spring;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {

	private Contrat contrat;
	
	@Autowired
	IContratService iContratService ;
    
	@Autowired
	ContratRepository contratRepo ;
    @Before
    public void setUp()
    {
    	Date dateDebut=new Date();

		 contrat = new Contrat(dateDebut,"CDI",(float) 2.7); 
		
    }
    @Test
    public void tests() throws ParseException {
    	testAjouterContrat();
    	testSupprimerContrat();
    }
	
	public void testAjouterContrat() {

		int id = iContratService.ajouterContrat(this.contrat);
		assertEquals(id,this.contrat.getReference());
	}

	
	
	public void testSupprimerContrat() {
//		LOG.info("StartMethodSeleteDepartementById");
//		LOG.info(this.departement);
//		departement.setId(ientrepriseservice.ajouterDepartement(departement));
//		ientrepriseservice.deleteDepartementById(departement.getId());
//		Assert.assertFalse(deptRepoistory.findById(departement.getId()).isPresent());
//		LOG.info("EndDeleteDepartementById");
		
		int ref =iContratService.deleteContratById(this.contrat.getReference());;
		assertEquals(0, ref);
	}
		// TODO Auto-generated method stub
		

	
}
