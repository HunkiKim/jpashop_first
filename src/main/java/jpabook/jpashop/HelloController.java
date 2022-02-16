package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController
{
    @GetMapping("hello")
    public String hello(Model model)
    {//model -> spring ui의 모델
        //model에 데이타를 실어서 뷰에 넘길 수 있다.
        //return은 뷰를 반환
        model.addAttribute("data","hello!!!");
        return "hello";
    }
}
