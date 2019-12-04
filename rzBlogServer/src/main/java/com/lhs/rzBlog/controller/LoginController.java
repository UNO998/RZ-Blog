package com.lhs.rzBlog.controller;

import com.lhs.rzBlog.common.JsonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:  Haotao Lai (Eric)
 * Date:    2019-12-03
 * E-mail:  haotao.lai@gmail.com
 * Website: http://laihaotao.me
 */

@RestController
public class LoginController {

    @RequestMapping("/login_page")
    public JsonResponse loginPage() {
        // request this page means the user is asked to login
        // status code 401: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/401
        return new JsonResponse().code(401).message("please login");
    }

}
