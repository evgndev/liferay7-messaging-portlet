create table dmsg_Dialog (
	dialogId LONG not null primary key,
	topic VARCHAR(75) null,
	creatorMemberId LONG,
	lastMessageDate DATE null,
	lastMessageId LONG,
	disableAnswering BOOLEAN,
	createDate DATE null,
	creatorUserId LONG
);

create table dmsg_DialogMember (
	dialogMemberId LONG not null primary key,
	dialogId LONG,
	memberId LONG,
	memberType VARCHAR(75) null,
	name VARCHAR(75) null
);

create table dmsg_DialogMessage (
	messageId LONG not null primary key,
	dialogId LONG,
	text_ VARCHAR(75) null,
	dialogMemberId LONG,
	userId LONG,
	createDate DATE null
);