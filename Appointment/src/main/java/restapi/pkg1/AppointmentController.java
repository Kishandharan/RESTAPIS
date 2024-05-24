package restapi.pkg1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	
	public static List<AppointmentModel> loaddata(String fname)throws FileNotFoundException {
		List<AppointmentModel> li1 = new ArrayList<>();
		File f1 = new File(fname);
		Scanner sc1 = new Scanner(f1);
		while(sc1.hasNextLine()) {
			String[] arr1 = sc1.nextLine().split(",");
			li1.add(new AppointmentModel(arr1[0], arr1[1], arr1[2], arr1[3], arr1[4]));
		}
		return li1;
	}
	
	@GetMapping("/apponts/getall/{fname}")
	public static List<String> getAll() throws Exception{
		List<AppointmentModel> li1 = new ArrayList<>();
		List<String> msg1 = new ArrayList<>();
		li1 = loaddata("data.txt");
		String s1 = "";
		String name = li1.get(0).getData()[0];
		String salary = li1.get(0).getData()[1];
		String city = li1.get(0).getData()[2];
		String date = li1.get(0).getData()[3];
		String email = li1.get(0).getData()[4];
		String msg2 = "Dear "+name+",\nYou have been appointed as Centre Head at "+city+" with "+salary+".\n Please report for duty on "+date;
		msg1.add(msg2);
		return msg1;
	}
	
	@Autowired
	MailService ms;
	
	@GetMapping("/apponts/send")
	public String send() throws Exception {
		ms.sendmail();
		return "Mail Sent";
	}	
}
