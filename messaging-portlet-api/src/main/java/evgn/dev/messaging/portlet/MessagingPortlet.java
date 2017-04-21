package evgn.dev.messaging.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import evgn.dev.messaging.model.DialogMessage;
import evgn.dev.messaging.service.DialogMessageLocalServiceUtil;
import evgn.dev.messaging.util.RedirectUtil;
import evgn.dev.messaging.util.UserCustomUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 19.04.17.
 */

@Component(
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.display-category=category.evgndev",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=Messaging",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "javax.portlet.init-param.template-path=/jsp/",
                "javax.portlet.init-param.view-template=/jsp/messaging/dialogList.jsp",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class MessagingPortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(MessagingPortlet.class.getName());

    public static final String JSP_LIST = "/jsp/messaging/dialogList.jsp";
    public static final String JSP_MESSAGE = "/jsp/messaging/message.jsp";
    public static final String JSP_DIALOG = "/jsp/messaging/dialog.jsp";

    public static final String DIALOG_ID = "dialogId";
    public static final String RECEIVER = "receiver";
    public static final String TOPIC = "dialogTopic";
    public static final String TEXT = "msgText";

    public void createMessage(ActionRequest request, ActionResponse response) {
        List<String> errors = new ArrayList<>();
        long dialogId = ParamUtil.getLong(request, MessagingPortlet.DIALOG_ID);
        try {
            User user = UserCustomUtil.getUserFromContext();
            String topic = ParamUtil.getString(request, TOPIC);
            String messageText = ParamUtil.getString(request, TEXT);
            long receiverId = ParamUtil.getLong(request, RECEIVER);

            DialogMessage message = DialogMessageLocalServiceUtil.createMessage(
                    user, dialogId, topic, messageText, receiverId, "user", errors);

            dialogId = message.getDialogId();

            response.setRenderParameter(DIALOG_ID, String.valueOf(dialogId));
            response.setRenderParameter(RedirectUtil.PAGE, JSP_DIALOG);

        } catch (Exception e) {
            errors.add("messaging.error.messageCreation");
            LOG.error("Cannot send message", e);
        }

        RedirectUtil.backWithError(request, response, errors, JSP_MESSAGE);
    }
}
