create unique index IX_23BAF8B2 on dmsg_DialogMember (dialogId, memberId, memberType[$COLUMN_LENGTH:75$]);
create index IX_439845BB on dmsg_DialogMember (memberId, memberType[$COLUMN_LENGTH:75$]);

create index IX_AED01CDA on dmsg_DialogMessage (dialogId);