package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.UserLogin;
import za.ac.cput.Factory.UserLoginFac;
import za.ac.cput.Service.impl.UserLoginService;

import java.util.Set;

@RestController
@RequestMapping
public class userloginController {
    @Autowired
    private UserLoginService userLoginService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public UserLogin create(@RequestBody UserLogin userLogin) {
        UserLogin newUserLogin = UserLoginFac.createLogin(userLogin.getUserId(),"123456");
        return UserLoginService.getService().create(newUserLogin);
    }

    @GetMapping("/read")
    public UserLogin read(@RequestBody UserLogin userLogin) {
        return UserLoginService.getService().read(userLogin.getUserId());
    }

    @PostMapping("/update")
    public UserLogin update(@RequestBody UserLogin userLogin){
        return UserLoginService.getService().update(userLogin);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody UserLogin userLogin){
        if (UserLoginService.getService().delete(userLogin.getUserId()))
            return "Successfully Deleted";
        else
            return "Could not delete user login";
    }

    @GetMapping("/getall")
    public Set<UserLogin> getAll(){
        return UserLoginService.getService().getAll();
    }
}
