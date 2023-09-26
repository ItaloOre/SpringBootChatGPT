package com.thomasjayconsulting.springbootchatgpt.controller;

import com.thomasjayconsulting.springbootchatgpt.model.SearchRequest;
import com.thomasjayconsulting.springbootchatgpt.service.ChatGPTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ChatGPTRestController {

    private ChatGPTService chatGPTService;

    public ChatGPTRestController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/searchChatGPT")
    public String searchChatGPT(@RequestBody SearchRequest searchRequest) {

        log.info("searchChatGPT Started query: " + searchRequest.getQuery());

        return chatGPTService.processSearch(searchRequest.getQuery());

    }

}
