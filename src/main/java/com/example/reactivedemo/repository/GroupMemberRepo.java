package com.example.reactivedemo.repository;

import com.example.reactivedemo.domain.GroupMember;
import com.example.reactivedemo.domain.GroupMemberKey;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface GroupMemberRepo extends ReactiveCrudRepository<GroupMember, GroupMemberKey> {
}
