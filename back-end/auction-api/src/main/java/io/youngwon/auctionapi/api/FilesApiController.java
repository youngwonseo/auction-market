package io.youngwon.auctionapi.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/file")
public class FilesApiController {

    @GetMapping(value = "{filename}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] downloadFile(
            @PathVariable String filename,
            HttpServletRequest request,
            HttpServletResponse response) {

        try {
            return java.nio.file.Files.readAllBytes(Paths.get("uploads", filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
