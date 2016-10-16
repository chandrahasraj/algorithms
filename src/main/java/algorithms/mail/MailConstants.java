package algorithms.mail;

import java.util.Properties;

public class MailConstants {

	Properties props = new Properties();
	protected final String recruiter_email_file_location = "C:\\Users\\chand\\Desktop\\Recruiters_emails_2.txt";
	protected final String username = "chandrahasjava21";
	protected final String password = "kurosakinaruto";
	protected final String from_email = "chandrahasjava21@gmail.com";
	protected final String subject = "Looking for New Grad Software Positions: 2+ years of experience at startups";
	protected final String body = "Hi,"
			+ "\nI'm doing my Masters in Computer Science at University of South Carolina, Columbia. I'm looking for full time software developer opportunities."
			+ "\nI recently worked as software developer at university of south carolina and previously worked as software engineer at Peel India(startup)."
			+ "\nI have a background that suits positions related to  " + "\n1)Full stack development  "
			+ "\n2)Big Data application development - using Apache Storm, Kafka, Amazon Kinesis  "
			+ "\n3)Backend developer - Java & Python   "
			+ "\n\nCan you kindly review my profile and let me know if you find me suitable for any positions."
			+ "\nPlease find the attached resume."
			+ "\n https://drive.google.com/file/d/0B_BW4gLgGMS-ZkZCM2k2ZVk0RVU/view   "
			+ "\n\nP.S. If your team doesn't have any suitable positions for me, can you kindly forward my resume to other teams who might find me a good fit?";

	MailConstants() {
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
	}
}
