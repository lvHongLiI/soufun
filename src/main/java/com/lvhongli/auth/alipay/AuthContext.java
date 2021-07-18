package com.lvhongli.auth.alipay;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
@PropertySource(value = {"classpath:/application.yml"}, encoding = "utf-8")
public class AuthContext {

    private Map<String,AuthHandler> authHandlerMap;

    @Value("#{${qrCodeType}}")
    private Map<String,String> map;

    public AuthContext(List<AuthHandler> authHandlers) {
       authHandlerMap=authHandlers.stream().collect(Collectors.toMap(v->v.state(),v->v));
    }


    public void login(String code, String type, HttpServletResponse response) throws IOException {
        authHandlerMap.get(type).login(code,response);
    }



    public ResponseEntity<Resource> getAuthLoginQRCode(String type) throws IOException {
        Resource resource = new ClassPathResource(map.get(type));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
