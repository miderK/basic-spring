package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // TimeTraceAop를 빈으로 등록해서 사용할수도 있고, 해당 클래스에 컴포넌트스캔방식으로도 사용이 가능하다.
/*    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/

/*    @Bean
    public MemberRepository memberRepository() {
        // 메모리에 저장하는 테스트용
        //return new MemoryMemberRepository();

        // 순수JDBC로 설정
//        return new JdbcMemberRepository(dataSource);

        // JdbcTemplate
//        return new JdbcTempleteMemberRepository(dataSource);
        // JPA
        return new JpaMemberRepository(em);

    }*/

}
