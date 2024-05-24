package restapi.pkg1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private JavaMailSender jms;
	
	@Autowired
	AppointmentController ac;
	
	@Value("${spring.mail.username}")
	private String fm;
	
	public void sendmail() throws Exception{
		List<AppointmentModel>li1 = new ArrayList<>();
		List<String>msg = new ArrayList<>();
		li1 = ac.loaddata("data.txt");
		msg = ac.getAll();
		SimpleMailMessage smm = new SimpleMailMessage();
		for(int i = 0; i<li1.size(); i++) {
			smm.setFrom(fm);
			String to = li1.get(i).getData()[4];
			smm.setTo(to);
			smm.setSubject("HR Appointment");
			smm.setText(msg.get(i));
			jms.send(smm);
		}
	}
}
