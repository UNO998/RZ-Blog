package com.lhs.rzBlog.bean;

import lombok.Data;

/**
 * Author:  Haotao Lai (Eric)
 * Date:    2019-12-05
 * E-mail:  haotao.lai@gmail.com
 * Website: http://laihaotao.me
 */

@Data
public class Role {
    private Long id;
    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
