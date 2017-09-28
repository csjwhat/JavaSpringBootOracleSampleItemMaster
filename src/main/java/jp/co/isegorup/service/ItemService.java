package jp.co.isegorup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isegorup.domain.ItemEntity;
import jp.co.isegorup.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;

	public List<ItemEntity> findAll() {
		return itemRepository.findAll();
	}

	public ItemEntity findOne(Integer itemId) {
		return itemRepository.findOne(itemId);
	}

	public ItemEntity create(ItemEntity itemEntity) {
		return itemRepository.save(itemEntity);
	}

	public ItemEntity update(ItemEntity itemEntity) {
		return itemRepository.save(itemEntity);
	}

	public void delete(Integer itemId) {
		itemRepository.delete(itemId);
	}

}
