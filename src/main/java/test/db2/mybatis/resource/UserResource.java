package test.db2.mybatis.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.db2.mybatis.User;
import test.db2.mybatis.mapper.UserMapper;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    private final UserMapper userMapper;

    public UserResource(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/find")
    public List<User> getLast10() {
        return userMapper.findLast10();
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam String email, @RequestParam String password) {
        User loginUser = new User();
        loginUser.setEmail(email);
        loginUser.setPassword(password);

        User user = userMapper.getByUserNameAndPassword(loginUser);
        if (user != null) {
            return "success";
        }
        return "fail";
    }
}
