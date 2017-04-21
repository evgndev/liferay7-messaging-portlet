# liferay7-messaging-portlet

#role permissions:

CREATE_DIALOG - hide message creation on dialog list. 
you can create dialog on message.jsp, like
    http://localhost:8080/web/guest/messages?p_p_id=evgn_dev_messaging_portlet_MessagingPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_evgn_dev_messaging_portlet_MessagingPortlet_jspPage=%2Fjsp%2Fmessaging%2Fmessage.jsp&_evgn_dev_messaging_portlet_MessagingPortlet_availableUserIds=20164

CREATE_MSG - hide message creation in dialog page

#portal-ext.properties:

send email notification about new message, disabled by default
    messaging.notification.email=true
 
if role has no CREATE_DIALOG permissions, message.jsp receivers field will be is empty.
define receivers userIds: messaging.receivers.[roleName]=[userId],[userId]
    messaging.receivers.memberRole=20164,20165