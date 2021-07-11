package com.lvhongli.auth.alipay;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class AuthContext {

    private Map<String,AuthHandler> authHandlerMap;

    public AuthContext(List<AuthHandler> authHandlers) {
       authHandlerMap=authHandlers.stream().collect(Collectors.toMap(v->v.state(),v->v));
    }


    public void login(String code, String type, HttpServletResponse response) throws IOException {
        authHandlerMap.get(type).login(code,response);
    }
}
