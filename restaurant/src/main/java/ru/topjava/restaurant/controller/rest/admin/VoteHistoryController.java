package ru.topjava.restaurant.controller.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.restaurant.model.VoteHistory;
import ru.topjava.restaurant.repository.VoteHistoryRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/rest/api/v1")
public class VoteHistoryController {

    @Autowired
    private VoteHistoryRepository voteHistoryRepository;

    @GetMapping("/voteHistory")
    public List<VoteHistory> voteHistoryList() {
        return voteHistoryRepository.findAll();
    }
}
