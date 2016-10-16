package algorithms.mail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;

public class MailController extends MailConstants {

	public static void main(String as[]) throws IOException {

		MailController controller = new MailController();
		List<String> recruiters_emails = FileUtils.readLines(new File(controller.recruiter_email_file_location));
		for (String email : recruiters_emails) {
			Session session = controller.getSession();
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(controller.from_email));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject(controller.subject);
				message.setText(controller.body);

				Transport.send(message);

				System.out.println("Mail sent to "+email);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
	}

	Session getSession() {
		return Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});
	}
}
