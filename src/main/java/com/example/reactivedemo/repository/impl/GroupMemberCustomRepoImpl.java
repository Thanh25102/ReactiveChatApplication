package com.example.reactivedemo.repository.impl;

import com.example.reactivedemo.domain.GroupMember;
import com.example.reactivedemo.domain.GroupMemberKey;
import com.example.reactivedemo.repository.GroupMemberCustom;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class GroupMemberCustomRepoImpl implements GroupMemberCustom {
    private final R2dbcEntityTemplate template;

    public GroupMemberCustomRepoImpl(R2dbcEntityTemplate template) {
        this.template = template;
    }
    @Override
    public Mono<GroupMember> findById(GroupMemberKey key) {
        return template.select(GroupMember.class)
                .from("group_member")
                .matching(query(
                        where("conversation_id").is(key.getConversationId())
                                .and("user_id").is(key.getUserId()))
                ).one();
    }
}
