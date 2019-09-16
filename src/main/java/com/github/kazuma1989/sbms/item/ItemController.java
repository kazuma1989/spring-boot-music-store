
package com.github.kazuma1989.sbms.item;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Optional;

import com.github.kazuma1989.sbms.repository.ItemEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService service;

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        Optional<ItemEntity> item = service.findById(id);
        if (item.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND);
        }

        model.addAttribute("item", item.get());
        return "item-detail";
    }
}
