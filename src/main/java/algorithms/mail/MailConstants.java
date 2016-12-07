package algorithms.mail;

import java.util.Properties;

public class MailConstants {

	Properties props = new Properties();
	protected final String recruiter_email_file_location = "/Users/chandra/Documents/Recruiter_emails_2.txt";
	protected final String username = "chandrahasjava21";
	protected final String password = "kurosakinaruto";
	protected final String from_email = "chandrahasjava21@gmail.com";
	protected final String attachment = "/Users/chandra/Documents/Resume_v2.2.pdf";
	protected final String subject = "Looking for Full Time Software Positions: 2+ years of experience at startups";
	protected final String body = "Hi,"
			+ "\nI am a graduate in Computer Science at University of South Carolina, Columbia. I'm looking for full time software developer/testing/operations opportunities. "
+ "I recently worked as software developer at university of south carolina and previously worked as software engineer at Peel Technologies."
+ "\n\nI have a background that suits positions related to"
+ "\n1)Full stack development"
+ "\n2)Big Data application development - Apache Storm, AWS services, Apache Kafka"
+ "\n3)Backend - Java & Python"
+ "\n4)Web Development - Rest services using Jersey, Play, AngularJS, Flask"
+ "\n5)Database - MySql, PostgreSql, MongoDB, Redshift, Cassandra"
+ "\n\nCan you kindly review my profile and let me know if you find me suitable for any positions."
+ "\nPlease find the attached resume."
			+ "\n https://drive.google.com/file/d/0B_BW4gLgGMS-RjR4cTBuM0JoQ1U/view   "
			+ "\n\nP.S. If your team doesn't have any suitable positions for me, can you kindly forward my resume to other teams who might find me a good fit. "
			+ "\n\n\n-- "
			+ "\nRegards,"
			+ "\nChandrahas Raj G Venkat"
			+ "\nMS Computer Science - Class of 2016​"
			+ "\nUniversity of South Carolina, Columbia"
			+ "\nm | (803)-445-4191"
			+ "\nSkype | chandrahasraj@outlook.com"
			+ "\nLinkedin | https://www.linkedin.com/in/chandrahas-raj-40a70321";

	MailConstants() {
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
	}
}
