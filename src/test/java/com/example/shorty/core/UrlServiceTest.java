package com.example.shorty.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UrlServiceTest {
  @Test void shortenAndResolve() {
    var svc = new UrlService();
    var code = svc.shorten("https://example.com");
    assertEquals("https://example.com", svc.resolve(code));
  }

  @Test void rejectsNonHttp() {
    var svc = new UrlService();
    assertThrows(IllegalArgumentException.class, () -> svc.shorten("ftp://bad"));
  }
}
