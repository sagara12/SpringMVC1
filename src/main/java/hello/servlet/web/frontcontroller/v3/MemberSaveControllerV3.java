package hello.servlet.web.frontcontroller.v3;

import hello.servlet.domain.member.MemberRepository;
import hello.servlet.domain.member.Memeber;
import hello.servlet.web.frontcontroller.ModelView;

import java.lang.reflect.Member;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3{

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paraMap) {

        String username = paraMap.get("username");
        int age = Integer.parseInt(paraMap.get("age"));

        Memeber member = new Memeber(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;

    }
}
