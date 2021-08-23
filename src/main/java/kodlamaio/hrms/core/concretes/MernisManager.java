package kodlamaio.hrms.core.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
//sahte servis
public class MernisManager implements MernisService {

	@Override
	public boolean isRealPerson(JobSeeker jobSeeker) {
		
		return true;
		// TODO Auto-generated method stub
		/*boolean result = false;
		KPSPublicSoap client = new KPSPublicSoapProxy();
		try {
			result = client.TCKimlikNoDogrula(Integer.valueOf(jobSeeker.getId_no()), jobSeeker.getName().toUpperCase(),
					jobSeeker.getSurname().toUpperCase(), (int) jobSeeker.getBdayyear());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result) {
			System.out.println(jobSeeker.getName() + " başarıyla doğrulandı");
			return true;
		} else {
			System.out.println("girilen bilgiler yanlış");
			return false;
		}*/
	}

}
