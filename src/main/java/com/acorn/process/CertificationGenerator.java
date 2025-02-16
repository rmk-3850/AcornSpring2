package com.acorn.process;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class CertificationGenerator {

	// 영문 알파벳
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String createCertificationPassword() throws NoSuchAlgorithmException {
        StringBuilder result = new StringBuilder();

        // 영어 알파벳과 숫자를 조합하여 난수 생성
        do {
            // 10자리의 난수 생성
            for (int i = 0; i < 10; i++) {
                // SecureRandom을 이용하여 0부터 35 사이의 난수 생성
                int randomIndex = SecureRandom.getInstanceStrong().nextInt(ALPHABET.length() + 10);

                // 숫자인 경우
                if (randomIndex < 10) {
                    result.append(randomIndex);
                }
                // 알파벳인 경우
                else {
                    // ALPHABET 문자열에서 랜덤한 영문 알파벳 선택하여 결과 추가
                    result.append(ALPHABET.charAt(randomIndex - 10));
                }
            }
        } while (result.length() != 10);

        return result.toString();
    }
}
