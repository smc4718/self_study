package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();   //static 사용
    private static long sequence = 0L; //static 사용

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
 /*       List<Member> all = findAll();
        for (Member m : all) {
            if(m.getLoginId().equals(loginId)) {
                return Optional.of(m);
            }
        }
        return Optional.empty(); */

        //람다 스트림으로 아래와 같이 더 간편하게 바꿀 수 있음 (이렇게 쓰면됨)
        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<Member>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
