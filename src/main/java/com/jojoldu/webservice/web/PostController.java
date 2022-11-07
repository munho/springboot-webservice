package com.jojoldu.webservice.web;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @PostMapping("/group")
    public GroupDto post(@RequestBody GroupDto groupDto) {
        return groupDto;
    }

    @Data
    @NoArgsConstructor
    private class GroupDto {
        private String groupName;
        private List<String> members;
        private DateObj date;

        @Data
        @NoArgsConstructor
        private class DateObj {
            private int year;
            private int month;
            private int day;
        }
    }
}
