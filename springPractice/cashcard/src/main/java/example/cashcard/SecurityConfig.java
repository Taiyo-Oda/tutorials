package example.cashcard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
 * @Configuration
 * SpringとSpring Boot自体を構成するためにこのクラスを使用するようにSpringに指示します
 */
@Configuration
public class SecurityConfig {

  /*
   * @Bean
   * Spring SecurityはBeanがFilterChainを構成することを期待します。
   * SecurityFilterChainを返すメソッドこのアノテーションをつけると、この期待に応えられます。
   * ここでは認証に関する様々な設定を行うことができます。
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .requestMatchers("/cashcards/**")
        .hasRole("CARD-OWNER")
        .and()
        .csrf().disable()
        .httpBasic();
    return http.build();
  }

  /*
   * テスト専用のサービス、InMemoryUserDetailsManagerを構成する
   * H2を使ったインメモリデータベースを構成したのと同じように、SpringSecurityのテストでもテストユーザーを使ったインメモリサービスを構成します。
   * テスト専用のUserDetailServiceを構成します。
   * SpringのIoCコンテナはUserDetailsService Beanを見つけ、Spring Dataは必要なときにそれを使用します。
   */
  @Bean
  public UserDetailsService testOnlyUsers(PasswordEncoder passwordEncoder) {
    User.UserBuilder users = User.builder();
    UserDetails sarah = users
        .username("sarah1")
        .password(passwordEncoder.encode("abc123"))
        .roles("CARD-OWNER") // new role
        .build();
    UserDetails hankOwnsNoCards = users
        .username("hank-owns-no-cards")
        .password(passwordEncoder.encode("qrs456"))
        .roles("NON-OWNER") // new role
        .build();
    return new InMemoryUserDetailsManager(sarah, hankOwnsNoCards);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}