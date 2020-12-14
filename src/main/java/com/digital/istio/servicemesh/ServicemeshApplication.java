package com.digital.istio.servicemesh;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/servicemesh")
@Slf4j
public class ServicemeshApplication {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  public static void main(String[] args) {
    SpringApplication.run(ServicemeshApplication.class, args);
  }

  @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
  public String helloMesh(@PathVariable String name) throws InterruptedException {
    return "Hello "+ name +" !";
  }

  @RequestMapping(value = "/sleep/{duration}",method = RequestMethod.GET)
  public String sleepMesh(@PathVariable int duration) throws InterruptedException {
    log.info("Going to wait");
    TimeUnit.SECONDS.sleep(duration);
    log.info("Done");
    return "Hello Sathish!";
  }

  
  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

}
