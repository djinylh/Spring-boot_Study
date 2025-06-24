package com.green.firstserver.medel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoGetOneRes {
    private String title;
    private String content;
    public String createdAt;
}
