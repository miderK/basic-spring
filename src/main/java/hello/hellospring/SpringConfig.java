package hello.hellospring;

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
