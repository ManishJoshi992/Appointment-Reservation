package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.TMSessionController;
import com.example.demo.domain.Address;
import com.example.demo.domain.Appointment;
import com.example.demo.domain.AppointmentRequest;
import com.example.demo.domain.Person;
import com.example.demo.domain.RoleType;
import com.example.demo.domain.TMSession;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.TMSessionRepository;

@Component
public class StartupRunner implements CommandLineRunner {

	@Autowired
	private PersonRepository perosn;
	@Autowired
	private TMSessionRepository tmsess;

	@Override

	@Transactional
	public void run(String... args) throws Exception {

		System.out.println("hi"); 
		System.out.println("hi"); 
		System.out.println("hi"); 
		System.out.println("hi"); 
		
		Person per = new Person();
		per.setFirstName("user");
		per.setLastName("user");
		per.setEmailAddress("trjoshi@Miu.edu");
		per.setUsername("tirth");
		per.setPassword("$2a$10$RK3We6QN.noAhbcysAUVbOXlbhTxgwOVAB43csYxB9E2HPJCuUQs.");
		List<RoleType> roles = new ArrayList();
		roles.add(RoleType.Admin);
		roles.add(RoleType.Customer);
		roles.add(RoleType.Counselor);
		per.setRoles(roles);

		Person per1 = new Person();
		per1.setFirstName("saurav");
		per1.setLastName("majumdar");
		per1.setEmailAddress("smajumdar@miu.edu");
		per1.setUsername("saurav");
		per1.setPassword("$2a$10$RK3We6QN.noAhbcysAUVbOXlbhTxgwOVAB43csYxB9E2HPJCuUQs.");
		List<RoleType> roles1 = new ArrayList();
		roles1.add(RoleType.Customer);
		per1.setRoles(roles1);

		Person per2 = new Person();
		per2.setFirstName("yonas");
		per2.setLastName("yiheyis");
		per2.setEmailAddress("yyamdeberhan@miu.edu");
		per2.setUsername("yonas");
		per2.setPassword("$2a$10$RK3We6QN.noAhbcysAUVbOXlbhTxgwOVAB43csYxB9E2HPJCuUQs.");
		List<RoleType> roles2 = new ArrayList();
		roles2.add(RoleType.Admin);
		per2.setRoles(roles2);

		TMSession ses = new TMSession();
		ses.setAddress(new Address("abc", "abc", "abc", 1));
		ses.setSessionDate(LocalDate.now());
		ses.setStartTime(LocalTime.now());
		ses.setDuration(30);
		ses.setCounselor(per);

		List<TMSession> tmSessions = new ArrayList();
		tmSessions.add(ses);
		per.setTmSessions(tmSessions);

		Appointment appoint = new Appointment();
		appoint.setPerson(per);
		appoint.setTmSession(ses);

		ses.setAppointment(appoint);

		List<AppointmentRequest> apps = new ArrayList();
		AppointmentRequest appReqs = new AppointmentRequest();
		appReqs.setPerson(per);
		appReqs.setTmSession(ses);

		apps.add(appReqs);

		ses.setAppointmentRequest(apps);

		perosn.save(per);
		perosn.save(per1);
		perosn.save(per2);
//		tmsess.save(ses);

	}
}
