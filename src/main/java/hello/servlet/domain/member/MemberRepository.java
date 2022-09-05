package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong을 사용 고려
 */

public class MemberRepository {

    private static Map<Long, Memeber> store = new HashMap<>();
    private static long sequence = 0L;

    //singleton
    private static final MemberRepository instance =  new MemberRepository();


    public static MemberRepository getInstance() {
        return instance;
    }

    //싱글톤으로 구현할때는 아무나 생성 못하도록 private으로 막아야 됨
    private MemberRepository() {

    }

    public Memeber save(Memeber memeber) {
        memeber.setId(++sequence);
        store.put(memeber.getId(), memeber);
        return memeber;
    }

    public Memeber findById(Long id) {
        return store.get(id);

    }

    // 이렇게 하면 store에 있는 값들을 새로운 List에 담아서 넘겨줌 -> 밖에서 조작해도 store에 있는 value List 안 건들음
    public List<Memeber> findAll() {
        return new ArrayList<>(store.values());
    }

    //테스트 코드 용용
   public void clearStore() {
        store.clear();
    }
}
