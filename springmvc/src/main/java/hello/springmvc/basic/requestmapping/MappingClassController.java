package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")     // /mapping은 다른 강의의 예제들과 구분하기 위해 사용했다.
public class MappingClassController {

    /**
     * 회원 관리 API
     * 회원 목록 조회: GET     /users
     * 회원 등록:      POST    /users
     * 회원 조회:      GET     /users/{userId}
     * 회원 수정:      PATCH   /users/{userId}
     * 회원 삭제:      DELETE  /users/{userId}
     */

    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId=" + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId=" + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete userId=" + userId;
    }
}
