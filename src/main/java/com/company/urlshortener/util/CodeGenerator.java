package com.company.urlshortener.util;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
public class CodeGenerator {
    private RandomStringGenerator randomStringGenerator;

    public CodeGenerator() {
        this.randomStringGenerator = new RandomStringGenerator
                .Builder().filteredBy(CodeGenerator::isLatinLetterOrDigit)
                .build();
    }

    public String generate(int length) {
        return randomStringGenerator.generate(length);
    }

    private static boolean isLatinLetterOrDigit(int codePoint) {
        return ('a' <= codePoint && codePoint <= 'z')
                || ('A' <= codePoint && codePoint <= 'Z')
                || ('0' <= codePoint && codePoint <= '9')
                || ('+' == codePoint)
                || ('_' == codePoint)
                || ('-' == codePoint);
    }
}

