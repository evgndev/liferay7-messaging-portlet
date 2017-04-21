create table dmsg_Dialog (
	dialogId bigint not null primary key,
	topic VARCHAR(500) null,
	creatorMemberId bigint,
	lastMessageDate timestamp without time zone null,
	lastMessageId bigint,
	createDate timestamp without time zone null,
	creatorUserId bigint
);

create table dmsg_DialogMember (
	dialogMemberId bigint not null primary key,
	dialogId bigint,
	memberId bigint,
	memberType VARCHAR(75) null,
	name TEXT null
);

create table dmsg_DialogMessage (
	messageId bigint not null primary key,
	dialogId bigint,
	text_ TEXT null,
	dialogMemberId bigint,
	userId bigint,
	createDate timestamp without time zone null
);
create unique index IX_23BAF8B2 on dmsg_DialogMember (dialogId, memberId, memberType);
create index IX_439845BB on dmsg_DialogMember (memberId, memberType);
create index IX_AED01CDA on dmsg_DialogMessage (dialogId);