package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> findAll(HttpServletRequest request) {
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectByPageNumSize();
        PageInfo<User> pageInfoDemo = new PageInfo<User>(userList);
        return  pageInfoDemo.getList();
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable long userId) {
        return null;
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
    }

    @PutMapping("/user/{userId}")
    public void updateUser(@RequestBody User user,@PathVariable int userId) {
    }

    @DeleteMapping("/user/{userId}")
    public void deleteById(@PathVariable long userId) {
    }
}
