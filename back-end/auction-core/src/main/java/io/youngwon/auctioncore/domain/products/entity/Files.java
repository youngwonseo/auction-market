package io.youngwon.auctioncore.domain.products.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
@Entity
public class Files {

    private static final String BASE64_HEADER_EXP = "^data:[^/]+/([^;]+);base64,";
    private static final Pattern PATTERN_BASE64_HEADER = Pattern.compile(BASE64_HEADER_EXP);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    private String filename;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;

//    public Files(Product products, ProductRegisterRequest.Images image) {
//
//        // 파일 업로드
//        this.path = "uploads";
//        this.filename = UUID.randomUUID().toString();
//        this.products = products;
//
//
//        byte[] bytes = Base64
//                .getDecoder()
//                .decode(image.getDataURL().substring(image.getDataURL().indexOf(",") + 1));
//        try {
//
////            Matcher base64HeaderMatcher = PATTERN_BASE64_HEADER.matcher(image.getDataURL());
////
////            String extension = base64HeaderMatcher.group(1);
//
//            java.nio.file.Files.write(Paths.get(path, filename), bytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
