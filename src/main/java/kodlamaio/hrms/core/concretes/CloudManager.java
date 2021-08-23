package kodlamaio.hrms.core.concretes;



import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.abstracts.CloudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
@Service
public class CloudManager implements CloudService{

	private final Cloudinary cloudinary;
	
	public CloudManager() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","eymen" );
        valuesMap.put("api_key", "719589183575364" );
        valuesMap.put("api_secret","PxIedQA22SNhq06mQtiK8liGjyQ" );
        cloudinary = new Cloudinary(valuesMap);
    }
	
	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya Yuklenemedi");
        }
    }
	
	@Override
    public DataResult<Map> delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessDataResult<>(result);
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }
	
	
	
	
}
