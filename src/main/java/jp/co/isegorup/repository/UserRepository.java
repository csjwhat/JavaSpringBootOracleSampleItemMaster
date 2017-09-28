package jp.co.isegorup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.isegorup.domain.UserEntity;

public interface UserRepository  extends JpaRepository<UserEntity, String> {

}
