package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";    //@Controller 면서 String을 반환하면 return 이 뷰의 논리이름이 된다. 그래서 뷰 리졸버가 실행되어서 뷰를 찾고, 렌더링한다.
    }

    //아래의 방식은 딱 맞게 떨어지는 경우가 많이 없어서, 사용을 권장하지 않는다.
    @RequestMapping("/response/hello")  //컨트롤러의 경로와 반환하는 뷰의 논리 이름이 같으면 반환이 없어도(void), 스프링이 앞에 /를 떼주고 response/hello 를 논리 이름으로 진행시킨다.
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }
}
