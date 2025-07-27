package bastolaaayush.com.np.billing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class ViewController {

    @GetMapping("/home")
    public String showMainPage(){
        return "home";
    }
    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }
    @GetMapping("/calculateBill")
    public String calculateBillPage(){
        return "calculateBill";
    }

    @GetMapping("/bills")
    public String bills(){
        return "bills";
    }


}
