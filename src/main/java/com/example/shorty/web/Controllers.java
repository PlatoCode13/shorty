package com.example.shorty.web;

import com.example.shorty.core.UrlService;
import com.example.shorty.dto.UrlRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/api/urls")
class UrlApi {
  private final UrlService svc;
  UrlApi(UrlService svc) { this.svc = svc; }

  @PostMapping
  public Map<String,String> create(@RequestBody UrlRequest req) {
    var code = svc.shorten(req.url());
    return Map.of("code", code);
  }

  @GetMapping("/health")
  public Map<String,String> health() { return Map.of("status","ok"); }
}

@Controller
class RedirectController {
  private final UrlService svc;
  RedirectController(UrlService svc) { this.svc = svc; }

  @GetMapping("/r/{code}")
  public ResponseEntity<Void> go(@PathVariable String code) {
    var target = svc.resolve(code);
    return ResponseEntity.status(302).location(URI.create(target)).build();
  }
}
