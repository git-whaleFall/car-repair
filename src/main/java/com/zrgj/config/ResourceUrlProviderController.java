package com.zrgj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@ControllerAdvice
/*静态资源映射*/
public class ResourceUrlProviderController {
  @Autowired

  private ResourceUrlProvider resourceUrlProvider;

  @ModelAttribute("urls")

  public ResourceUrlProvider urls() {

    return this.resourceUrlProvider;

  }
}
