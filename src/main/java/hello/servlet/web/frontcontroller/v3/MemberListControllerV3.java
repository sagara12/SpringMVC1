package hello.servlet.web.frontcontroller.v3;

import hello.servlet.domain.member.MemberRepository;
import hello.servlet.domain.member.Memeber;
import hello.servlet.web.frontcontroller.ModelView;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3{

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paraMap) {
        List<Memeber> memebers = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("memebers", memebers);

        return mv;
    }
}
