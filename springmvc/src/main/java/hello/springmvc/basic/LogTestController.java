package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());  = @Slf4j 를 넣으면 롬복이 자동으로 이것을 해준다.

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

//        log.info("trace my log="+ name);  => 이렇게 사용하면 자바에서는 + 연산이 먼저 일어나서 메모리도 사용하고 cpu도 사용한다. 그래서 쓸모없는 리소스를 사용하게 되는 것.

        log.trace("trace log={}", name); // ↑ 위와 다르게 연산이 아니라 파라미터만 넘기면 아무 연산이 일어나지 않는다.

        log.debug("debug log={}", name); //개발서버에서 디버그할 때 보는 로그
        log.info(" info log={}", name);  // 중요한 정보
        log.warn(" warn log={}", name);  // 경고, 위험
        log.error("error log={}", name); // 에러 로그

        return "ok";
    }

}
