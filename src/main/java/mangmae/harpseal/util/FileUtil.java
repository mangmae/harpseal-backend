package mangmae.harpseal.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class FileUtil {

    @Value("${file.thumbnail-image.path}")
    private String quizThumbnailImagePath;

    @Value("${file.thumbnail-image.default-path}")
    private String quizThumbnailDefaultImagePath;

    @Value("${file.question-image.path}")
    private String questionImagePath;

    @Value("${file.question-sound.path}")
    private String questionSoundPath;

    private FileUtil(){
    }

    public static FileUtil of() {
        return new FileUtil();
    }

    // TODO: 2023/12/11 이미지 타입 호환 고려, MultiPartFile 로부터 확장자 정보를 가져와야하나?
    public String makeThumbnailImagePath() {
        StringBuilder imageNameBuilder = new StringBuilder(quizThumbnailImagePath);
        return imageNameBuilder
            .append(UUID.randomUUID().toString().substring(0, 10))
            .append(".png")
            .toString();
    }

    public String makeQuestionImagePath() {
        StringBuilder imageNameBuilder = new StringBuilder(questionImagePath);
        return imageNameBuilder
            .append(UUID.randomUUID().toString().substring(0, 10))
            .append(".png")
            .toString();
    }

    public String makeQuestionSoundPath() {
        StringBuilder soundNameBuilder = new StringBuilder(questionSoundPath);
        return soundNameBuilder
            .append(UUID.randomUUID().toString().substring(0, 10))
            .append(".mp3")
            .toString();
    }

    public byte[] loadImageBytes(String filePath) {
        try {
            return FileCopyUtils.copyToByteArray(new File(filePath));
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to make byte data from path=[" + filePath + "]");
        }
    }

    public String loadImageBase64(String filePath) {
        if (filePath == null) {
            filePath = quizThumbnailDefaultImagePath;
        }
        return Base64.getEncoder().encodeToString(loadImageBytes(filePath));
    }


}
