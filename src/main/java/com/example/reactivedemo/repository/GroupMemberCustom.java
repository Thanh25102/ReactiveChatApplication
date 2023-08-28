package com.example.reactivedemo.repository;

import com.example.reactivedemo.domain.GroupMember;
import com.example.reactivedemo.domain.GroupMemberKey;
import reactor.core.publisher.Mono;

public interface GroupMemberCustom {
    Mono<GroupMember> findById(GroupMemberKey key);
}
