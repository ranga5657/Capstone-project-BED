
package org.role.based.auth.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.role.based.auth.jwt.entity")
@EnableJpaRepositories
@EnableJpaAuditing
//@EnableEurekaClient
//@EnableDiscoveryClient
public class SuperMoviesSuperReviewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperMoviesSuperReviewsApplication.class, args);
    }

}
