package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
	//kendi sorgularım
	JobAdvertisement getAllByEmployer_IdAndIsActiveTrue (int employerId);  
	List<JobAdvertisement> getAllByIsActiveTrue();
	List<JobAdvertisement> getAllByIsActiveTrueOrderByCreatedTimeDesc();
	List<JobAdvertisement> getAllByIsActiveTrueOrderByCreatedTimeAsc();
	JobAdvertisement getAllByEmployer_CompanyNameAndIsActiveTrue (String companyName);  

	
	
}
