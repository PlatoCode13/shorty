package com.example.shorty.core;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.random.RandomGenerator;

@Service
public class UrlService {
  private final Map<String, String> codeToUrl = new ConcurrentHashMap<>();
  private final RandomGenerator rng = RandomGenerator.getDefault();

  public String shorten(String raw) {
    validate(raw);
    String code;
    do { code = randomCode(6); } while (codeToUrl.containsKey(code));
    codeToUrl.put(code, raw);
    return code;
  }

  public String resolve(String code) {
    var url = codeToUrl.get(code);
    if (url == null) throw new IllegalArgumentException("Unknown code");
    return url;
  }

  private void validate(String raw) {
    if (raw == null || raw.length() > 2048) throw new IllegalArgumentException("Invalid URL");
    var uri = URI.create(raw);
    var scheme = uri.getScheme();
    if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
      throw new IllegalArgumentException("Only http/https allowed");
    }
  }

  private String randomCode(int n) {
    final String alpha = "abcdefghijklmnopqrstuvwxyz0123456789";
    var sb = new StringBuilder(n);
    for (int i = 0; i < n; i++) sb.append(alpha.charAt(rng.nextInt(alpha.length())));
    return sb.toString();
  }
}
