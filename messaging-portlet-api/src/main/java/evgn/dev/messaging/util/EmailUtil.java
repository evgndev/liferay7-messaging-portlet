package evgn.dev.messaging.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;

import javax.mail.internet.InternetAddress;
import java.util.Map;

/**
 * Created by Eugene on 18.02.2017.
 */
public class EmailUtil {
    private static final Log LOG = LogFactoryUtil.getLog(EmailUtil.class.getName());
    public static final String BREAK = "<br>";

    /**
     * Send email with header and footer. Like:
     * firstName lastName, <br> [mainText] <br><br> sincerely yours, russianeasy.org
     *
     */
    public static void sendEmailToUserWithHeaderAndFooter(String subject,
                                                          String mainText,
                                                          User receiverUser) throws Exception {

            String fullText =
                    getHeader(receiverUser)
                            + BREAK + mainText
                            + BREAK + BREAK + getFooter(receiverUser);

            sendEmail(subject, fullText, getSenderMail(), getSenderName(), receiverUser.getEmailAddress());
    }

    public static void sendEmailToUser(String subject,
                                       String fullText,
                                       User receiverUser) throws Exception {

        sendEmail(subject, fullText, getSenderMail(), getSenderName(), receiverUser.getEmailAddress());
    }

    public static void sendEmail(String subject,
                                 String text,
                                 String receiverEmail) throws Exception {

        sendEmail(subject, text, getSenderMail(), getSenderName(), receiverEmail);
    }

    private static void sendEmail(String subject,
                                  String text,
                                  String senderEmail,
                                  String senderName,
                                  String receiverEmail) throws Exception {

        try {
            MailMessage mailMessage = new MailMessage();

            mailMessage.setSubject(subject);
            mailMessage.setBody(text);
            mailMessage.setHTMLFormat(true);
            mailMessage.setFrom(new InternetAddress(senderEmail, senderName));
            mailMessage.setTo(new InternetAddress(receiverEmail));

            MailServiceUtil.sendEmail(mailMessage);
        } catch (Exception e) {
            throw new Exception("Email sending error", e);
        }
    }

    private static String getHeader(User user) {
        return String.format("%s %s,", user.getFirstName(), user.getLastName());
    }

    private static String getFooter(User user) {
        String localizedTemplate = ResourcesUtil.getString(user.getLocale(), "mail.footer");

        return String.format(localizedTemplate,
                getSenderName(), getSenderMail(), getPortalAddress());
    }

    private static String getSenderMail() {
        return "no-reply@russiaeasy.org";
    }

    private static String getSenderName() {
        return "RussiaEasy";
    }

    public static String getPortalAddress() { // TODO replace, parametrize
        return "https://russiaeasy.org/";
    }

    public static String pasteDataToTemplate(String template, Map<String, String> data) {
        String message = template;
        try {
            for (String placeholder : data.keySet()) {
                String value = data.get(placeholder);
                message = replacePlaceholder(message, placeholder, value);
            }
        } catch (Exception e) {
            LOG.error("Cannot paste data to template", e);
        }
        return message;
    }

    private static String replacePlaceholder(String message, String placeholder, String value) {
        if (message.contains(placeholder)) {
            message = message.replace(placeholder, value);
        }
        if (message.contains(placeholder)) {
            replacePlaceholder(value, message, placeholder);
        }
        return message;
    }
}
