package iuh.servlet;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.mail.util.ByteArrayDataSource;
import jakarta.activation.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

//Annotation để hỗ trợ multipart/form-data
@MultipartConfig 
public class SendEmailWithAttachment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Lấy các thông tin từ form gửi mail
		String recipient = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");

		// Kiểm tra nếu các giá trị tham số bị null hoặc trống
		if (recipient == null || recipient.isEmpty()) {
			response.getWriter().println("Error: Recipient email is required.");
			return;
		}
		if (subject == null || subject.isEmpty()) {
			response.getWriter().println("Error: Email subject is required.");
			return;
		}
		if (body == null || body.isEmpty()) {
			response.getWriter().println("Error: Email body is required.");
			return;
		}

		// Xử lý file đính kèm
		Part filePart = request.getPart("attachmentPath");
		String attachmentFileName = null;
		byte[] fileContent = null;

		if (filePart != null && filePart.getSize() > 0) {
			attachmentFileName = filePart.getSubmittedFileName();
			InputStream fileInputStream = filePart.getInputStream();

			// Đọc nội dung tệp vào một mảng byte
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = fileInputStream.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
			fileContent = buffer.toByteArray();
		}

		// Thông tin tài khoản email người gửi
		String senderEmail = "cuem8h@gmail.com";
		String password = "apba qjfg xekc cfqm";
//        String senderEmail = "your-email@gmail.com";
//        String password = "your-app-password";  

		// Cấu hình các thuộc tính cho phiên gửi mail
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// Tạo phiên gửi mail
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, password);
			}
		});

		try {
			// Tạo đối tượng MimeMessage
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject(subject);

			// Tạo đối tượng BodyPart của email
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);

			// Email sẽ có 2 phần: nội dung và file đính kèm
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Xử lý file đính kèm nếu có
			if (fileContent != null && fileContent.length > 0) {
				MimeBodyPart attachPart = new MimeBodyPart();
				ByteArrayDataSource dataSource = new ByteArrayDataSource(fileContent, filePart.getContentType());
				attachPart.setDataHandler(new DataHandler(dataSource));
				attachPart.setFileName(attachmentFileName);
				multipart.addBodyPart(attachPart);
			}

			// Thiết lập nội dung email
			message.setContent(multipart);

			// Gửi email
			Transport.send(message);
			response.getWriter().println("Email đã được gửi thành công đến: " + recipient);
		} catch (MessagingException e) {
			e.printStackTrace();
			response.getWriter().println("Gửi email thất bại: " + e.getMessage());
		}
	}
}
