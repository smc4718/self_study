package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부의 private 으로 static으로 하나 가지고 있는데, 이렇게 하면 클래스 레벨에 올라가기 때문에 딱 하나만 존재하게 됩니다.
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
