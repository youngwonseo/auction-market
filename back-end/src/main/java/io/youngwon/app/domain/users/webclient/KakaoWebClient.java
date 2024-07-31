package io.youngwon.app.domain.users.webclient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KakaoWebClient {

    public static class GetAccessToken {
//        ObjectMapper mapper = new ObjectMapper();
//        private WebClient client;
//        private Mono<ClientResponse> result;
//        public GetAccessToken(String code){
//            client = WebClient.create("https://kauth.kakao.com/oauth/token?grant_type=authorization_code&client_id=258d8cc142df2cbae7713125c00410ed&redirect_uri=http://localhost/login/kakao&code=" + code);
//            result = client.post()
//                    .uri("")
//                    .exchange();
//        }
//
//        public String get() {
//            JsonNode node = null;
//            try {
//                node = mapper.readTree(result.flatMap(res -> res.bodyToMono(String.class)).block());
//            }catch(Exception e){ }
//
//            log.info(node.toString());
//            // refresh_token
//            return node.get("access_token").asText();
//        }
    }


    public static class GetUserInfo {
//        ObjectMapper mapper = new ObjectMapper();
//        private WebClient client;
//        private Mono<ClientResponse> result;
//
//        public GetUserInfo(String accessToken) {
//
//            client = WebClient.builder()
//                    .baseUrl("https://kapi.kakao.com/v2/user/me")
//                    .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
//                    .build();
//
//            result = client.get()
//                    .uri("")
//                    .exchange();
//        }
//
//        public User get() {
//            JsonNode node = null;
//            try {
//                node = mapper.readTree(result.flatMap(res -> res.bodyToMono(String.class)).block());
//            } catch (Exception e) {
//            }
//
//            // kakao 고유 식별자
//            String id = node.get("id").toString();
//            //이름
//            String name = node.get("properties").get("nickname").asText();
//            String email = node.get("kakao_account").get("email").asText();
//
//            log.info(id + "," + name + "," + email);
//
//
//            return User.builder().name(name).email(email).role(Role.USER).vender("kakao").socialId(id).build();
//        }
    }
}
