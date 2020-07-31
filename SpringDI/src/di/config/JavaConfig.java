package di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di.dao.MemberDao;
import di.service.ChangePasswordService;
import di.service.MemberRegisterService;

@Configuration
public class JavaConfig {

		@Bean("dao")
		public MemberDao memberDao() {
			
			return new MemberDao();
			
		}
		
		
		@Bean("memberRegSvc")
		public MemberRegisterService memberRegSvc() {
			
			
			return new MemberRegisterService(memberDao());
		}
		
		
		@Bean("changePwSvc")
		public ChangePasswordService changePwSvC() {
			
			return new ChangePasswordService(memberDao());
		}
		
		
		
		
		
		
		
		
		
}
