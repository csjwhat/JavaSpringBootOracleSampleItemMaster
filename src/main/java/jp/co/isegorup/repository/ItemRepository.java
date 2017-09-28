package jp.co.isegorup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.isegorup.domain.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}
