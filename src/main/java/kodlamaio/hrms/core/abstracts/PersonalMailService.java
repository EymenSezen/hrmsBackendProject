package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.abstracts.User;

public interface PersonalMailService {
  void personalVerificationMail(User user);
}
