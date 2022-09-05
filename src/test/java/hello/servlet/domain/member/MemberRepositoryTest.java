package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    //싱글톤으로 생성 해야 하기 때문에 new로 하면 안됨 (스프링에서는 싱글톤을 따로 구현 안해줘도 됨 스프링 자체에서 싱글톤을 보장)
   MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Memeber member = new Memeber("kkk", 20);


        //when
        Memeber saveMember = memberRepository.save(member);


        //then
        Memeber findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);

    }

    @Test
    void findAll() {
        //given
        Memeber member1 = new Memeber("kkk", 20);
        Memeber member2 = new Memeber("mmm", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Memeber> result = memberRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1, member2);

    }

}