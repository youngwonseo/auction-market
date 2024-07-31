package io.youngwon.app.api;

import io.youngwon.app.AuctionMarketApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AuctionMarketApplication.class)
@Transactional
@ActiveProfiles("test")
public class SpringTestSupport {
}
