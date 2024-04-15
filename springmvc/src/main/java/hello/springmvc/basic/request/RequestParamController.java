package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody   // 원래는 @Controller 이면서 반환이 String이면 view의 논리이름을 반환하는데, 바로 Http 응답 바디에 넣고 싶으면, @ResponseBody를 적어주면 return 값을 바로 응답으로 박아준다. @RestController 랑 같은 효과이다.
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,    //변수명은 자유롭게 만들어도 된다.
            @RequestParam("age") int memberAge) {        //request.getParameter("age")와 같은 효과

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,    //요청 파라미터 이름과 변수명을 일치시키면, @RequestParam("username") 에서 ()안 요청 파라미터값을 생략할 수 있다.
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {    //String, int, Integer등의 단순 타입이면, @RequestParam을 생략할 수 있다. 대신에 요청 파라미터 값과 변수명이 동일해야 가능하다.
                                                                //반대로 생각해보았을 때 단순 타입이면, 자동으로 @RequestParam이 적용되어 있는 것.  그래도 생략하기보다 애노테이션을 쓰는 것을 권장(팀이 합의가 되었다면 생략해도 무방)
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, //회원이 username이 없으면, 기본값으로 이름을 guest라고 하겠다. 라는 의미.
            @RequestParam(required = false, defaultValue = "-1") int age) {         //이런 경우네는 age가 없으면, 기본값으로 -1이 들어가기 때문에 Integer를 쓰지 않고 int로 쓰는 것이 가능하다.
        log.info("username={}, age={}", username, age);                             //defaultValue 가 들어가게 되면, 기본으로 값이 들어가기 때문에 required를 쓰지 않아도 된다.
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {             //모든 요청 파라미터를 다 받고 싶으면, Map으로해서 요청 파라미터를 다 꺼낼 수 있다.
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));     //파라미터의 값이 1개가 확실하다면 'Map"을 사용해도 되지만, 그렇지 않다면 'MultiValueMap'을 사용하자. (그러나 보통은 파라미터 값을 1개만 쓰지, 여러개를 쓰는 경우는 잘 없다.)
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {   //HelloData 객체가 생성되고, 요청 파라미터의 값도 모두 들어가 있다. (강의pdf 참고)
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {   //@ModelAttribute 을 생략하는 것도 가능하다.
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
