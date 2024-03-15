package com.fiap.hospitalidade.services;

import org.springframework.stereotype.Service;

import com.fiap.hospitalidade.modelos.Item;
import com.fiap.hospitalidade.repositories.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item findById(String id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void delete(String id) {
        itemRepository.deleteById(id);
    }

    public Item update(String id, Item item) {
        Item itemToUpdate = itemRepository.findById(id).orElse(null);
        if (itemToUpdate == null) {
            return null;
        }
        itemToUpdate.setNome(item.getNome());
        itemToUpdate.setValor(item.getValor());
        return itemRepository.save(itemToUpdate);
    }

}
